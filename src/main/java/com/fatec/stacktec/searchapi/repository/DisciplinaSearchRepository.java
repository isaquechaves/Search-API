package com.fatec.stacktec.searchapi.repository;

import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.fatec.stacktec.searchapi.holder.DisciplinaHolder;

@Repository
public interface DisciplinaSearchRepository extends ElasticsearchRepository<DisciplinaHolder, Long>{

	@Override
	@Cacheable(value = DisciplinaHolder.CACHE_NAME, key = "#p0", unless = "#result == null")
	Optional<DisciplinaHolder> findById(Long comentarioId);
}
