package cn.thatisme.blog.context.infrastructure.persistence.repository.jpa;

import cn.thatisme.blog.common.persistence.repository.BaseRepositoryJpa;
import cn.thatisme.blog.context.domain.comment.Comment;
import cn.thatisme.blog.context.domain.comment.CommentRepository;
import cn.thatisme.blog.context.infrastructure.persistence.po.CommentPo;

/**
 * <p></p>
 * @author wujinhang 2023/8/16
 */
public interface CommentRepositoryJpa extends CommentRepository,
        BaseRepositoryJpa<CommentPo, Comment> {

    @Override
    default Class<CommentPo> upstreamType() {
        return CommentPo.class;
    }

    @Override
    default Class<Comment> downstreamType() {
        return Comment.class;
    }
}
