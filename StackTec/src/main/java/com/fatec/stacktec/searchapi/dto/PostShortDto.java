package com.fatec.stacktec.searchapi.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class PostShortDto {
	
	private Long id;
	
	private String titulo;
	
	private String descricao;
	
	private List<TagDto> tags;

	private Date criadoEm;

}
