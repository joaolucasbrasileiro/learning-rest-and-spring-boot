package com.lucasbrasileiro.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("CRUD Spring Test with Security")
                        .version("1.0")
                        .description("CRUD Spring Test with Security")
                        .termsOfService("Termos de Serviço")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("Url da licença"))
                );
    }
}
