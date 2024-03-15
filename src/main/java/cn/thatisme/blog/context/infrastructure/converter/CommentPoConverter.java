package cn.thatisme.blog.context.infrastructure.converter;

import cn.thatisme.blog.common.mapstruct.ValueObjectStrategy;
import cn.thatisme.blog.context.domain.comment.Comment;
import cn.thatisme.blog.context.infrastructure.persistence.po.CommentPo;
import jakarta.annotation.Nonnull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

/**
 * <p></p>
 * @author wujinhang 2023/8/18
 */
@Mapper(componentModel = "spring", uses = ValueObjectStrategy.class)
public interface CommentPoConverter extends Converter<CommentPo, Comment> {

    Comment convert(@Nonnull CommentPo po);
}
