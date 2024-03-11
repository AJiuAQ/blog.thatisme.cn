package cn.thatisme.blog.context.infrastructure.converter;

import cn.thatisme.blog.common.mapstruct.ValueObjectStrategy;
import cn.thatisme.blog.context.domain.article.Article;
import cn.thatisme.blog.context.infrastructure.persistence.po.ArticlePo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

/**
 * <p></p>
 * @author wujinhang 2023/8/18
 */
@Mapper(componentModel = "spring", uses = ValueObjectStrategy.class)
public interface ArticlePoConverter extends Converter<ArticlePo, Article> {

    @Mapping(target = "auditor", source = "auditor.id")
    Article convert(ArticlePo po);
}
