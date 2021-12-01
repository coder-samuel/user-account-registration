package org.keeggo.api.brasilprev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("org.keeggo.api.brasilprev.controller"))
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Keeggo | BrasilPrev").description("Application developed with the functionalities of a custumer registratio system, for the possition of junior Java back-end developer at Keeggo | BrasilPrev")
				.version("1.1")
				.contact(contact()).build();
	}
	
	private Contact contact() {
		return new Contact("Samuel de Brito Santos", "https://github.com/coder-samuel/user-account-register", "Junior Java Developer");
	}
}
