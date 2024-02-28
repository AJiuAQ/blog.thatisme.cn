package cn.thatisme.blog.context.domain.article;

import cn.thatisme.blog.common.domain.ValueObject;

/**
 * <p>正文</p>
 * @author wujinhang 2023/8/14
 */
public record ArticleContent(String content) implements ValueObject<ArticleContent> {
}

