package cn.thatisme.blog.context.interfaces.user;

import cn.thatisme.blog.context.application.UserQueryService;
import cn.thatisme.blog.context.application.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

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
    public List<UserDto> userList(@Argument UserDto userDto, @Argument PageRequest page) {
        return  new ArrayList<>();
        //return userQueryService.page(userDto, page);
    }

}
