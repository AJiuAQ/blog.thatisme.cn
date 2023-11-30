package cn.thatisme.blog.context.application.dto;

import cn.thatisme.blog.common.graphql.pageable.SearchContent;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>user dto</p>
 * @author wujinhang 2022/4/20
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserDto extends SearchContent implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * email
     */
    private String email;

    private Boolean admin;

    private LocalDateTime loginTime;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
