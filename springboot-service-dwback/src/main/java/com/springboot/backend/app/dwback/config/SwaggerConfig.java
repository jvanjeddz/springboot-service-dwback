package com.springboot.backend.app.dwback.config;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;

import springfox.documentation.service.ApiInfo;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;

import springfox.documentation.spi.DocumentationType;

import springfox.documentation.spring.web.plugins.Docket;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import springfox.documentation.service.Contact;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket apiDocket()	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.springboot.backend.app.dwback.controllers"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo())
				;
	}

	private ApiInfo getApiInfo() {

		return new ApiInfo(
				"Tienda de Dinero",
				"Servicio para la venta de dinero",
				"3.0.2",
		 		"https://google.com",
				new Contact("John", "https://duckduckgo.com", "john@gmail.com"),
				"Licenciado bajo la GNU GPL v3",
				"https://www.gnu.org/licenses/gpl-3.0.en.html",
				Collections.emptyList()
				); 
	}
}