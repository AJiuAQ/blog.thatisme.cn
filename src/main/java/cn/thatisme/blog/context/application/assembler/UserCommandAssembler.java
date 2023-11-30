package cn.thatisme.blog.context.application.assembler;

import cn.thatisme.blog.context.application.command.UserCommand;
import cn.thatisme.blog.context.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

/**
 * <p></p>
 * @author wujinhang 2023/8/17
 */
@Mapper(componentModel = "spring")
public interface UserCommandAssembler extends Converter<UserCommand, User> {

    @Mapping(target = "id.id", source = "id")
    @Mapping(target = "account.username.username", source = "username")
    @Mapping(target = "account.email.email", source = "email")
    User convert(UserCommand user);
}
