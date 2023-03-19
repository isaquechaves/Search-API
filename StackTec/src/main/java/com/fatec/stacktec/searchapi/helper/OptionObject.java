package com.fatec.stacktec.searchapi.helper;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OptionObject implements Serializable {
	
	@Field(type = FieldType.Long)
	private Long id;
	
	@Field(type = FieldType.Text)
	private String value;
}
