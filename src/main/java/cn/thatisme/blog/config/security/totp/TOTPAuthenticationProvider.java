//package cn.thatisme.blog.config.security.totp;
//
//import cn.thatisme.blog.common.utils.TOTPUtils;
//import cn.thatisme.blog.config.security.SecurityUserDetails;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
//import org.springframework.stereotype.Component;
//
///**
// *
// */
//@Component
//public class TOTPAuthenticationProvider implements AuthenticationProvider {
//
//    @Override
//    public Authentication authenticate(Authentication authentication) {
//        PreAuthenticatedAuthenticationToken auth = (PreAuthenticatedAuthenticationToken) authentication;
//        SecurityUserDetails user = (SecurityUserDetails) auth.getPrincipal();
//
//        if (TOTPUtils.validateTotpCode(user.getTotpSecret(), (Integer) auth.getCredentials())) {
//            return new UsernamePasswordAuthenticationToken(
//                user, null, user.getAuthorities());
//        }
//        throw new BadCredentialsException("Invalid TOTP code");
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return PreAuthenticatedAuthenticationToken.class.isAssignableFrom(authentication);
//    }
//}