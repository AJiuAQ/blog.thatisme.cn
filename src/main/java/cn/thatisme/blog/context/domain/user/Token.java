package cn.thatisme.blog.context.domain.user;

import cn.hutool.core.lang.Assert;
import cn.thatisme.blog.common.domain.ValueObject;

import java.util.Date;

/**
 * <p></p>
 * @author wujinhang 2022/4/13
 */
public record Token(String token) implements ValueObject<Token> {

    public Token {
        Assert.notBlank(token, "token不能为空");
    }

    @Override
    public boolean sameValueAs(Token that) {
        return that != null && this.token.equals(that.token);
    }
}
