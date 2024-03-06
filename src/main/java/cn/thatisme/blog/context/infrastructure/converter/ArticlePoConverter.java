package cn.thatisme.blog.context.infrastructure.converter;

import cn.thatisme.blog.context.domain.article.Article;
import cn.thatisme.blog.context.domain.label.LabelName;
import cn.thatisme.blog.context.infrastructure.persistence.po.ArticlePo;
import cn.thatisme.blog.context.infrastructure.persistence.po.UserPo;
import jakarta.annotation.Nonnull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

/**
 * <p></p>
 * @author wujinhang 2023/8/18
 */
@Mapper(componentModel = "spring")
public interface ArticlePoConverter extends Converter<ArticlePo, Article> {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title.title")
    @Mapping(source = "content", target = "content.content")
    Article convert(@Nonnull ArticlePo po);
    LabelName map(String value);

    default Long map(UserPo value) {
        return value.getId();
    }
}
