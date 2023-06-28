package com.task.management.api.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class OpenApiConfig {
//
//    @Bean
//    public UiConfiguration uiConfig() {
//        return UiConfigurationBuilder.builder()
//                .docExpansion(DocExpansion.NONE)
//                .build();
//    }

}
