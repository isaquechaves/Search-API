package com.fatec.stacktec.searchapi.configuration;


import javax.annotation.PostConstruct;

import org.apache.http.HttpHost;

import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.util.AnnotatedTypeScanner;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

@Log
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "stacktec")
public class ElasticsearchConfig {
	
	private String elasticSearchUrl;
	
	private boolean loadSearchData;
	
	private boolean loadSearchDataOnInit;
	
	@Bean
	public RestHighLevelClient client() {		
		if(elasticSearchUrl == null || elasticSearchUrl.isEmpty())
			elasticSearchUrl = "localhost";
		
		RestClientBuilder builder = RestClient
				.builder(new HttpHost(elasticSearchUrl, 9200))
				.setHttpClientConfigCallback(httpClientBuilder -> 
						httpClientBuilder
							.setDefaultIOReactorConfig(IOReactorConfig.custom().setIoThreadCount(5).build())	
		);
		
		builder.setRequestConfigCallback(requestConfigBuilder ->
				requestConfigBuilder
					.setConnectTimeout(10000)
					.setSocketTimeout(60000)
					.setConnectionRequestTimeout(0)
		);
		return new RestHighLevelClient(builder);		
	}
	
	
	@Bean
	public ElasticsearchOperations elasticsearchTemplate() {
		return new ElasticsearchRestTemplate(client());
	}
	
	
	@PostConstruct
	public void init() {	
		AnnotatedTypeScanner scanner = new AnnotatedTypeScanner(false, Document.class);
		
		for(Class clazz : scanner.findTypes("com.fatec.stacktec.searchapi.holder" )) {
			Document doc = AnnotationUtils.findAnnotation(clazz, Document.class);
			assert doc != null;
			
			if(!elasticsearchTemplate().indexExists(doc.indexName())) {
				//log.info("Index - {} does not exists. Creating index now!! " + doc.indexName());
				elasticsearchTemplate().createIndex(clazz);
			}
			elasticsearchTemplate().refresh(doc.indexName());
			elasticsearchTemplate().putMapping(clazz);		
		}
	}

}
