package cn.thatisme.blog.context.domain.user;

import cn.thatisme.blog.common.domain.BaseRepository;

/**
 * <p></p>
 * @author wujinhang 2023/8/15
 */
public interface UserRepository extends BaseRepository<User> {

    User get(Email email);
}
