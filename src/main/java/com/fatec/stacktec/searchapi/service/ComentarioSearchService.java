package com.fatec.stacktec.searchapi.service;

import org.springframework.stereotype.Service;

import com.fatec.stacktec.searchapi.holder.ComentarioHolder;
import com.fatec.stacktec.searchapi.repository.ComentarioSearchRepository;
import com.fatec.stacktec.searchapi.search.ESBaseServiceImpl;

@Service
public class ComentarioSearchService extends ESBaseServiceImpl<ComentarioSearchRepository, ComentarioHolder>{

}
