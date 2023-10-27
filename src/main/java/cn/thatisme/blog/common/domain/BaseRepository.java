package cn.thatisme.blog.common.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * <p>仓储基础服务</p>
 * @author wujinhang 2023/8/16
 */
public interface BaseRepository<E extends Entity<E>> {

    /**
     * 上游数据类型，持久化数据--实体模型--dto 转换数据
     * @return class
     */
    Class<?> upstreamType();

    /**
     * 下游数据类型，持久化数据--实体模型--dto 转换数据
     * @return class
     */
    Class<E> downstreamType();

    E get(ID id);

    Page<E> page(Pageable page);

    E store(E entity);

    List<E> storeBatch(List<E> entity);

    void remove(List<ID> ids);
}
