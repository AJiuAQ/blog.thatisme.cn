package cn.thatisme.blog.config.security;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * JWT 配置
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {

    private String secret;

    private String issuer;

    private long expirationTime;

    private String header;

    private String tokenHead;

    @PostConstruct
    public void jwtInit() {
        JwtUtils.initialize(header, tokenHead, issuer, secret, expirationTime);
        log.info("JwtUtils初始化完成");
    }
}
