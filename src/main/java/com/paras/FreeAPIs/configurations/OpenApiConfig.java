package com.paras.FreeAPIs.configurations;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Paras",
                        email = "parasgupta8sep@gmail.com",
                        url = "https://www.linkedin.com/in/gupta-paras/"
                ),
                title = "FreeAPIs",
                version = "1.0",
                description = "FreeAPIs - Your Free APIs hub for development"
        ),
        servers = {
                @Server(
                        description = "Local Server",
                        url = "http://localhost:8081/api/v1"
                )
        }
//        security = {
//                @SecurityRequirement(
//                        name = "bearerAuth"
//                )
//        }
)
//@SecurityScheme(
//        name = "bearerAuth",
//        type = SecuritySchemeType.HTTP,
//        scheme = "bearer",
//        description = "JWT Token",
//        bearerFormat = "JWT",
//        in = SecuritySchemeIn.HEADER
//)
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi publicApi () {
        return GroupedOpenApi.builder()
                             .group("public-api")
                             .pathsToMatch("/public/**")
                             .build();
    }

    @Bean
    public GroupedOpenApi kitchenApi () {
        return GroupedOpenApi.builder()
                             .group("kitchen-api")
                             .pathsToMatch("/kitchen/**")
                             .build();
    }
}
