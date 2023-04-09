package com.fatec.stacktec.searchapi.dto;

import java.util.List;

import com.fatec.stacktec.searchapi.util.ImgData;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "respostaDto", description = "Sample model for the resposta")
public class RespostaDto {
	
	private Long id;
	
	private Long autorId;
	
	private String texto;
	
	private Integer avaliacao;
	
	private List<ImgData> images;
	
	private boolean aceita;
}
