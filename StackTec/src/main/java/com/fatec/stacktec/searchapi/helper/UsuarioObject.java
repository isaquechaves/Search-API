package com.fatec.stacktec.searchapi.helper;


import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fatec.stacktec.searchapi.enumeration.SemestreType;

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
	
	private SemestreType semestre;
	
}
