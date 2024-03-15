package cn.thatisme.blog.context.application;

import cn.thatisme.blog.common.domain.BaseService;
import cn.thatisme.blog.context.application.dto.CommentDto;
import cn.thatisme.blog.context.domain.comment.Comment;

/**
 * <p>用户查询service</p>
 * @author wujinhang 2023/8/15
 */
public interface CommentService extends BaseService<Comment, CommentDto> {
}
