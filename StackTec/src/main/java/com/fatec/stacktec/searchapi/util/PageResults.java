package com.fatec.stacktec.searchapi.util;

import java.util.List;

import lombok.Data;

@Data
public class PageResults {
	
	private long numResults;
	
	private Integer totalPages;
	
	private List results;
}
