package cn.thatisme.blog.context.application.assembler;

import cn.thatisme.blog.common.domain.ID;
import cn.thatisme.blog.context.application.dto.UserDto;
import cn.thatisme.blog.context.domain.user.Email;
import cn.thatisme.blog.context.domain.user.User;
import cn.thatisme.blog.context.domain.user.Username;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * <p></p>
 * @author wujinhang 2023/8/18
 */
@SpringBootTest()
class UserDtoAssemblerTest {

    @MockBean
    private UserDtoAssembler userDtoAssembler;

    @Test
    void convert() {
        User mockUser = new User(new ID(1L), new Username("zhangsan"), new Email("a@a.cn"));
        UserDto dto = userDtoAssembler.convert(mockUser);
        Assertions.assertNotNull(dto);
        Assertions.assertTrue(dto.getId().equals(mockUser.getId().id())
                && dto.getUsername().equals(mockUser.getUsername().username())
                && dto.getEmail().equals(mockUser.getEmail().email())
        );
    }
}