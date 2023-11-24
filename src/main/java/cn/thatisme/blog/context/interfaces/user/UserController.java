package cn.thatisme.blog.context.interfaces.user;

import cn.thatisme.blog.context.application.UserQueryService;
import cn.thatisme.blog.context.application.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

/**
 * <p></p>
 * @author wujinhang 2023/10/9
 */
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserQueryService userQueryService;

    @QueryMapping
    public UserDto userById(@Argument Long id) {
        UserDto userDto = userQueryService.get(id);
        return userDto;
    }

    @QueryMapping
    public Page<UserDto> userList(@Argument UserDto userDto, @Argument int page, @Argument int size, Sort sort) {
        return userQueryService.page(userDto, PageRequest.of(page, size, sort));
    }

}
