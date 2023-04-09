package com.fatec.stacktec.searchapi.holder;

import java.io.Serializable;

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
public class DisciplinaHolder extends BaseHolder implements Serializable{
	
	public static final String CACHE_NAME = "disciplina-long-cache";
	
	@Id
	private Long id;
	
	@Field(type = FieldType.Text)
	private String nome;
	
	@Field(type = FieldType.Text)
	private String descricao;
	
	@Override
	public Long getCacheKey() {
		return this.getId();
	}

	@Override
	public String getCacheName() {
		return CACHE_NAME;
	}

}
