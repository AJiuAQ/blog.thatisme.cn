package cn.thatisme.blog.config.security;

import lombok.Getter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Spring Security 模拟数据
 */
public class SecurityConstant {

    public static final String ROLE_PREFIX = "ROLE_";

    /**
     * TOTP token 受众 key
     */
    public static final String TOTP_AUDIENCE = "TOTP";

    /**
     * 模拟用户数据。key：用户名，value：密码
     */
    public static final Map<String, String> USER_MAP = new ConcurrentHashMap<>();
    /**
     * 模拟权限数据。key：接口地址，value：所需权限
     */
    public static final Map<String, ConfigAttribute> PERMISSION_MAP = new ConcurrentHashMap<>();
    /**
     * 用户权限数据。key：用户名，value：权限
     */
    public static final Map<String, List<PERMISSION>> USER_PERMISSION_MAP = new ConcurrentHashMap<>();
    /**
     * 白名单
     */
    public static final String[] WHITELIST = {"/login"};


    static {
        // 填充模拟用户数据
        USER_MAP.put("admin", "$2a$10$NcEOK0AGoDMViXlCNi0qnO74S.uuLMubvKaqdQZKjk00iu9sa1sv.");
        USER_MAP.put("user", "$2a$10$NcEOK0AGoDMViXlCNi0qnO74S.uuLMubvKaqdQZKjk00iu9sa1sv.");
        // 填充用户权限
        USER_PERMISSION_MAP.put("admin", List.of(PERMISSION.ADMIN, PERMISSION.USER));
        USER_PERMISSION_MAP.put("user", List.of(PERMISSION.USER));
        // 填充接口权限
        PERMISSION_MAP.put("/user", new SecurityConfig(PERMISSION.USER.getValue()));
        PERMISSION_MAP.put("/admin", new SecurityConfig(PERMISSION.ADMIN.getValue()));
    }

    public final static String ADMIN = "ADMIN";
    public final static String USER = "USER";
    public final static String ANONYMOUS = "ANONYMOUS";

    /**
     * 模拟权限
     */
    @Getter
    public enum PERMISSION {
        ADMIN(SecurityConstant.ADMIN),
        USER(SecurityConstant.USER),
        ANONYMOUS(SecurityConstant.ANONYMOUS);

        private final String value;


        PERMISSION(String value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("123456"));
    }
}
