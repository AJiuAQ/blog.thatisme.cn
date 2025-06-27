package cn.thatisme.blog.context.infrastructure.persistence.repository.jpa;

import cn.thatisme.blog.common.domain.EntityConversion;
import cn.thatisme.blog.common.persistence.repository.BaseRepositoryJpa;
import cn.thatisme.blog.common.utils.ConversionServiceUtils;
import cn.thatisme.blog.context.application.command.UserCommand;
import cn.thatisme.blog.context.application.dto.UserDto;
import cn.thatisme.blog.context.domain.user.Email;
import cn.thatisme.blog.context.domain.user.User;
import cn.thatisme.blog.context.domain.user.UserRepository;
import cn.thatisme.blog.context.domain.user.Username;
import cn.thatisme.blog.context.infrastructure.persistence.po.UserPo;

/**
 * <p></p>
 * @author wujinhang 2023/8/16
 */
public interface UserRepositoryJpa extends UserRepository,
        BaseRepositoryJpa<UserPo, User> {
    @Override
    default EntityConversion entityConversion() {
        return new EntityConversion(UserDto.class, User.class, UserPo.class, UserCommand.class);
    }

    @Override
    default User get(Email email) {
        UserPo userPo = getUserPoByEmail(email.email());
        return (User) ConversionServiceUtils.convert(userPo, entityConversion().getEntity());
    }

    @Override
    default User get(Username username) {
        UserPo userPo = getUserPoByUsername(username.username());
        return (User) ConversionServiceUtils.convert(userPo, entityConversion().getEntity());
    }

    @Override
    default User updateTotpSecretByUsername(String username, String totpSecret) {
        UserPo userPoByUsername = getUserPoByUsername(username);
        userPoByUsername.setTotpSecret(totpSecret);
        return (User) ConversionServiceUtils.convert(save(userPoByUsername), entityConversion().getEntity());
    }

    UserPo getUserPoByEmail(String email);

    UserPo getUserPoByUsername(String username);
}
