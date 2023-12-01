package cn.thatisme.blog.context.application.impl;

import cn.thatisme.blog.common.utils.ConversionServiceUtils;
import cn.thatisme.blog.context.application.UserService;
import cn.thatisme.blog.context.application.command.UserCommand;
import cn.thatisme.blog.context.application.dto.UserDto;
import cn.thatisme.blog.context.application.query.UserQuery;
import cn.thatisme.blog.context.domain.user.User;
import cn.thatisme.blog.context.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p></p>
 * @author wujinhang 2023/8/15
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ConversionService conversionService;

    public UserDto get(Long id) {
        User user = userRepository.get(id);
        return conversionService.convert(user, UserDto.class);
    }

    @Override
    public Page<UserDto> page(UserQuery query) {
        Page<User> userPage = userRepository.page(query);
        Page<UserDto> userDtos = userPage.map(e -> ConversionServiceUtils.convert(e, UserDto.class));
        return userDtos;
    }

    @Override
    public UserDto store(UserCommand command) {
        User store = userRepository.store(ConversionServiceUtils.convert(command, User.class));
        return ConversionServiceUtils.convert(store, UserDto.class);
    }

    @Override
    public long delete(List<Long> ids) {
        return userRepository.remove(ids);
    }
}
