package com.fatec.stacktec.searchapi.dto;

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
	
	@JsonProperty
	private Long id;
	
	@JsonProperty
	private String titulo;
	
	@JsonProperty
	private String descricao;
	
	@JsonProperty
	private List<TagDto> tags;
	
	@JsonProperty
	private List<RespostaDto> respostas;
	
	@JsonProperty
	private List<ComentariosDto> comentarios;
	
	@JsonProperty
	private UsuarioDto usuario;
	
	@JsonProperty
	private DisciplinaDto disciplinaDto;
	
	@JsonProperty
	private List<ImgData> images;
		
	
}
