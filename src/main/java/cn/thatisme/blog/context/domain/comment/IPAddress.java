package cn.thatisme.blog.context.domain.comment;

import cn.hutool.core.lang.Assert;
import cn.thatisme.blog.common.domain.ValueObject;

/**
 * <p></p>
 * @author wujinhang 2023/8/15
 */
public record IPAddress(String ip) implements ValueObject<IPAddress> {

    public IPAddress {
        Assert.notBlank(ip, "ip地址不能为空");
    }
}
