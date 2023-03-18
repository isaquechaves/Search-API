package com.fatec.stacktec.StackTec.holder;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fatec.stacktec.StackTec.helper.UsuarioObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "comentario-index", type = "comentario-type", createIndex = false)
public class ComentarioHolder {
	
	public static final String CACHE_NAME = "comentario-long-cache";
	
	@Id
	private UsuarioObject autor;
		
	@Field(type = FieldType.Text)
	private String texto;
	
	@Override
	public Object getCacheKey() {
		return this.getId();
	}

	@Override
	public String getCacheName() {
		return CACHE_NAME;
	}

}
