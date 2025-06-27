package cn.thatisme.blog.common.utils;

import cn.thatisme.blog.common.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.Serializable;

@SpringBootTest
public class RedisTest {

    @Test
    void testOperations() {
        // 字符串操作
        RedisUtils.set("testKey", "hello world", 60);
        String value = RedisUtils.get("testKey");
        System.out.println(value); // 输出: hello world

        // 设置过期时间
        RedisUtils.expire("testKey", 60);

        // 删除键
//        RedisUtils.delete("testKey");
    }
}