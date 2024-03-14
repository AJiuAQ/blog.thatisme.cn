package cn.thatisme.blog.context.infrastructure.converter;

import cn.thatisme.blog.common.mapstruct.ValueObjectStrategy;
import cn.thatisme.blog.context.domain.label.Label;
import cn.thatisme.blog.context.infrastructure.persistence.po.LabelPo;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring", uses = ValueObjectStrategy.class)
public interface LabelConverter extends Converter<Label, LabelPo> {

    LabelPo convert(Label label);
}