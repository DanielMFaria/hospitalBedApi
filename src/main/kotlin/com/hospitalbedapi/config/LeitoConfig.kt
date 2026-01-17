package com.hospitalbedapi.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                .title("API Gestão Hospitalar")
                .version("1.0")
                .description("API desenvolvida para conceito de projeto")
            )
    }
}