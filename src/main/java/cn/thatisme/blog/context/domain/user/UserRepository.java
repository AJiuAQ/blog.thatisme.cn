package cn.thatisme.blog.context.domain.user;

import cn.thatisme.blog.common.domain.BaseRepository;
import cn.thatisme.blog.context.infrastructure.persistence.po.UserPo;

/**
 * <p></p>
 * @author wujinhang 2023/8/15
 */
public interface UserRepository extends BaseRepository<UserPo, User> {

    User get(Email email);
}
