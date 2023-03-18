package com.fatec.stacktec.StackTec.service;

import org.springframework.stereotype.Service;

import com.fatec.stacktec.StackTec.holder.ComentarioHolder;
import com.fatec.stacktec.StackTec.repository.ComentarioSearchRepository;
import com.fatec.stacktec.StackTec.search.ESBaseServiceImpl;

@Service
public class ComentarioSearchService extends ESBaseServiceImpl<ComentarioSearchRepository, ComentarioHolder>{

}
