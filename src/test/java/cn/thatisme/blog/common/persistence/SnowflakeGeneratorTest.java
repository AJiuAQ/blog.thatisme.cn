package cn.thatisme.blog.common.persistence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <p></p>
 * @author wujinhang 2023/10/7
 */
class SnowflakeGeneratorTest {

    @Test
    void name() {
        assertEquals("SnowflakeGenerator", SnowflakeGenerator.NAME);
    }

    // TODO 带 id 插入
    // TODO 不带 id 插入
}