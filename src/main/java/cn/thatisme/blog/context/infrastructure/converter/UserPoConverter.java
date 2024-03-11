package cn.thatisme.blog.context.infrastructure.converter;

import cn.thatisme.blog.common.mapstruct.ValueObjectStrategy;
import cn.thatisme.blog.context.domain.user.User;
import cn.thatisme.blog.context.infrastructure.persistence.po.UserPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

/**
 * <p></p>
 * @author wujinhang 2023/8/18
 */
@Mapper(componentModel = "spring", uses = ValueObjectStrategy.class)
public interface UserPoConverter extends Converter<UserPo, User> {

    @Mapping(source = "username", target = "account.username.username")
    @Mapping(source = "email", target = "account.email.email")
    @Mapping(source = "password", target = "account.password.password")
    User convert(UserPo po);
}
