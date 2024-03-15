package cn.thatisme.blog.context.application.impl;

import cn.thatisme.blog.common.domain.BaseRepository;
import cn.thatisme.blog.context.application.CommentService;
import cn.thatisme.blog.context.domain.comment.Comment;
import cn.thatisme.blog.context.domain.comment.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p></p>
 * @author wujinhang me@thatisme.cn 2023/12/13
 */
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public BaseRepository<Comment> repository() {
        return commentRepository;
    }
}
