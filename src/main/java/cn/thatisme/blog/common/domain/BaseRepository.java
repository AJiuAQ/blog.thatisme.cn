package cn.thatisme.blog.common.domain;

import java.util.List;

/**
 * <p></p>
 * @author wujinhang 2023/8/16
 */
public interface BaseRepository<PO, E extends Entity<E>> {

    /**
     * 上游数据类型，持久化数据--实体模型--dto 转换数据
     * @return class
     */
    Class<PO> upstreamType();

    /**
     * 下游数据类型，持久化数据--实体模型--dto 转换数据
     * @return class
     */
    Class<E> downstreamType();

    E get(ID id);

    E store(E entity);

    void remove(List<ID> ids);
}
