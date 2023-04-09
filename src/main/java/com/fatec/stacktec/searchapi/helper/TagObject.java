package com.fatec.stacktec.searchapi.helper;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagObject {
	
	@Field(type = FieldType.Long)
	private Long id;
	
	@Field(type = FieldType.Integer)
	private Integer qtdePosts;
	
}
