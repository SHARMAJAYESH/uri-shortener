package com.jayesh.code.uri_shortener.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("OpenAPI Documentation")
                        .version("1.0.0").description("This is the OpenAPI documentation for the URI Shortener application." +
                                " It provides endpoints to shorten URLs and retrieve original URLs." +
                                " The application uses Spring Boot and Swagger for API documentation.")
                );
    }
}
