package com.fatec.stacktec.searchapi.service;

import org.springframework.stereotype.Service;

import com.fatec.stacktec.searchapi.holder.PostHolder;
import com.fatec.stacktec.searchapi.repository.PostSearchRepository;
import com.fatec.stacktec.searchapi.search.ESBaseServiceImpl;

@Service
public class PostSearchService extends ESBaseServiceImpl<PostSearchRepository, PostHolder>{

	
}
