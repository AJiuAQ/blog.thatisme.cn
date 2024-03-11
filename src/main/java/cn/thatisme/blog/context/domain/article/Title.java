package cn.thatisme.blog.context.domain.article;

import cn.hutool.core.lang.Assert;
import cn.thatisme.blog.common.domain.ValueObject;

/**
 * <p>标题</p>
 * @author wujinhang 2023/8/14
 */
public record Title(String title) implements ValueObject<Title> {
    public Title {
        Assert.notBlank(title, "文章标题不能为空");
    }
}
