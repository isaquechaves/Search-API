package com.fatec.stacktec.searchapi.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SearchResult {
		
	private long numResults = 0;
	private String title;
	private String description;
	private String sop;
	private List results = new ArrayList<>();
	private int steps;
	
}
