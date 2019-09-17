package com.projetoSpringBoot.swagger;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.projetoSpringBoot"))
				.paths(regex("/cursos.*"))
				.build()
				.apiInfo(metaInfo());
	}

	
	private ApiInfo metaInfo() {

		ApiInfo apiInfo = new ApiInfo("Testes API REST", "API REST", "1.0",
				"Termos de Serviços",
				new Contact("Fabrício Machado", "xxx", "xxx"),
				"xxx", "xxx", new ArrayList<VendorExtension>());

		return apiInfo;
	}
	

}