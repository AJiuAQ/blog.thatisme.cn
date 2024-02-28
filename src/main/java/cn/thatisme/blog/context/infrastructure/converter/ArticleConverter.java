package cn.thatisme.blog.context.infrastructure.converter;

import cn.thatisme.blog.context.domain.article.Article;
import cn.thatisme.blog.context.infrastructure.persistence.po.ArticlePo;
import jakarta.annotation.Nonnull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface ArticleConverter extends Converter<Article, ArticlePo> {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title.title", target = "title")
    ArticlePo convert(@Nonnull Article article);
}