package cn.thatisme.blog.common.graphql.pageable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

/**
 * <p></p>
 * @author wujinhang me@thatisme.cn 2023/11/28
 */
@Getter
@RequiredArgsConstructor
public class DeleteResult implements Serializable {
    private final long totalElement;

}
