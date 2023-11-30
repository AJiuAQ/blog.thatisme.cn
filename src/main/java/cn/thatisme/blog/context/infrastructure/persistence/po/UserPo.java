package cn.thatisme.blog.context.infrastructure.persistence.po;

import cn.thatisme.blog.common.persistence.BasePo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

/**
 * <p></p>
 * @author wujinhang 2023/8/15
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "user")
@Comment("用户表")
public class UserPo extends BasePo {

    @Column(length = 32, nullable = false, unique = true)
    @Comment("用户名")
    private String username;

    @Column(length = 320, nullable = false, unique = true)
    @Comment("邮箱")
    private String email;

    @Column(nullable = false)
    @Comment("是否管理员， 0-否 | 1-是")
    private Boolean admin = false;

    @Column(nullable = false)
    @Comment("密码")
    private String password;

    @Column
    @Comment("登陆时间")
    private LocalDateTime loginTime;

    @Column
    @Comment("创建时间")
    private LocalDateTime createTime;

    @Column
    @Comment("更新时间")
    private LocalDateTime updateTime;
}
