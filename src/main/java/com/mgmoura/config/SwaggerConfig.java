package com.mgmoura.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI customOpenApi() {
		
	return new OpenAPI().components(new Components())
	.info(new Info()
	.title("ContatosAPI - API REST para	gerenciamento de contatos")
	.description("Projeto Spring Boot para API de contatos")
	.version("v1.0"));
	}

}
