package cn.thatisme.blog.context.infrastructure.converter;

import cn.thatisme.blog.context.domain.user.User;
import cn.thatisme.blog.context.infrastructure.persistence.po.UserPo;
import jakarta.annotation.Nonnull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

/**
 * <p></p>
 * @author wujinhang 2023/8/18
 */
@Mapper(componentModel = "spring")
public interface UserPoConverter extends Converter<UserPo, User> {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "username", target = "account.username.username")
    @Mapping(source = "email", target = "account.email.email")
    @Mapping(source = "password", target = "account.password.password")
    User convert(@Nonnull UserPo po);
}
