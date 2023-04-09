package com.fatec.stacktec.searchapi.holder;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fatec.stacktec.searchapi.helper.ComentarioObject;
import com.fatec.stacktec.searchapi.helper.DisciplinaObject;
import com.fatec.stacktec.searchapi.helper.OptionObject;
import com.fatec.stacktec.searchapi.helper.RespostaObject;
import com.fatec.stacktec.searchapi.helper.TagObject;
import com.fatec.stacktec.searchapi.helper.UsuarioObject;
import com.fatec.stacktec.searchapi.util.ImgData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "post-index", type = "post-type", createIndex = false)
public class PostHolder extends BaseHolder implements Serializable {
	
	public static final String CACHE_NAME = "post-longtime-cache";
	
	@Id
	private Long id;
	
	@Field(type = FieldType.Text)
	private String titulo;
	
	@Field(type = FieldType.Text)
	private String descricao;
	
	@Field(type = FieldType.Nested)
	private List<TagObject> tags;
	
	@Field(type = FieldType.Nested)
	private List<RespostaObject> respostas;
	
	@Field(type = FieldType.Nested)
	private List<ComentarioObject> comentarios;
	
	@Field(type = FieldType.Nested)
	private UsuarioObject autor;
	
	@Field(type = FieldType.Nested)
	private DisciplinaObject disciplina;
	
	@Field(type = FieldType.Nested)
	private List<ImgData> imagens; 
	
	@Field(type = FieldType.Date)
	private Date criadoEm;

	@Field(type = FieldType.Date)
	private Date atualizadoEm;
	
	@Override
	public Long getCacheKey() {
		return this.getId();
	}
	
	@Override
	public String getCacheName() {
		return CACHE_NAME;
	} 

}
