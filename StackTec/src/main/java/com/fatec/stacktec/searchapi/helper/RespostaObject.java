package com.fatec.stacktec.searchapi.helper;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespostaObject {
	
	@Field(type = FieldType.Long)
	private Long id;
	
	@Field(type = FieldType.Long)
	private Long autorId;
	
	@Field(type = FieldType.Text)
	private String texto;
	
	@Field(type = FieldType.Integer)
	private Integer avaliacao;
	
	@Field(type = FieldType.Nested)
	private List<OptionObject> images;
	
	@Field(type = FieldType.Double)
	private boolean aceita;
	
}
