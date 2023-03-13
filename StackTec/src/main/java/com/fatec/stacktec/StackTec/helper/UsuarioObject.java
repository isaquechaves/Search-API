package com.fatec.stacktec.StackTec.helper;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioObject {
	
	@Field(type = FieldType.Long)
	private Long id;
	
	@Field(type = FieldType.Text)
	private String nome;
	
	@Field(type = FieldType.Text)
	private String email;
	
	@Field(type = FieldType.Text)
	private String apelido;
	
	/* TO-DO Enum semestres */
	@Field(type = FieldType.Integer)
	private String semestre;
	
}
