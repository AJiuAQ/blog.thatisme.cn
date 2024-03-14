package cn.thatisme.blog.common.persistence.repository;

import cn.thatisme.blog.common.domain.BaseRepository;
import cn.thatisme.blog.common.domain.Entity;
import cn.thatisme.blog.common.graphql.pageable.DeleteResult;
import cn.thatisme.blog.common.graphql.pageable.PageQuery;
import cn.thatisme.blog.common.utils.ConversionServiceUtils;
import cn.thatisme.blog.common.utils.QueryHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p></p>
 * @author wujinhang 2023/8/18
 */
@NoRepositoryBean
@Transactional(readOnly = false)
@SuppressWarnings("unchecked")
public interface BaseRepositoryJpa<P, E extends Entity<E>> extends BaseRepository<E>, JpaRepository<P, Long>, JpaSpecificationExecutor<P> {

    default String getIdAttributeName() {
        return "id";
    }

    @Override
    default E get(Long id) {
        P referenceById = findById(id).orElse(null);
        return (E) ConversionServiceUtils.convert(referenceById, entityConversion().getEntity());
    }

    @Override
    default Page<E> page(PageQuery pageQuery) {
        Page<P> result = findAll((root, query, criteriaBuilder) -> QueryHelper.getPredicate(root, pageQuery, criteriaBuilder), pageQuery.getPageInfo());
        return result.map(e -> (E) ConversionServiceUtils.convert(e, entityConversion().getEntity()));
    }

    @Override
    default E store(E entity) {
        P convert = (P) ConversionServiceUtils.convert(entity, entityConversion().getPo());
        P saved = saveAndFlush(convert);
        return (E) ConversionServiceUtils.convert(saved, entityConversion().getEntity());
    }

    @Override
    default List<E> storeBatch(List<E> entity) {
        List<P> convert = (List<P>) ConversionServiceUtils.convertBatch(entity.spliterator(), entityConversion().getPo());
        List<P> saved = saveAllAndFlush(convert);
        return (List<E>) ConversionServiceUtils.convertBatch(saved.spliterator(), entityConversion().getEntity());
    }

    @Override
    default DeleteResult remove(List<Long> ids) {
        return new DeleteResult(delete((root, query, criteriaBuilder) -> criteriaBuilder.and(
                root.get(getIdAttributeName())
                        .in(ids))
        ));
    }
}
