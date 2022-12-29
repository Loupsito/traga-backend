package com.loupsito.traga.config;

import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

import static com.cl.sit.commons.jwt.JWTConstants.JWT_HEADER_NAME;
import static io.swagger.v3.oas.annotations.enums.ParameterIn.HEADER;

@Component
public class TokenHeaderConfiguration implements OperationCustomizer {

    @Override
    public Operation customize(Operation operation, HandlerMethod handlerMethod) {

        Parameter customHeaderVersion = new Parameter()
                .in(HEADER.toString())
                .name(JWT_HEADER_NAME)
                .description("A token that allow you authenticate and access protected resources")
                .schema(new StringSchema())
                .required(true);

        operation.addParametersItem(customHeaderVersion);

        return operation;
    }
}
