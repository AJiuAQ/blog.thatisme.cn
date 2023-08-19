package cn.thatisme.blog.common.domain;

import java.io.Serializable;

/**
 * <p>值对象</p>
 * @author wujinhang 2023/4/17
 */
public interface ValueObject<T> extends Serializable {

    /**
     * 与另一个值对象是否为相同的值对象
     * @param that 另一个
     * @return 相同 true | 不同 false
     */
    default boolean sameValueAs(T that) {
        return this.toString().equals(that.toString());
    }
}
