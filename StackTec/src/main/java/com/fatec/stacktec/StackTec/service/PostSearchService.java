package com.fatec.stacktec.StackTec.service;

import org.springframework.stereotype.Service;

import com.fatec.stacktec.StackTec.holder.PostHolder;
import com.fatec.stacktec.StackTec.repository.PostSearchRepository;
import com.fatec.stacktec.StackTec.search.ESBaseServiceImpl;

@Service
public class PostSearchService extends ESBaseServiceImpl<PostSearchRepository, PostHolder>{

	
}
