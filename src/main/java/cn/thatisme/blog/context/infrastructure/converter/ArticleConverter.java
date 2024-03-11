package cn.thatisme.blog.context.infrastructure.converter;

import cn.thatisme.blog.common.mapstruct.ValueObjectStrategy;
import cn.thatisme.blog.context.domain.article.Article;
import cn.thatisme.blog.context.infrastructure.persistence.po.ArticlePo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring", uses = ValueObjectStrategy.class)
public interface ArticleConverter extends Converter<Article, ArticlePo> {

    @Mapping(source = "auditor", target = "auditor.id")
    ArticlePo convert(Article article);
}