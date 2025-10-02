package com.example.productsbackend.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAPI configuration for the Products API.
 */
@Configuration
public class OpenApiConfig {

    // PUBLIC_INTERFACE
    /**
     * Configures OpenAPI metadata for the application.
     * @return OpenAPI instance with info and external docs.
     */
    @Bean
    public OpenAPI productsOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Products API")
                        .description("Modern REST API for managing products. Theme: Ocean Professional (primary #2563EB, accent #F59E0B)")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Products API Team")
                                .email("support@example.com")
                        )
                        .license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("Swagger UI")
                        .url("/swagger-ui.html"));
    }
}
