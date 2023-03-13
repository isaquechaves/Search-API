package com.fatec.stacktec.StackTec.helper;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComentarioObject {
	
	@Field(type = FieldType.Nested)
	private UsuarioObject autor;
	
	@Field(type = FieldType.Text)
	private String texto;

}
