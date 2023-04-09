package com.fatec.stacktec.searchapi.repository;

import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.fatec.stacktec.searchapi.holder.ComentarioHolder;

@Repository
public interface ComentarioSearchRepository extends ElasticsearchRepository<ComentarioHolder, Long>{

	@Override
	@Cacheable(value = ComentarioHolder.CACHE_NAME, key = "#p0", unless = "#result == null")
	Optional<ComentarioHolder> findById(Long comentarioId);
}
