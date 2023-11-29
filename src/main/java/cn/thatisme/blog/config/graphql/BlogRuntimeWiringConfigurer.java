package cn.thatisme.blog.config.graphql;

import cn.thatisme.blog.context.application.dto.UserDto;
import graphql.schema.GraphQLScalarType;
import graphql.schema.idl.RuntimeWiring;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

/**
 * <p></p>
 * @author wujinhang 2023/10/13
 */
@Configuration
public class BlogRuntimeWiringConfigurer {

    @Bean
    RuntimeWiringConfigurer blogWiringConfigurer() {
        return builder -> {
            addPersonTypeResolver(builder);
            addDateCoercing(builder);
        };
    }

    private void addPersonTypeResolver(RuntimeWiring.Builder builder) {
        builder.type("SearchContent", typeBuilder -> typeBuilder.typeResolver(env -> {
            Object javaObject = env.getObject();
            if (javaObject instanceof UserDto) {
                return env.getSchema().getObjectType("User");
            }
            return env.getSchema().getObjectType("0");
        }));
    }

    private void addDateCoercing(RuntimeWiring.Builder builder) {
        builder.scalar(GraphQLScalarType.newScalar()
                .name("Date")
                .description("A Type representing a date (without time, only a day)")
                .coercing(new DateCoercing())
                .build());
    }
}
