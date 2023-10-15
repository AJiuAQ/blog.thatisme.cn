package cn.thatisme.blog.common.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <p></p>
 * @author wujinhang 2023/10/7
 */
class SnowflakeUtilsTest {
    @Test
    void createId() {
        System.out.println(SnowflakeUtils.snowflake().nextId());
    }
}