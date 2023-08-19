package cn.thatisme.blog.context.domain.user;

import cn.hutool.core.lang.Assert;
import cn.thatisme.blog.common.domain.ValueObject;

/**
 * <p></p>
 * @author wujinhang 2023/4/18
 */
public record Username(String username) implements ValueObject<Username> {
    public Username {
        Assert.notBlank(username, "用户名不能为空");
    }
}
