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
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "tag-index", type = "tag-type", createIndex = false)
public class TagHolder extends BaseHolder implements Serializable{
	
	public static final String CACHE_NAME = "tag-long-cache";
	
	@Id
	private Long id;
	
	@Field(type = FieldType.Integer)
	private Integer qtdePosts;
	
	@Override
	public Long getCacheKey() {
		return this.getId();
	}

	@Override
	public String getCacheName() {
		return CACHE_NAME;
	}

}
