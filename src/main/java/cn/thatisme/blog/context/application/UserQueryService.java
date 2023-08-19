package cn.thatisme.blog.context.application;

import cn.thatisme.blog.context.application.dto.UserDto;

/**
 * <p>用户查询service</p>
 * @author wujinhang 2023/8/15
 */
public interface UserQueryService {

    UserDto get(Long id);

}
