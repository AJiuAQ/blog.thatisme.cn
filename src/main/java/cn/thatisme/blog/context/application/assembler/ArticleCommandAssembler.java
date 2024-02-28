package cn.thatisme.blog.context.application.assembler;

import cn.thatisme.blog.context.application.command.ArticleCommand;
import cn.thatisme.blog.context.domain.article.Article;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

/**
 * <p></p>
 * @author wujinhang 2023/8/17
 */
@Mapper(componentModel = "spring")
public interface ArticleCommandAssembler extends Converter<ArticleCommand, Article> {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "title.title", source = "title")
    @Mapping(target = "content.content", source = "content")
    @Mapping(target = "auditor", source = "auditor")
    Article convert(ArticleCommand article);
}
