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
@Document(indexName = "disciplina-index", type = "disciplina-type", createIndex = false)
public class DisciplinaHolder {
	
	public static final String CACHE_NAME = "disciplina-long-cache";
	
	@Id
	private Long id;
	
	@Field(type = FieldType.Text)
	private String nome;
	
	@Override
	public Object getCacheKey() {
		return this.getId();
	}

	@Override
	public String getCacheName() {
		return CACHE_NAME;
	}

}
