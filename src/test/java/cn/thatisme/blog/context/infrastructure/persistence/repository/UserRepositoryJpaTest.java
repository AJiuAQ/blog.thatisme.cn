package cn.thatisme.blog.context.infrastructure.persistence.repository;

import cn.thatisme.blog.common.domain.ID;
import cn.thatisme.blog.context.domain.user.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <p></p>
 * @author wujinhang 2023/8/19
 */
@SpringBootTest
class UserRepositoryJpaTest {

    @Autowired
    private UserRepository userRepository;

    User user = User.builder()
            .id(new ID(1L))
            .username(new Username("tom"))
            .password(new Password("1", "1"))
            .email(new Email("me@thatisme.cn")).build();
    @BeforeEach
    void setUp() {
        User result = userRepository.get(user.getId());
        if (result == null) {
            userRepository.store(user);
        }
    }

    @Test
    void get() {
        User result = userRepository.get(user.getId());
        assertTrue(user.sameIdentityAs(result));
    }

    @Test
    void getUserPoByEmail() {
    }
}