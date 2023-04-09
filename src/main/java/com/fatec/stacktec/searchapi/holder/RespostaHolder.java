package com.fatec.stacktec.searchapi.holder;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fatec.stacktec.searchapi.helper.UsuarioObject;
import com.fatec.stacktec.searchapi.util.ImgData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "resposta-index", type = "resposta-type", createIndex = false)
public class RespostaHolder extends BaseHolder implements Serializable {

	public static final String CACHE_NAME = "post-long-cache";

	@Id
	private Long id;
		
	@Field(type = FieldType.Long)
	private Long autorId;
	
	@Field(type = FieldType.Text)
	private String texto;
	
	@Field(type = FieldType.Integer)
	private Integer avaliacao;
	
	@Field(type = FieldType.Nested)
	private List<ImgData> images;
	
	@Field(type = FieldType.Double)
	private boolean aceita;
	
	@Override
	public Long getCacheKey() {
		return this.getId();
	}

	@Override
	public String getCacheName() {
		return CACHE_NAME;
	}

}
