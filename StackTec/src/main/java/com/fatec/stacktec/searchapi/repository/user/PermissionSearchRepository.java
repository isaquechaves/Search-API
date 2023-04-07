package com.fatec.stacktec.searchapi.repository.user;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.fatec.stacktec.searchapi.holder.user.PermissionHolder;

@Repository
public interface PermissionSearchRepository extends ElasticsearchRepository<PermissionHolder, Long>{

}
