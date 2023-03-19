package com.fatec.stacktec.searchapi.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "comentarioDto", description = "Sample model for the comentario")
public class ComentariosDto {
	
	private Long id;
	
	private Long autorId;
	
	private String texto;
}
