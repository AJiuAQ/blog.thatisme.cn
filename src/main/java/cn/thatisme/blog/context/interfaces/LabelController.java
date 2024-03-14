package cn.thatisme.blog.context.interfaces;

import cn.thatisme.blog.common.graphql.pageable.DeleteResult;
import cn.thatisme.blog.common.graphql.pageable.PageResult;
import cn.thatisme.blog.context.application.LabelService;
import cn.thatisme.blog.context.application.command.LabelCommand;
import cn.thatisme.blog.context.application.dto.LabelDto;
import cn.thatisme.blog.context.application.query.LabelQuery;
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
public class LabelController {

    private final LabelService labelService;

    @QueryMapping
    public LabelDto labelById(@Argument Long id) {
        return labelService.get(id);
    }

    @QueryMapping
    public PageResult<LabelDto> labelPage(@Argument LabelQuery query) {
        Page<LabelDto> page = labelService.page(query);
        return new PageResult<>(page.getContent(), page.getTotalElements());
    }

    @MutationMapping
    public LabelDto labelSaveOrUpdate(@Argument LabelCommand command) {
        return labelService.store(command);
    }

    @MutationMapping
    public DeleteResult labelDelete(@Argument List<Long> ids) {
        return labelService.delete(ids);
    }

}
