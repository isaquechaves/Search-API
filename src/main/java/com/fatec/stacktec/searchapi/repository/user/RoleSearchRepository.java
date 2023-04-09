package com.fatec.stacktec.searchapi.repository.user;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.fatec.stacktec.searchapi.holder.user.RoleHolder;

@Repository
public interface RoleSearchRepository extends ElasticsearchRepository<RoleHolder, Long>{

}
