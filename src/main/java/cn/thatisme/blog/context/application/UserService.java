package cn.thatisme.blog.context.application;

import cn.thatisme.blog.context.application.command.UserCommand;
import cn.thatisme.blog.context.application.dto.UserDto;
import cn.thatisme.blog.context.application.query.UserQuery;
import org.springframework.data.domain.Page;

/**
 * <p>用户查询service</p>
 * @author wujinhang 2023/8/15
 */
public interface UserService {

    UserDto get(Long id);

    Page<UserDto> page(UserQuery query);

    UserDto store(UserCommand command);

}
