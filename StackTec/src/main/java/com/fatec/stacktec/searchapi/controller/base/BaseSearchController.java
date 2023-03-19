package com.fatec.stacktec.searchapi.controller.base;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public abstract class BaseSearchController {
	
	@Autowired
	protected ModelMapper modelMapper;
	
	@Autowired
	protected ObjectMapper objectMapper;
}
