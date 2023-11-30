package cn.thatisme.blog.context.interfaces.user;

import cn.thatisme.blog.common.graphql.pageable.PageResult;
import cn.thatisme.blog.context.application.UserService;
import cn.thatisme.blog.context.application.command.UserCommand;
import cn.thatisme.blog.context.application.dto.UserDto;
import cn.thatisme.blog.context.application.query.UserQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

/**
 * <p></p>
 * @author wujinhang 2023/10/9
 */
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @QueryMapping
    public UserDto userById(@Argument Long id) {
        return userService.get(id);
    }

    @QueryMapping
    public PageResult<UserDto> userPage(@Argument UserQuery query) {
        Page<UserDto> page = userService.page(query);
        return new PageResult<>(page.getContent(), page.getTotalElements());
    }

    @MutationMapping
    public UserDto userSave(@Argument UserCommand command) {
        return userService.store(command);
    }

    @MutationMapping
    public UserDto userUpdate(@Argument UserCommand command) {
        return userService.store(command);
    }
}
