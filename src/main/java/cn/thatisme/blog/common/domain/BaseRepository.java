package cn.thatisme.blog.common.domain;

import cn.thatisme.blog.common.graphql.pageable.PageQuery;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * <p>仓储基础服务</p>
 * @author wujinhang 2023/8/16
 */
public interface BaseRepository<E extends Entity<E>> {

    /**
     * 获取各级 class 以供转换使用
     * @return EntityConversion(dto, entity, po, command)
     */
    default EntityConversion entityConversion() {
        return null;
    }

    E get(Long id);

    Page<E> page(PageQuery pageQuery);

    E store(E entity);

    List<E> storeBatch(List<E> entity);

    long remove(List<Long> ids);
}
