package cn.thatisme.blog.context.interfaces.user;

import cn.thatisme.blog.common.graphql.pageable.PageInfo;
import cn.thatisme.blog.common.graphql.pageable.PageResult;
import cn.thatisme.blog.context.application.UserQueryService;
import cn.thatisme.blog.context.application.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
    public PageResult<UserDto> userPage(@Argument UserDto userDto, @Argument PageInfo pageInfo) {
        Page<UserDto> page = userQueryService.page(userDto, pageInfo);
        PageResult<UserDto> result = new PageResult<>(page.getContent(), page.getTotalElements());
        return result;
    }

}
