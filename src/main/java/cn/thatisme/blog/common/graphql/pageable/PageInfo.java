package cn.thatisme.blog.common.graphql.pageable;

import cn.hutool.core.collection.CollectionUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p></p>
 * @author wujinhang me@thatisme.cn 2023/11/28
 */
@Data
@AllArgsConstructor
public class PageInfo implements Pageable {

    private static final int FIRST = 1;
    private static final int SIZE = 10;

    private int page;

    private int size;

    private List<String> sort;

    public static PageInfo of(int page, int size) {
        return new PageInfo(page, size, null);
    }

    @Override
    public int getPageNumber() {
        return page;
    }

    @Override
    public int getPageSize() {
        return size;
    }

    @Override
    public long getOffset() {
        return (long) (page - FIRST) * size;
    }

    @Override
    public @NotNull Sort getSort() {
        if (CollectionUtil.isEmpty(sort)) {
            return Sort.unsorted();
        }
        return Sort.by(sort.stream().map(e -> {
            String[] split = e.split(",");
            if (split.length == 2) {
                return new Sort.Order(Sort.Direction.valueOf(split[1]), split[0]);
            }
            return Sort.Order.asc(split[0]);
        }).collect(Collectors.toList()));
    }

    @Override
    public @NotNull Pageable next() {
        return PageInfo.of(page + 1, size);
    }

    @Override
    public @NotNull Pageable previousOrFirst() {
        return PageInfo.of(page > 1 ? page - 1 : FIRST, size);
    }

    @Override
    public @NotNull Pageable first() {
        return PageInfo.of(FIRST, size);
    }

    @Override
    public @NotNull Pageable withPage(int pageNumber) {
        return PageInfo.of(pageNumber, size);
    }

    @Override
    public boolean hasPrevious() {
        return page != FIRST;
    }
}
