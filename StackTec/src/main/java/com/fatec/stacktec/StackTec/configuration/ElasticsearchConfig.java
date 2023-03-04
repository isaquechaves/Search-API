package com.fatec.stacktec.StackTec.configuration;


import javax.annotation.PostConstruct;

import org.apache.http.HttpHost;

import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;



import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

@Log
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "Stacktec")
public class ElasticsearchConfig {
	
	private String elasticSearchUrl;
	
	private boolean loadSearchData;
	
	private boolean loadSearchDataOnInit;
	
	public ElasticsearchClient client() {
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
	RestClient client = builder.build();
		
	ElasticsearchTransport transport = new RestClientTransport(
			client,
			    new JacksonJsonpMapper()
	);

	return new ElasticsearchClient(transport);
			
	}
	
	@PostConstruct
	public void init() {		
		client();
	}

}
