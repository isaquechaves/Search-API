package com.fatec.stacktec.searchapi.search;

import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import com.fatec.stacktec.searchapi.util.BeanUtil;

public class ESUtil {
	
	public static void createIndex(ElasticsearchOperations elasticsearchOperations, Class holder) {
		if(!elasticsearchOperations.indexExists(holder)) {
			elasticsearchOperations.createIndex(holder);
		}
	}
	
	public static void createIndex(Class holder) {
		ElasticsearchOperations elasticsearchOperations = BeanUtil.getBean(ElasticsearchOperations.class);
		createIndex(elasticsearchOperations, holder);
	}
}
