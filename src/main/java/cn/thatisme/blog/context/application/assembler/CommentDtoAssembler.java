package cn.thatisme.blog.context.application.assembler;

import cn.thatisme.blog.common.mapstruct.ValueObjectStrategy;
import cn.thatisme.blog.context.application.dto.CommentDto;
import cn.thatisme.blog.context.domain.comment.Comment;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

/**
 * <p></p>
 * @author wujinhang 2023/8/17
 */
@Mapper(componentModel = "spring", uses = ValueObjectStrategy.class)
public interface CommentDtoAssembler extends Converter<Comment, CommentDto> {

    CommentDto convert(Comment comment);
}
