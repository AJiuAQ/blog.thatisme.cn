package cn.thatisme.blog.context.infrastructure.converter;

import cn.thatisme.blog.context.domain.article.Article;
import cn.thatisme.blog.context.infrastructure.persistence.po.ArticlePo;
import jakarta.annotation.Nonnull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

/**
 * <p></p>
 * @author wujinhang 2023/8/18
 */
@Mapper(componentModel = "spring")
public interface ArticltPoConverter extends Converter<ArticlePo, Article> {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title.title")
    Article convert(@Nonnull ArticlePo po);
}
