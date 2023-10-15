package cn.thatisme.blog.context.domain.user;

import cn.thatisme.blog.common.domain.Entity;
import cn.thatisme.blog.common.domain.ID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * <p></p>
 * @author wujinhang 2023/4/15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Entity<User> {

    private ID id;

    Account account;

    @Builder.Default
    private Boolean admin = false;

    private LocalDate loginTime;

    private LocalDate createTime;

    private LocalDate updateTime;

    public User(ID id, Username username, Email email) {
        this.id = id;
        this.account = new Account(username, email);
    }

}
