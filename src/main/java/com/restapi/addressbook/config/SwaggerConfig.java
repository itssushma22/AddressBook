package com.restapi.addressbook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.regex("/api/v1/.*"))
			    .build()			
				.groupName("G1").apiInfo(apiInfo());
			
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Address Book API")
				.description("Documentation Generateed Using SWAGGER2 for Adddress Book Rest API")
				.termsOfServiceUrl("http://terms-of-services.url")
				.license("License")
				.licenseUrl("http://url-to-license.com").version("1.0").build();
	}
}