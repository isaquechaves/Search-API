package com.fatec.stacktec.searchapi.helper;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComentarioObject {
	
	@Field(type = FieldType.Long)
	private Long autorId;
	
	@Field(type = FieldType.Text)
	private String texto;

}
