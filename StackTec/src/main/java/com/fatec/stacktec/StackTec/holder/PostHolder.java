package com.fatec.stacktec.StackTec.holder;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fatec.stacktec.StackTec.helper.UsuarioObject;
import com.fatec.stacktec.StackTec.helper.ComentarioObject;
import com.fatec.stacktec.StackTec.helper.DisciplinaObject;
import com.fatec.stacktec.StackTec.helper.OptionObject;
import com.fatec.stacktec.StackTec.helper.RespostaObject;
import com.fatec.stacktec.StackTec.helper.TagObject;

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
	private List<OptionObject> imagens; 
	
	@Override
	public Long getCacheKey() {
		return this.getId();

	@Override
	public String getCacheName() {
		return CACHE_NAME;
	} 

}
