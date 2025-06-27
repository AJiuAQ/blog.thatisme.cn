package cn.thatisme.blog.config.security;
    
import cn.thatisme.blog.context.domain.user.User;
import cn.thatisme.blog.context.domain.user.UserRepository;
import cn.thatisme.blog.context.domain.user.Username;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SecurityUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 获取用户信息
        User user = userRepository.get(new Username(username));
        if (user == null || user.getAccount() == null
                || user.getAccount().password() == null) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        String password = user.getAccount().password().password();
        String totpSecret = user.getAccount().totpSecret() == null ? null : user.getAccount().totpSecret().totpSecret();

        // 获取用户权限
        // 返回SecurityUserDetails
        return SecurityUserDetails.builder()
                .username(username)
                .password(password)
                .totpSecret(totpSecret)
                .permissions(null)
                .build();
    }
}
