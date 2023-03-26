package com.fatec.stacktec.searchapi.service;

import java.util.List;

import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fatec.stacktec.searchapi.holder.PostHolder;
import com.fatec.stacktec.searchapi.repository.PostSearchRepository;
import com.fatec.stacktec.searchapi.search.ESBaseServiceImpl;

@Service
public class PostSearchService extends ESBaseServiceImpl<PostSearchRepository, PostHolder>{
	
	protected final ObjectMapper  objectMapper;
	
	//protected final LookupSearchService lookupSearchService;
	
	public PostSearchService(ObjectMapper objectMapper) { //, LookupSearchService lookupSearchService
		this.objectMapper = objectMapper;
		//this.lookupSearchService = lookupSearchService;		
	}
	
	public List<PostHolder> search(Pageable pageable) {
		QueryBuilder query = QueryBuilders.matchAllQuery();
		
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withIndices("post-index")
				.withSearchType(SearchType.DEFAULT)
				.withQuery(query)
				.withPageable(pageable)
				.build();
		
		List<PostHolder> postList = elasticsearchOperations.queryForList(searchQuery, PostHolder.class);
		
		return postList;
	}

	
}
