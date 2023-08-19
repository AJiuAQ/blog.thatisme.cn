package cn.thatisme.blog.context.domain.user;

import cn.hutool.core.lang.Assert;
import cn.thatisme.blog.common.domain.ValueObject;

import java.util.Date;

/**
 * <p></p>
 * @author wujinhang 2022/4/13
 */
public record Token(String token, Date expireTime, int expirePeriod) implements ValueObject<Token> {

    /**
     * token 过期时间 毫秒
     */
    private static final long TOKEN_EXPIRE_PERIOD = 60 * 60 * 1000;

    public Token {
        Assert.notBlank(token, "令牌生成失败");
    }

    public Token(String token, Date expireTime) {
        this(token, expireTime, 0);
    }

    public static Token create(String tokenStr) {
        //12小时后过期
        int expirePeriod = 3600 * 12;
        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + TOKEN_EXPIRE_PERIOD);
        return new Token(tokenStr,expireTime, expirePeriod);
    }

    /**
     * token 是否有效
     * @return false 无效 | true 有效
     */
    public boolean isTokenValid() {
        return token != null && expireTime()!= null &&
                expireTime().getTime() >= System.currentTimeMillis();
    }

    @Override
    public boolean sameValueAs(Token that) {
        return that != null && this.token.equals(that.token);
    }
}
