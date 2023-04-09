package com.fatec.stacktec.searchapi.holder;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fatec.stacktec.searchapi.helper.UsuarioObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "comentario-index", type = "comentario-type", createIndex = false)
public class ComentarioHolder extends BaseHolder implements Serializable{ 
	
	public static final String CACHE_NAME = "comentario-long-cache";
	
	@Id
	private Long id;
	
	@Field(type = FieldType.Nested)
	private Long autorId;
		
	@Field(type = FieldType.Text)
	private String texto;
	
	@Override
	public Long getCacheKey() {
		return this.getId();
	}

	@Override
	public String getCacheName() {
		return CACHE_NAME;
	}

}
