package cn.thatisme.blog.context.application.assembler;

import cn.thatisme.blog.common.mapstruct.ValueObjectStrategy;
import cn.thatisme.blog.context.application.dto.ArticleDto;
import cn.thatisme.blog.context.application.dto.LabelDto;
import cn.thatisme.blog.context.domain.article.Article;
import cn.thatisme.blog.context.domain.label.Label;
import cn.thatisme.blog.context.domain.label.LabelName;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

/**
 * <p></p>
 * @author wujinhang 2023/8/17
 */
@Mapper(componentModel = "spring", uses = ValueObjectStrategy.class)
public interface ArticleDtoAssembler extends Converter<Article, ArticleDto> {

    ArticleDto convert(Article article);
}
