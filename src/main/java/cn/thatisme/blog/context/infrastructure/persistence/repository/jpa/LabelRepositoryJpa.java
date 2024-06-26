package cn.thatisme.blog.context.infrastructure.persistence.repository.jpa;

import cn.thatisme.blog.common.domain.EntityConversion;
import cn.thatisme.blog.common.persistence.repository.BaseRepositoryJpa;
import cn.thatisme.blog.context.application.command.LabelCommand;
import cn.thatisme.blog.context.application.dto.LabelDto;
import cn.thatisme.blog.context.domain.label.Label;
import cn.thatisme.blog.context.domain.label.LabelRepository;
import cn.thatisme.blog.context.infrastructure.persistence.po.LabelPo;

/**
 * <p></p>
 * @author wujinhang 2023/8/16
 */
public interface LabelRepositoryJpa extends LabelRepository,
        BaseRepositoryJpa<LabelPo, Label> {
    @Override
    default EntityConversion entityConversion() {
        return new EntityConversion(LabelDto.class, Label.class, LabelPo.class, LabelCommand.class);
    }
}
