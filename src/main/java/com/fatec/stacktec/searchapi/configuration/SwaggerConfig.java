package com.fatec.stacktec.searchapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api10() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("stacktec-searchapi-1.0")
				.select()
					.apis(RequestHandlerSelectors.basePackage("com.fatec.stacktec.searchapi.controller"))
					.paths(PathSelectors.any())
				.build()
				.apiInfo(new ApiInfoBuilder().version("1.0").title("StackTec Search API").description("Documentation API v1.0").build());
				
	}
}
