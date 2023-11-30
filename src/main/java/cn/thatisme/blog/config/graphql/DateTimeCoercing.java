package cn.thatisme.blog.config.graphql;

import graphql.GraphQLContext;
import graphql.execution.CoercedVariables;
import graphql.language.StringValue;
import graphql.language.Value;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static java.lang.String.format;

/**
 * <p></p>
 * @author wujinhang 2023/10/13
 */
public class DateTimeCoercing implements Coercing<LocalDateTime, String> {

    private static DateTimeFormatter createIsoDateFormat() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    @Override
    public String serialize(@NotNull Object dataFetcherResult, @NotNull GraphQLContext graphQLContext, @NotNull Locale locale) throws CoercingSerializeException {
        if (dataFetcherResult instanceof LocalDateTime) {
            return createIsoDateFormat().format((LocalDateTime) dataFetcherResult);
        }
        return null;
    }

    @Override
    public LocalDateTime parseValue(@NotNull Object input, @NotNull GraphQLContext graphQLContext, @NotNull Locale locale) throws CoercingParseValueException {
        if (input instanceof LocalDateTime) {
            return (LocalDateTime) input;
        } else if (input instanceof String) {
            return fromString((String) input);
        }
        return null;
    }

    @Override
    public LocalDateTime parseLiteral(@NotNull Value<?> input, @NotNull CoercedVariables variables, @NotNull GraphQLContext graphQLContext, @NotNull Locale locale) throws CoercingParseLiteralException {
        if (input instanceof StringValue) {
            String value = ((StringValue) input).getValue();
            return fromString(value);
        }
        throw new UnsupportedOperationException("Unsupported input in DateTimeScalarType: " + input);
    }

    @Override
    public @NotNull Value<?> valueToLiteral(@NotNull Object input, @NotNull GraphQLContext graphQLContext, @NotNull Locale locale) {
        LocalDateTime localDate = parseValue(input, graphQLContext, locale);
        if (localDate == null) {
            return StringValue.of(null);
        }
        return StringValue.of(createIsoDateFormat().format(localDate));
    }

    private static LocalDateTime fromString(String input) {
        try {
            return LocalDateTime.parse(input, createIsoDateFormat());
        } catch (Exception e) {
            throw new IllegalArgumentException(format("Could not parse dateTime from String '%s': %s", input, e.getLocalizedMessage()), e);
        }
    }
}
