package cn.thatisme.blog.context.application.impl;

import cn.thatisme.blog.common.domain.ID;
import cn.thatisme.blog.context.application.UserQueryService;
import cn.thatisme.blog.context.application.dto.UserDto;
import cn.thatisme.blog.context.domain.user.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

/**
 * <p></p>
 * @author wujinhang 2023/8/17
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest()
class UserQueryServiceImplTest {

    @Mock
    private UserRepository userRepository = Mockito.spy(UserRepository.class);

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
