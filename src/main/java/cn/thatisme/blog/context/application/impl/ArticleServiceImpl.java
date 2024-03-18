package cn.thatisme.blog.context.application.impl;

import cn.thatisme.blog.common.domain.BaseRepository;
import cn.thatisme.blog.context.application.ArticleService;
import cn.thatisme.blog.context.domain.article.Article;
import cn.thatisme.blog.context.domain.article.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p></p>
 * @author wujinhang me@thatisme.cn 2023/12/13
 */
@Service
@RequiredArgsConstructor
@Transactional
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public BaseRepository<Article> repository() {
        return articleRepository;
    }
}
