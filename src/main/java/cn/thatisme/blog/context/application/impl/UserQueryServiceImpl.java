package cn.thatisme.blog.context.application.impl;

import cn.thatisme.blog.common.domain.ID;
import cn.thatisme.blog.common.utils.ConversionServiceUtils;
import cn.thatisme.blog.context.application.UserQueryService;
import cn.thatisme.blog.context.application.dto.UserDto;
import cn.thatisme.blog.context.domain.user.User;
import cn.thatisme.blog.context.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * <p></p>
 * @author wujinhang 2023/8/15
 */
@Service
@RequiredArgsConstructor
public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;
    private final ConversionService conversionService;

    public UserDto get(Long id) {
        User user = userRepository.get(new ID(id));
        return conversionService.convert(user, UserDto.class);
    }

    @Override
    public Page<UserDto> page(UserDto userDto, Pageable page) {
        Page<User> userPage = userRepository.page(page);
        Page<UserDto> userDtos = userPage.map(e -> ConversionServiceUtils.convert(e, UserDto.class));
        return userDtos;
    }
}
