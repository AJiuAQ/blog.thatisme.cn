package cn.thatisme.blog.context.interfaces;

import cn.thatisme.blog.common.graphql.pageable.PageResult;
import cn.thatisme.blog.context.application.ArticleService;
import cn.thatisme.blog.context.application.command.ArticleCommand;
import cn.thatisme.blog.context.application.dto.ArticleDto;
import cn.thatisme.blog.context.application.query.ArticleQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p></p>
 * @author wujinhang 2023/10/9
 */
@Controller
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @QueryMapping
    public ArticleDto articleById(@Argument Long id) {
        return articleService.get(id);
    }

    @QueryMapping
    public PageResult<ArticleDto> articlePage(@Argument ArticleQuery query) {
        Page<ArticleDto> page = articleService.page(query);
        return new PageResult<>(page.getContent(), page.getTotalElements());
    }

    @MutationMapping
    public ArticleDto articleSaveOrUpdate(@Argument ArticleCommand command) {
        return articleService.store(command);
    }

    @MutationMapping
    public long articleDelete(@Argument List<Long> ids) {
        return articleService.delete(ids);
    }

}
