package cn.thatisme.blog.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * <p></p>
 * @author wujinhang 2025/3/3
 */
@Component
public class AnonymousService {

    public boolean anonymous() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication == null || authentication.getName().equals("anonymousUser");
    }
}
