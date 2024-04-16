package cn.thatisme.blog.context.interfaces;

import cn.thatisme.blog.context.application.command.UserLoginCommand;
import cn.thatisme.blog.context.application.dto.LoginUserDto;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;

/**
 * <p></p>
 * @author wujinhang me@thatisme.cn 2024/4/7
 */
@Controller
@RequiredArgsConstructor
public class LoginController {

    @Resource
    private AuthenticationManager authenticationManager;

    @PreAuthorize("isAnonymous()")
    @MutationMapping
    public LoginUserDto login(@Argument UserLoginCommand command) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(command.getUsername(), command.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);// 判断是否验证成功
        if (null == authentication) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        return new LoginUserDto(authentication);

    }
}
