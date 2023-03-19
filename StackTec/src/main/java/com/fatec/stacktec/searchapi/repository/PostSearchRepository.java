package com.fatec.stacktec.searchapi.repository;

import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.fatec.stacktec.searchapi.holder.PostHolder;

@Repository
public interface PostSearchRepository extends ElasticsearchRepository<PostHolder, Long>{
		
	@Override
	@Cacheable(value = PostHolder.CACHE_NAME, key = "#p0", unless = "#result == null")
	Optional<PostHolder> findById(Long postId);
	

}
