package cn.thatisme.blog.context.application;

import cn.thatisme.blog.common.domain.BaseService;
import cn.thatisme.blog.context.application.dto.UserDto;
import cn.thatisme.blog.context.domain.user.User;

/**
 * <p>用户查询service</p>
 * @author wujinhang 2023/8/15
 */
public interface UserService extends BaseService<User, UserDto> {
}
