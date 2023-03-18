package com.fatec.stacktec.StackTec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import com.fatec.stacktec.StackTec.configuration.StackTecLibsProperty;


@EnableElasticsearchRepositories(basePackages = "com.fatec.stacktec.repository")
@ComponentScan(basePackages = { "com.fatec.stacktec" } )
@EnableConfigurationProperties(StackTecLibsProperty.class)
@SpringBootApplication
public class StackTecApplication {

	public static void main(String[] args) {
		SpringApplication.run(StackTecApplication.class, args);
	}

}
