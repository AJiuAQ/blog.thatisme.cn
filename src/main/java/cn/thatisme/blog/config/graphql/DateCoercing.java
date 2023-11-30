package cn.thatisme.blog.config.graphql;

import graphql.GraphQLContext;
import graphql.execution.CoercedVariables;
import graphql.language.StringValue;
import graphql.language.Value;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static java.lang.String.format;

/**
 * <p></p>
 * @author wujinhang 2023/10/13
 */

public class DateCoercing implements Coercing<LocalDate, String> {

    private static DateTimeFormatter createIsoDateFormat() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }

    @Override
    public String serialize(Object dataFetcherResult, GraphQLContext graphQLContext, Locale locale) throws CoercingSerializeException {
        if (dataFetcherResult instanceof LocalDate) {
            return createIsoDateFormat().format((LocalDate) dataFetcherResult);
        }
        return null;
    }

    @Override
    public LocalDate parseValue(Object input, GraphQLContext graphQLContext, Locale locale) throws CoercingParseValueException {
        if (input instanceof LocalDate) {
            return (LocalDate) input;
        } else if (input instanceof String) {
            return fromString((String) input);
        }
        return null;
    }

    @Override
    public LocalDate parseLiteral(Value<?> input, CoercedVariables variables, GraphQLContext graphQLContext, Locale locale) throws CoercingParseLiteralException {
        if (input instanceof StringValue) {
            String value = ((StringValue) input).getValue();
            return fromString(value);
        }
        throw new UnsupportedOperationException("Unsupported input in DateScalarType: " + input);
    }

    @Override
    public Value<?> valueToLiteral(Object input, GraphQLContext graphQLContext, Locale locale) {
        LocalDate localDate = parseValue(input, graphQLContext, locale);
        if (localDate == null) {
            return StringValue.of(null);
        }
        return StringValue.of(createIsoDateFormat().format(localDate));
    }

    private static LocalDate fromString(String input) {
        try {
            return LocalDate.parse(input, createIsoDateFormat());
        } catch (Exception e) {
            throw new IllegalArgumentException(format("Could not parse date from String '%s': %s", input, e.getLocalizedMessage()), e);
        }
    }
}
