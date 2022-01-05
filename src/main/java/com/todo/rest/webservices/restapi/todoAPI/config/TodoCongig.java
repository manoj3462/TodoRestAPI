package com.todo.rest.webservices.restapi.todoAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;


@Configuration
public class TodoCongig {


		@Bean
		public Docket postsApi() {
			return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/api.*")).apis(RequestHandlerSelectors.basePackage("com.todo.rest.webservices.restapi")).build();
		}

		private ApiInfo apiInfo() {
			return new ApiInfoBuilder().title("TODO Service")
					.description("TODO Swagger API").version("1.0").build();
		}
	
}
