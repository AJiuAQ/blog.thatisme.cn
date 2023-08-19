package cn.thatisme.blog.context.infrastructure.persistence.repository;

import cn.thatisme.blog.common.persistence.repository.BaseRepositoryJpa;
import cn.thatisme.blog.common.utils.ConversionServiceUtils;
import cn.thatisme.blog.context.domain.user.Email;
import cn.thatisme.blog.context.domain.user.User;
import cn.thatisme.blog.context.domain.user.UserRepository;
import cn.thatisme.blog.context.infrastructure.persistence.po.UserPo;
import org.springframework.stereotype.Repository;

/**
 * <p></p>
 * @author wujinhang 2023/8/16
 */
@Repository
public interface UserRepositoryJpa extends UserRepository, BaseRepositoryJpa<UserPo, User> {

    @Override
    default Class<UserPo> upstreamType() {
        return UserPo.class;
    }

    @Override
    default Class<User> downstreamType() {
        return User.class;
    }

    @Override
    default User get(Email email) {
        assert downstreamType() != null;
        UserPo userPo = getUserPoByEmail(email.email());
        User converted = ConversionServiceUtils.convert(userPo, downstreamType());
        return converted;
    }

    UserPo getUserPoByEmail(String email);
}
