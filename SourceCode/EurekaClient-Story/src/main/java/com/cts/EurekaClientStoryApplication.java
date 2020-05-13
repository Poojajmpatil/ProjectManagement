package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@SpringBootApplication
@EnableSwagger2

@EnableFeignClients 
public class EurekaClientStoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientStoryApplication.class, args);
	}
	
/* @Bean
public Docket swaggerConfiguration() {
	return new Docket(DocumentationType.SWAGGER_2) .select()
			.paths(PathSelectors.ant("access"))
			.apis(RequestHandlerSelectors.basePackage("com.cts")).build();
}
	*/
	
}
