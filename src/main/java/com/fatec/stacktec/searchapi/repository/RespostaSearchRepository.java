package com.fatec.stacktec.searchapi.repository;

import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.fatec.stacktec.searchapi.holder.RespostaHolder;

@Repository
public interface RespostaSearchRepository extends ElasticsearchRepository<RespostaHolder, Long>{

	@Override
	@Cacheable(value = RespostaHolder.CACHE_NAME, key = "#p0", unless = "#result == null")
	Optional<RespostaHolder> findById(Long respostaId);
	
}
