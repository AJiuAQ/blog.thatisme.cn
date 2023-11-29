package cn.thatisme.blog.common.graphql.pageable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * <p></p>
 * @author wujinhang me@thatisme.cn 2023/11/28
 */
@Getter
@RequiredArgsConstructor
public class PageResult<T extends SearchContent> {
    private final List<T> content;
    private final long totalElement;

}
