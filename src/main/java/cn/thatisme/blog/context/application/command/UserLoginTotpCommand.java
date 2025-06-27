package cn.thatisme.blog.context.application.command;

import lombok.Data;

/**
 * <p>登录命令</p>
 * @author wujinhang me@thatisme.cn 2023/11/30
 */
@Data
public class UserLoginTotpCommand {

    /**
     * 用户名
     */
    private Integer code;
}
