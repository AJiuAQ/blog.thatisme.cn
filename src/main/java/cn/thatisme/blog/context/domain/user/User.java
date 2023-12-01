package cn.thatisme.blog.context.domain.user;

import cn.thatisme.blog.common.domain.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * <p></p>
 * @author wujinhang 2023/4/15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Entity<User> {

    private Long id;

    Account account;

    @Builder.Default
    private Boolean admin = false;

    private LocalDateTime loginTime;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public User(Long id, Username username, Email email) {
        this.id = id;
        this.account = new Account(username, email);
    }

}
