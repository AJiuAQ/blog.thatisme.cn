package cn.thatisme.blog.common.persistence;

import cn.thatisme.blog.common.utils.SnowflakeUtils;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;

/**
 * jpa 雪花算法 id 支持
 */
public class SnowflakeGenerator implements IdentifierGenerator, Configurable {

    public static final String NAME = SnowflakeGenerator.class.getSimpleName();

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        if (object instanceof BasePo && ((BasePo) object).getId() != null) {
            return ((BasePo) object).getId();
        }
        return SnowflakeUtils.snowflake().nextId();
    }
}
