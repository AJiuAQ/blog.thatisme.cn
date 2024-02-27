package cn.thatisme.blog.context.application.impl;

import cn.thatisme.blog.common.domain.BaseRepository;
import cn.thatisme.blog.context.application.LabelService;
import cn.thatisme.blog.context.domain.label.Label;
import cn.thatisme.blog.context.domain.label.LabelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p></p>
 * @author wujinhang me@thatisme.cn 2023/12/13
 */
@Service
@RequiredArgsConstructor
public class LabelServiceImpl implements LabelService {

    private final LabelRepository labelRepository;

    @Override
    public BaseRepository<Label> repository() {
        return labelRepository;
    }
}
