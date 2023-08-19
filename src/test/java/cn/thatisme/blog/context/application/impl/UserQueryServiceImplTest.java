package cn.thatisme.blog.context.application.impl;

import cn.thatisme.blog.common.domain.ID;
import cn.thatisme.blog.context.application.UserQueryService;
import cn.thatisme.blog.context.application.dto.UserDto;
import cn.thatisme.blog.context.domain.user.Email;
import cn.thatisme.blog.context.domain.user.User;
import cn.thatisme.blog.context.domain.user.UserRepository;
import cn.thatisme.blog.context.domain.user.Username;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;

/**
 * <p></p>
 * @author wujinhang 2023/8/17
 */
@SpringBootTest()
class UserQueryServiceImplTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserQueryService userQueryService;

    @Test
    void get() {
        User mockUser = new User(new ID(1L), new Username("zhangsan"), new Email("a@a.cn"));
        when(userRepository.get(any(ID.class))).thenReturn(mockUser);
        UserDto userDto = userQueryService.get(1L);
        verify(userRepository, times(1)).get(any(ID.class));
        System.out.println(userDto);
    }
}
