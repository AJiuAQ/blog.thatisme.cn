package cn.thatisme.blog.context.application.assembler;

import cn.thatisme.blog.context.application.dto.UserDto;
import cn.thatisme.blog.context.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

/**
 * <p></p>
 * @author wujinhang 2023/8/17
 */
@Mapper(componentModel = "spring")
public interface UserDtoAssembler extends Converter<User, UserDto> {

    @Mapping(target = "id", source = "id.id")
    @Mapping(target = "username", source = "account.username.username")
    @Mapping(target = "email", source = "account.email.email")
    UserDto convert(User user);
}
