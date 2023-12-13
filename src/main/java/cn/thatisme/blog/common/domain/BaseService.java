package cn.thatisme.blog.common.domain;

import cn.thatisme.blog.common.graphql.pageable.PageQuery;
import cn.thatisme.blog.common.graphql.pageable.SearchContent;
import cn.thatisme.blog.common.utils.ConversionServiceUtils;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * <p></p>
 * @author wujinhang me@thatisme.cn 2023/12/13
 */
@SuppressWarnings("unchecked")
public interface BaseService<E extends Entity<E>, DTO extends SearchContent> {

    BaseRepository<E> repository();
    /**
     * 获取各级 class 以供转换使用
     * BaseRepository 也会有
     * @return EntityConversion(dto, entity, po, command)
     */
    default EntityConversion entityConversion() {
        return repository().entityConversion();
    }

    default DTO get(Long id) {
        E user = repository().get(id);
        return (DTO) ConversionServiceUtils.convert(user, entityConversion().getDto());
    }

    default Page<DTO> page(PageQuery query) {
        Page<E> page = repository().page(query);
        return page.map(e -> (DTO) ConversionServiceUtils.convert(e, entityConversion().getDto()));
    }

    default DTO store(Object command) {
        E store = repository().store((E) ConversionServiceUtils.convert(command, entityConversion().getCommand()));
        return (DTO) ConversionServiceUtils.convert(store, entityConversion().getDto());
    }

    default long delete(List<Long> ids) {
        return repository().remove(ids);
    }
}
