package com.fatec.stacktec.searchapi.dto;

import javax.validation.constraints.Email;

import com.fatec.stacktec.searchapi.enumeration.SemestreType;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "usuarioDto", description = "Sample model for the usuario")
public class UsuarioDto {
	
	private Long id;
	
	private String nome;
	
	private String email;
	
	@Email
	private String apelido;
	
	private SemestreType semestre;
}
