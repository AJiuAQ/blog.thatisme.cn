package cn.thatisme.blog.context.infrastructure.persistence.repository.jpa;

import cn.thatisme.blog.common.domain.EntityConversion;
import cn.thatisme.blog.common.persistence.repository.BaseRepositoryJpa;
import cn.thatisme.blog.context.application.command.ArticleCommand;
import cn.thatisme.blog.context.application.dto.ArticleDto;
import cn.thatisme.blog.context.domain.article.Article;
import cn.thatisme.blog.context.domain.article.ArticleRepository;
import cn.thatisme.blog.context.infrastructure.persistence.po.ArticlePo;

/**
 * <p></p>
 * @author wujinhang 2023/8/16
 */
public interface ArticleRepositoryJpa extends ArticleRepository,
        BaseRepositoryJpa<ArticlePo, Article> {

    @Override
    default EntityConversion entityConversion() {
        return new EntityConversion(ArticleDto.class, Article.class, ArticlePo.class, ArticleCommand.class);
    }
}
