package cn.thatisme.blog.context.application.dto;

import cn.thatisme.blog.config.security.JwtUtils;
import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * <p></p>
 * @author wujinhang me@thatisme.cn 2024/4/7
 */
@Data
public class LoginUserDto {

    private String token;

    private String username;

    public LoginUserDto(Authentication authentication) {
        if (null == authentication) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        token = JwtUtils.generateToken(authentication.getName());
        username = authentication.getName();
    }
}
