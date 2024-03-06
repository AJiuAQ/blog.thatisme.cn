package cn.thatisme.blog.context.infrastructure.converter;

import cn.thatisme.blog.context.domain.label.Label;
import cn.thatisme.blog.context.infrastructure.persistence.po.LabelPo;
import jakarta.annotation.Nonnull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

/**
 * <p></p>
 * @author wujinhang 2023/8/18
 */
@Mapper(componentModel = "spring")
public interface LabelPoConverter extends Converter<LabelPo, Label> {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name.name")
    Label convert(@Nonnull LabelPo po);
}
