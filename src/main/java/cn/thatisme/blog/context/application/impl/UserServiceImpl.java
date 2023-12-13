package cn.thatisme.blog.context.application.impl;

import cn.thatisme.blog.common.domain.BaseRepository;
import cn.thatisme.blog.context.application.UserService;
import cn.thatisme.blog.context.domain.user.User;
import cn.thatisme.blog.context.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p></p>
 * @author wujinhang 2023/8/15
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public BaseRepository<User> repository() {
        return userRepository;
    }
}
