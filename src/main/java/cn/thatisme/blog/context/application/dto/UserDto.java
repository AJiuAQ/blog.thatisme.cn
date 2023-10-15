package cn.thatisme.blog.context.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>user dto</p>
 * @author wujinhang 2022/4/20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

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

    private LocalDate loginTime;

    private LocalDate createTime;

    private LocalDate updateTime;
}
