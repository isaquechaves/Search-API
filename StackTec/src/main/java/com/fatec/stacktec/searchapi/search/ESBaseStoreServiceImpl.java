package com.fatec.stacktec.searchapi.search;

import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public abstract class ESBaseStoreServiceImpl<REPOSITORY extends ElasticsearchRepository, HOLDER, MODEL> 
		extends ESBaseServiceImpl<REPOSITORY, HOLDER> implements ESBaseService<HOLDER> {
	abstract public void getInitialElements();
	
	abstract public Optional<HOLDER> fillHolderElement(MODEL model);

}
