package cn.thatisme.blog.context.domain.user;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import cn.thatisme.blog.common.domain.ValueObject;

/**
 * <p></p>
 * @author wujinhang 2023/4/18
 */
public record Password(String password, String salt) implements ValueObject<Password> {

    public Password {
        //Assert.notBlank(password, "密码不能为空");
    }

    public static Password create(String passwordStr) {
        String salt = RandomUtil.randomString(20);
        String password = SecureUtil.sha256().setSalt(salt.getBytes()).digestHex(passwordStr);
        return new Password(password, salt);
    }

    public static Password create(String passwordStr, String salt) {
        if(passwordStr.length() < 8) {
            throw new IllegalArgumentException("密码长度不能小于8");
        }
        String password = SecureUtil.sha256().setSalt(salt.getBytes()).digestHex(passwordStr);
        return new Password(password, salt);
    }

    @Override
    public boolean sameValueAs(Password that) {
        return that != null && this.password.equals(that.password);
    }
}
