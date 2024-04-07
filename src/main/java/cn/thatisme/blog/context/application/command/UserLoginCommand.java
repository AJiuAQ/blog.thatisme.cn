package cn.thatisme.blog.context.application.command;

import lombok.Data;

/**
 * <p></p>
 * @author wujinhang me@thatisme.cn 2023/11/30
 */
@Data
public class UserLoginCommand {

    /**
     * 用户名
     */
    private String username;

    /**
     * password
     */
    private String password;
}
