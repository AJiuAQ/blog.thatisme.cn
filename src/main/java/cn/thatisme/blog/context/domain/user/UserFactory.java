package cn.thatisme.blog.context.domain.user;

import cn.thatisme.blog.common.utils.ConversionServiceUtils;
import cn.thatisme.blog.context.infrastructure.persistence.po.UserPo;

/**
 * <p></p>
 * @author wujinhang 2023/10/7
 */
public class UserFactory {

    public static User createUser() {
        return new User();
    }

}
