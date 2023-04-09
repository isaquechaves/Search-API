package com.fatec.stacktec.searchapi.repository;

import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.fatec.stacktec.searchapi.holder.UserInternalHolder;

@Repository
public interface UsuarioSearchRepository extends ElasticsearchRepository<UserInternalHolder, Long>{

	@Override
	@Cacheable(value = UserInternalHolder.CACHE_NAME, key = "#p0", unless = "#result == null")
	Optional<UserInternalHolder> findById(Long comentarioId);
}
