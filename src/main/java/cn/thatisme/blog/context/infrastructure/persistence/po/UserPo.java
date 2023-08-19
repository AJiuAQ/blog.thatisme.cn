package cn.thatisme.blog.context.infrastructure.persistence.po;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * <p></p>
 * @author wujinhang 2023/8/15
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "user")
public class UserPo {

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private Date loginTime;

    @Id
    private Long id;

    /**
     * 创建人
     */
    @Column
    private String createdBy;

    /**
     * 创建时间
     */
    @Column
    private Date createdTime;

    /**
     * 更新人
     */
    @Column
    private String updatedBy;

    /**
     * 更新时间
     */
    @Column
    private Date updatedTime;
}
