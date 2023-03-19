package com.fatec.stacktec.searchapi.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "tagDto", description = "Sample model for the tag")
public class TagDto {
	
	private Long id;
	
	private Integer qtdePosts;
	
}
