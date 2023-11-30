package cn.thatisme.blog.common.domain;

/**
 * <p>ID</p>
 * @author wujinhang 2023/4/17
 */
public record ID(Long id) implements ValueObject<ID> {

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
