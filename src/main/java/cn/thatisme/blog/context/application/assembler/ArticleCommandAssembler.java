package cn.thatisme.blog.context.application.assembler;

import cn.thatisme.blog.common.mapstruct.ValueObjectStrategy;
import cn.thatisme.blog.context.application.command.ArticleCommand;
import cn.thatisme.blog.context.domain.article.Article;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

/**
 * <p></p>
 * @author wujinhang 2023/8/17
 */
@Mapper(componentModel = "spring", uses = ValueObjectStrategy.class)
public interface ArticleCommandAssembler extends Converter<ArticleCommand, Article> {

    Article convert(ArticleCommand article);
}
