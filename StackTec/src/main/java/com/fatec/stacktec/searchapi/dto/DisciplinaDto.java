package com.fatec.stacktec.searchapi.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "disciplinaDto", description = "Sample model for the disciplina")
public class DisciplinaDto {
	
	private Long id;
	
	private String nome;
	
	private String descricao;
}
