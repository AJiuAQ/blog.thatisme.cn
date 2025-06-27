package cn.thatisme.blog.config.security.totp;

import cn.hutool.core.collection.CollectionUtil;
import cn.thatisme.blog.config.security.JwtUtils;
import cn.thatisme.blog.config.security.SecurityConstant;
import cn.thatisme.blog.context.domain.user.Token;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class TOTPAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String requestToken = request.getHeader(JwtUtils.getCurrentConfig().getHeader());
        Authentication preAuthentication = SecurityContextHolder.getContext().getAuthentication();
        // 读取请求头中的token
        if (StringUtils.isNotBlank(requestToken) && preAuthentication == null) {
            // 判断token是否有效
            boolean verifyToken = JwtUtils.isValidToken(requestToken);
            if (!verifyToken) {
                filterChain.doFilter(request, response);
            }
            // 如果 token aud 中有  SecurityConstant.TOTP_AUDIENCE TOTP 标记
            List<String> audiences = JwtUtils.getAudience(requestToken);
            if (!CollectionUtil.contains(audiences, SecurityConstant.TOTP_AUDIENCE)) {
                filterChain.doFilter(request, response);
            }
            // 解析token中的用户信息
            String subject = JwtUtils.getSubject(requestToken);
            if (StringUtils.isNotBlank(subject)) {

                // SecurityUserDetails userDetails = (SecurityUserDetails) securityUserDetailsService.loadUserByUsername(subject);
                // 保存用户信息到当前会话
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                subject,
                                null,
                                null);
                // totp 临时 token，所以标记为为认证
                authentication.setAuthenticated(false);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }
}