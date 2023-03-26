package com.fatec.stacktec.searchapi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import com.fatec.stacktec.searchapi.configuration.StackTecLibsProperty;

@EnableElasticsearchRepositories(basePackages = "com.fatec.stacktec.searchapi.repository")
@ComponentScan(basePackages = { "com.fatec.stacktec.searchapi" } )
@EnableConfigurationProperties(StackTecLibsProperty.class)
@SpringBootApplication
public class StackTecApplication {

	public static void main(String[] args) {
		SpringApplication.run(StackTecApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}
}
