package cn.thatisme.blog.context.domain.article;

import cn.hutool.core.lang.Assert;

/**
 * <p>标题</p>
 * @author wujinhang 2023/8/14
 */
public record Title(String title) {
    public Title {
        Assert.notBlank(title, "文章标题不能为空");
    }
}
