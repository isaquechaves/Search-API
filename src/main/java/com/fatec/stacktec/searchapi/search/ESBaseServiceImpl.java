package com.fatec.stacktec.searchapi.search;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;

import com.fatec.stacktec.searchapi.configuration.ElasticsearchConfig;
import com.fatec.stacktec.searchapi.search.ESBaseService;

import lombok.extern.java.Log;

@Log
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public abstract class ESBaseServiceImpl<REPOSITORY extends ElasticsearchRepository, HOLDER> implements ESBaseService<HOLDER> {
	
	protected final String MIN_VALUE = "min_value";
	
	protected final String MAX_VALUE = "max_value";
	
	@Autowired
	protected ElasticsearchConfig elasticsearchConfig; 
	
	@Autowired
	protected ElasticsearchOperations elasticsearchOperations;
	
	@Autowired
	protected REPOSITORY repository;
	
	public Optional findById(Object id) {
		return repository.findById(id);
	}
	
	
	public Page<HOLDER> search(SearchQuery query){
		return repository.search(query);
	}
	
	public List<HOLDER> findAll() {
		return ((AggregatedPageImpl) this.repository.findAll()).getContent();
	}
	
	public Iterable<HOLDER> saveAll(Iterable<HOLDER> holder) {
		return repository.saveAll(holder);
	}
	
	public HOLDER save(HOLDER holder) {
		return (HOLDER) repository.save(holder);		
	}
	
	public void delete(Long elementId) {
		repository.deleteById(elementId);
	}

	public void deleteAll() {
		repository.deleteAll();
	}
	
	public boolean existsById(Long elementId) {
		return repository.existsById(elementId);
	}
	
	public void config(Class clazz) {
		if(!elasticsearchOperations.indexExists((clazz))) {
			elasticsearchOperations.createIndex(clazz);
		}
	}
	
	
}
