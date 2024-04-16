package cn.thatisme.blog.context.interfaces;

import cn.thatisme.blog.common.graphql.pageable.DeleteResult;
import cn.thatisme.blog.common.graphql.pageable.PageResult;
import cn.thatisme.blog.config.security.SecurityConstant;
import cn.thatisme.blog.context.application.CommentService;
import cn.thatisme.blog.context.application.command.CommentCommand;
import cn.thatisme.blog.context.application.dto.CommentDto;
import cn.thatisme.blog.context.application.query.CommentQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p></p>
 * @author wujinhang 2023/10/9
 */
@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @QueryMapping
    public CommentDto commentById(@Argument Long id) {
        return commentService.get(id);
    }

    @QueryMapping
    public PageResult<CommentDto> commentPage(@Argument CommentQuery query) {
        Page<CommentDto> page = commentService.page(query);
        return new PageResult<>(page.getContent(), page.getTotalElements());
    }

    @PreAuthorize("isAuthenticated()")
    @MutationMapping
    public CommentDto commentSaveOrUpdate(@Argument CommentCommand command) {
        return commentService.store(command);
    }

    @PreAuthorize("hasRole('" + SecurityConstant.ADMIN + "')")
    @MutationMapping
    public DeleteResult commentDelete(@Argument List<Long> ids) {
        return commentService.delete(ids);
    }

}
