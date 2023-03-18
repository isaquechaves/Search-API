package com.fatec.stacktec.StackTec.repository;

import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.fatec.stacktec.StackTec.holder.TagHolder;

@Repository
public interface TagSearchRepository extends ElasticsearchRepository<TagHolder, Long>{

	@Override
	@Cacheable(value = TagHolder.CACHE_NAME, key = "#p0", unless = "#result == null")
	Optional<TagHolder> findById(Long tagId);
}
