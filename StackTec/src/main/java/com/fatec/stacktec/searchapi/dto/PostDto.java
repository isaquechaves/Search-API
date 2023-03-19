package com.fatec.stacktec.searchapi.dto;

import java.util.Comparator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fatec.stacktec.searchapi.util.ImgData;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "postDto", description = "Sample model for the post")
public class PostDto {
	
	
	private Long id;
	
	private String titulo;
	
	private String descricao;
	
	private List<TagDto> tags;
	
	private List<RespostaDto> respostas;
	
	private List<ComentariosDto> comentarios;
	
	private UsuarioDto usuario;
	
	private DisciplinaDto disciplinaDto;
	
	private List<ImgData> images;
		
	
}