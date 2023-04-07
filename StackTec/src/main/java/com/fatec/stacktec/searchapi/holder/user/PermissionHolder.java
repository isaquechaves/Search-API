package com.fatec.stacktec.searchapi.holder.user;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fatec.stacktec.searchapi.holder.BaseHolder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "permission-index", type = "permission-type", shards = 1, createIndex = false)
public class PermissionHolder extends BaseHolder implements Serializable{
	
	public static final String CACHE_NAME = "permission-longtime-cache";
	
	private Long id;
	
	@Field(type = FieldType.Text, fielddata = true)
	private String name;
	
	private String keycloakId;
	
	@Override
	public Object getCacheKey() { 
		return this.getId();
	}

	@Override
	public String getCacheName() {
		return CACHE_NAME;
	}

}
