package com.fatec.stacktec.StackTec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;


@EnableElasticsearchRepositories(basePackages = "com.fatec.stacktec.repository")
@ComponentScan(basePackages = { "com.fatec.sstecktec" } )
@SpringBootApplication
public class StackTecApplication {

	public static void main(String[] args) {
		SpringApplication.run(StackTecApplication.class, args);
	}

}
