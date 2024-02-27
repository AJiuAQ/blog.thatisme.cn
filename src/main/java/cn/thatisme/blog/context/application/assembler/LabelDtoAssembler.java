package cn.thatisme.blog.context.application.assembler;

import cn.thatisme.blog.context.application.dto.LabelDto;
import cn.thatisme.blog.context.domain.label.Label;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

/**
 * <p></p>
 * @author wujinhang 2023/8/17
 */
@Mapper(componentModel = "spring")
public interface LabelDtoAssembler extends Converter<Label, LabelDto> {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name.name")
    LabelDto convert(Label label);
}
