package com.fatec.stacktec.StackTec.repository;

import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.fatec.stacktec.StackTec.holder.UsuarioHolder;

@Repository
public interface UsuarioSearchRepository extends ElasticsearchRepository<UsuarioHolder, Long>{

	@Override
	@Cacheable(value = UsuarioHolder.CACHE_NAME, key = "#p0", unless = "#result == null")
	Optional<UsuarioHolder> findById(Long comentarioId);
}
