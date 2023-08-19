package cn.thatisme.blog.context.domain.user;

import cn.thatisme.blog.common.domain.ValueObject;

/**
 * <p>user id</p>
 * @author wujinhang 2022/4/13
 */
public record Account(Username username, Email email, Password password, Token token) implements ValueObject<Account> {

    public boolean checkPassword(String passwordStr) {
        return this.password.sameValueAs(Password.create(passwordStr, password.salt()));
    }

    public Account changePassword(String oldPasswordStr, String newPasswordStr) {
        if (!checkPassword(oldPasswordStr)) {
            throw new RuntimeException("原密码不正确");
        }
        return new Account(username, email, Password.create(newPasswordStr, password.salt()), token);
    }

    public boolean valid() {
        return this.token != null && this.token.expireTime()!= null &&
                this.token.expireTime().getTime() >= System.currentTimeMillis();
    }

    public Account updateToken(String tokenStr) {
        return new Account(username, email, password, Token.create(tokenStr));
    }
}