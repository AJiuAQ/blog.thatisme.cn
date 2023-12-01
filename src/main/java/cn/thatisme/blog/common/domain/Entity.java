package cn.thatisme.blog.common.domain;

import java.io.Serializable;

/**
 * <p>实体</p>
 * @author wujinhang 2023/4/18
 */
public interface Entity<T> extends Serializable {

    Long getId();

    /**
     * 与另一个实体是否为相同的实体
     * @param that 另一个实体
     * @return 相同 true | 不同 false
     */
    default boolean sameIdentityAs(Entity<T> that) {
        return that!= null && this.getId().equals(that.getId());
    }
}
