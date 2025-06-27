package cn.thatisme.blog.context.interfaces;

import cn.hutool.core.util.StrUtil;
import cn.thatisme.blog.common.utils.RedisUtils;
import cn.thatisme.blog.common.utils.TOTPUtils;
import cn.thatisme.blog.config.security.SecurityUserDetails;
import cn.thatisme.blog.config.security.SecurityUserDetailsService;
import cn.thatisme.blog.context.application.UserService;
import cn.thatisme.blog.context.application.command.UserLoginCommand;
import cn.thatisme.blog.context.application.command.UserLoginTotpCommand;
import cn.thatisme.blog.context.application.dto.LoginUserDto;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;

import java.security.NoSuchAlgorithmException;

/**
 * <p>用户登录</p>
 * @author wujinhang me@thatisme.cn 2024/4/7
 */
@Controller
@RequiredArgsConstructor
public class LoginController {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private SecurityUserDetailsService securityUserDetailsService;

    @Resource
    private UserService userService;

    /**
     * 使用用户名密码登录
     * @param command 用户名、密码
     * @return TOTP 临时token
     */
    @PreAuthorize("permitAll()")
    @MutationMapping
    public LoginUserDto login(@Argument UserLoginCommand command) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(command.getUsername(), command.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);// 判断是否验证成功
        if (null == authentication) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        SecurityUserDetails userDetails = (SecurityUserDetails) securityUserDetailsService.loadUserByUsername(authentication.getName());
        LoginUserDto loginUserDto = new LoginUserDto(authentication, true);
        loginUserDto.setTotp(StrUtil.isNotBlank(userDetails.getTotpSecret()));
        return loginUserDto;
    }

    /**
     * totp 验证码认证
     * @param command 验证码
     * @return 真实token
     */
    @PreAuthorize("!@anonymousService.anonymous()")
    @MutationMapping
    public LoginUserDto loginTotp(@Argument UserLoginTotpCommand command) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecurityUserDetails userDetails = (SecurityUserDetails) securityUserDetailsService.loadUserByUsername(authentication.getName());

        Integer code = command.getCode();
        boolean result = TOTPUtils.validateTotpCode(userDetails.getTotpSecret(), code);
        if (!result) {
            throw new BadCredentialsException("验证码验证失败");
        }
        return new LoginUserDto(authentication);
    }

    /**
     * 获取 totp 二维码
     */
    @PreAuthorize("!@anonymousService.anonymous()")
    @QueryMapping
    public String qrBase64() throws NoSuchAlgorithmException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String secret = TOTPUtils.generateTotpSecret();
        RedisUtils.set( "totp:" + authentication.getName(), secret, 300);
        return TOTPUtils.generateQrCodeBase64(secret, authentication.getName());
    }

    /**
     * 绑定 totp
     */
    @PreAuthorize("!@anonymousService.anonymous()")
    @MutationMapping
    public boolean bindTotp() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String totp = RedisUtils.get("totp:" + authentication.getName());
        if (StrUtil.isBlank(totp)) {
            return false;
        }
        userService.updateTotpSecretByUsername(authentication.getName(), totp);
        RedisUtils.delete( "totp:" + authentication.getName());
        return true;
    }
}
