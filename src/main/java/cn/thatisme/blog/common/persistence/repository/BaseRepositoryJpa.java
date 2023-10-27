package cn.thatisme.blog.common.persistence.repository;

import cn.thatisme.blog.common.domain.BaseRepository;
import cn.thatisme.blog.common.domain.Entity;
import cn.thatisme.blog.common.domain.ID;
import cn.thatisme.blog.common.utils.ConversionServiceUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p></p>
 * @author wujinhang 2023/8/18
 */
@NoRepositoryBean
public interface BaseRepositoryJpa<P, E extends Entity<E>> extends BaseRepository<E>, JpaRepository<P, Long> {

    /**
     * 上游数据类型，持久化数据--实体模型--dto 转换数据
     * @return class
     */
    Class<P> upstreamType();

    /**
     * 下游数据类型，持久化数据--实体模型--dto 转换数据
     * @return class
     */
    Class<E> downstreamType();

    @Override
    default E get(ID id) {
        assert downstreamType() != null;
        P referenceById = findById(id.id()).orElse(null);
        return ConversionServiceUtils.convert(referenceById, downstreamType());
    }

    @Override
    default Page<E> page(Pageable page) {
        Page<P> result = findAll(page);
        return result.map(e -> ConversionServiceUtils.convert(e, downstreamType()));
    }

    @Override
    default E store(E entity) {
        assert upstreamType() != null;
        assert downstreamType() != null;
        P convert = ConversionServiceUtils.convert(entity, upstreamType());
        P saved = saveAndFlush(convert);
        return ConversionServiceUtils.convert(saved, downstreamType());
    }

    @Override
    default List<E> storeBatch(List<E> entity) {
        assert upstreamType() != null;
        assert downstreamType() != null;
        List<P> convert = ConversionServiceUtils.convertBatch(entity.spliterator(), upstreamType());
        List<P> saved = saveAllAndFlush(convert);
        return ConversionServiceUtils.convertBatch(saved.spliterator(), downstreamType());
    }

    @Override
    default void remove(List<ID> ids) {
        deleteAllById(ids.stream().map(ID::id).collect(Collectors.toList()));
    }
}
