package cn.thatisme.blog.common.persistence.repository;

import cn.thatisme.blog.common.domain.BaseRepository;
import cn.thatisme.blog.common.domain.Entity;
import cn.thatisme.blog.common.domain.ID;
import cn.thatisme.blog.common.utils.ConversionServiceUtils;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p></p>
 * @author wujinhang 2023/8/18
 */
@NoRepositoryBean
public interface BaseRepositoryJpa<PO, E extends Entity<E>> extends BaseRepository<PO, E>, CrudRepository<PO, Long> {

    @Override
    default E get(ID id) {
        assert downstreamType() != null;
        PO referenceById = findById(id.id()).orElse(null);
        E converted = ConversionServiceUtils.convert(referenceById, downstreamType());
        return converted;
    }

    @Override
    default E store(E entity) {
        assert upstreamType() != null;
        assert downstreamType() != null;
        PO convert = ConversionServiceUtils.convert(entity, upstreamType());
        PO saved = save(convert);
        E converted = ConversionServiceUtils.convert(saved, downstreamType());
        return converted;
    }

    @Override
    default void remove(List<ID> ids) {
        deleteAllById(ids.stream().map(ID::id).collect(Collectors.toList()));
    }
}
