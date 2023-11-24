package cn.thatisme.blog.config.graphql;

import graphql.schema.DataFetchingEnvironment;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Sort;
import org.springframework.graphql.data.query.AbstractSortStrategy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p></p>
 * @author wujinhang me@thatisme.cn 2023/11/24
 */
@Component
public class SortStrategy extends AbstractSortStrategy {
    @Override
    public Sort extract(@NotNull DataFetchingEnvironment environment) {
        var sort = environment.getArgument("sort");
        if (sort == null) {
            return Sort.unsorted();
        }
        List<Sort.Order> orders = new ArrayList<>();
        if (sort instanceof Map) {
            Object ordersList = ((Map<?, ?>) sort).get("orders");
            if (ordersList instanceof List) {
                ((List<?>) ordersList).forEach(e -> {
                    Map<?, ?> e1 = (Map<?, ?>) e;
                    orders.add(new Sort.Order(Sort.Direction.valueOf((String) e1.get("direction")), (String) e1.get("property")));
                });
            }
        }
        return Sort.by(orders);
    }

    @Override
    protected List<String> getProperties(DataFetchingEnvironment environment) {
        return null;
    }

    @Override
    protected Sort.Direction getDirection(DataFetchingEnvironment environment) {
        return null;
    }
}
