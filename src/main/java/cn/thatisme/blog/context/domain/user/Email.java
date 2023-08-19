package cn.thatisme.blog.context.domain.user;

import cn.hutool.core.lang.Assert;
import cn.thatisme.blog.common.domain.ValueObject;

/**
 * <p></p>
 * @author wujinhang 2023/4/18
 */
public record Email(String email) implements ValueObject<Email> {
    public Email {
        Assert.notBlank(email, "邮箱不能为空");
    }
}
