package cn.thatisme.blog.common.domain;

import cn.thatisme.blog.context.domain.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <p>Entity 接口测试</p>
 * @author wujinhang 2023/5/12
 */
class EntityTest {

    @Test
    void getId() {
        User user1 = new User();
        user1.setId(1L);
        System.out.println(user1.getId());
    }

    @Test
    void sameIdentityAs() {
        User user1 = new User();
        user1.setId(1L);
        User user2 = new User();
        user2.setId(1L);
        assertTrue(user1.sameIdentityAs(user2));
        assertFalse(user1.sameIdentityAs(null));
        System.out.println(user1);
        assertNotEquals(user1, user2);
    }
}