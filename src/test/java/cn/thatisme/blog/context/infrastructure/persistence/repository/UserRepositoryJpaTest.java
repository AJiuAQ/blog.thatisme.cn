package cn.thatisme.blog.context.infrastructure.persistence.repository;

import cn.thatisme.blog.context.domain.user.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <p></p>
 * @author wujinhang 2023/8/19
 */
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class UserRepositoryJpaTest {

    @Autowired
    private UserRepository userRepository;

    private static final String EMAIL = "me@thatisme.cn";

    static User user = User.builder()
            .account(new Account(new Username("tom"), new Email(EMAIL), new Password("1", "1"), null))
            .build();

    @Test
    void t_0_init() {
        User result = userRepository.get(new Email(EMAIL));
        if (result == null) {
            User store = userRepository.store(user);
            user.setId(store.getId());
        } else {
            user = result;
        }
    }

    @Test
    void t_1_get() {
        User result = userRepository.get(user.getId());
        assertTrue(user.sameIdentityAs(result));
    }

    @Test
    void t_2_getUserPoByEmail() {
        User result = userRepository.get(new Email(EMAIL));

        assertTrue(user.sameIdentityAs(result));
    }

    @Test
    void t_3_delete() {
        User result = userRepository.get(new Email(EMAIL));
        userRepository.remove(Collections.singletonList(result.getId()));
        User result2 = userRepository.get(new Email(EMAIL));
        assertNull(result2);
    }
}