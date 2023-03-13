package com.fatec.stacktec.StackTec.helper;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaObject {
	
	@Field(type = FieldType.Long)
	private Long id;
	
	@Field(type = FieldType.Text)
	private String nome;
	
}
