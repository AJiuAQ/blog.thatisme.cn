package cn.thatisme.blog.context.application;

import cn.thatisme.blog.common.domain.BaseService;
import cn.thatisme.blog.context.application.dto.ArticleDto;
import cn.thatisme.blog.context.domain.article.Article;

/**
 * <p>用户查询service</p>
 * @author wujinhang 2023/8/15
 */
public interface ArticleService extends BaseService<Article, ArticleDto> {
}
