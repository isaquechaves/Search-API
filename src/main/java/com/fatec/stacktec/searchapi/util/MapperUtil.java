package com.fatec.stacktec.searchapi.util;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.fatec.stacktec.searchapi.dto.PostDto;
import com.fatec.stacktec.searchapi.holder.PostHolder;
import com.fatec.stacktec.searchapi.service.PostSearchService;

@Component
public class MapperUtil {
	
	private final ModelMapper modelMapper;
	
	private final PostSearchService postSearchService;
		
	public MapperUtil(ModelMapper modelMapper, PostSearchService postSearchService) {
		this.modelMapper = modelMapper;
		this.postSearchService = postSearchService;
	}

	public List<PostDto> mapPostDtosFromsHolder(List<PostHolder> results) {
		// TODO Auto-generated method stub
		return null;
	}
}
