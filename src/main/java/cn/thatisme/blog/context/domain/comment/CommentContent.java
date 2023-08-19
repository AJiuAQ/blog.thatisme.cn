package cn.thatisme.blog.context.domain.comment;

import cn.thatisme.blog.common.domain.ValueObject;

/**
 * <p>正文</p>
 * @author wujinhang 2023/8/14
 */
public record CommentContent(String content) implements ValueObject<CommentContent> {
}
