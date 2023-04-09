package com.fatec.stacktec.searchapi.holder;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fatec.stacktec.searchapi.enumeration.SemestreType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "userinternal-index", type = "usuario-type", shards = 1, createIndex = false)
public class UserInternalHolder extends BaseHolder implements Serializable{
	
	public static final String CACHE_NAME = "userinternal-longtime-cache";
	
	@Id
	private Long id;
	
	@Field(type = FieldType.Text, fielddata = true)
	private String name;
		
	@Field(type = FieldType.Text)
	private String email;
	
	@Field(type = FieldType.Text)
	private String apelido;
	
	private SemestreType semestre;
	
	@Override
	public Long getCacheKey() {
		return this.getId();
	}

	@Override
	public String getCacheName() {
		return CACHE_NAME;
	}

}
