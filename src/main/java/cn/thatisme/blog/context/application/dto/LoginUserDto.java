package cn.thatisme.blog.context.application.dto;

import cn.thatisme.blog.config.security.JwtUtils;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * <p></p>
 * @author wujinhang me@thatisme.cn 2024/4/7
 */
@Data
@NoArgsConstructor
public class LoginUserDto {

    private String token;

    private String username;

    /**
     * 是否已经配置了 totp
     */
    private boolean totp;

    public LoginUserDto(Authentication authentication) {
        this(authentication, false);
    }

    public LoginUserDto(Authentication authentication, boolean totp) {
        if (totp) {
            token = JwtUtils.generateTOTPToken(authentication.getName());
        } else {
            token = JwtUtils.generateToken(authentication.getName());
        }
        username = authentication.getName();
    }

}
