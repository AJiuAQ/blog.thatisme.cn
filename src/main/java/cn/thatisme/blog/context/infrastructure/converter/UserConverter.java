package cn.thatisme.blog.context.infrastructure.converter;

import cn.thatisme.blog.common.mapstruct.ValueObjectStrategy;
import cn.thatisme.blog.context.domain.user.User;
import cn.thatisme.blog.context.infrastructure.persistence.po.UserPo;
import jakarta.annotation.Nonnull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring", uses = ValueObjectStrategy.class)
public interface UserConverter extends Converter<User, UserPo> {

    @Mapping(source = "account.username.username", target = "username")
    @Mapping(source = "account.email.email", target = "email")
    @Mapping(source = "account.password.password", target = "password")
    @Mapping(source = "account.totpSecret.totpSecret", target = "totpSecret")
    UserPo convert(@Nonnull User user);
}