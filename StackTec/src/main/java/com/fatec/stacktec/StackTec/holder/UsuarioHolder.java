package com.fatec.stacktec.StackTec.holder;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "usuario-index", type = "usuario-type", createIndex = false)
public class UsuarioHolder {
	
	public static final String CACHE_NAME = "usuario-long-cache";
	
	@Id
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
	
	@Override
	public Object getCacheKey() {
		return this.getId();
	}

	@Override
	public String getCacheName() {
		return CACHE_NAME;
	}

}
