package cn.thatisme.blog.context.domain.user;

import cn.thatisme.blog.common.domain.Entity;
import cn.thatisme.blog.common.domain.ID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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

    private Username username;

    private Email email;

    private Password password;

    private Date loginTime;

    private Date createTime;

    private Date updateTime;

    public User(ID id, Username username, Email email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
}
