package cn.thatisme.blog.context.infrastructure.converter;

import cn.thatisme.blog.common.mapstruct.ValueObjectStrategy;
import cn.thatisme.blog.context.domain.comment.Comment;
import cn.thatisme.blog.context.infrastructure.persistence.po.CommentPo;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring", uses = ValueObjectStrategy.class)
public interface CommentConverter extends Converter<Comment, CommentPo> {

    CommentPo convert(Comment comment);
}