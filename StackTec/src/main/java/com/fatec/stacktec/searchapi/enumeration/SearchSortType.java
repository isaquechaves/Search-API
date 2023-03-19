package com.fatec.stacktec.searchapi.enumeration;

import lombok.Getter;

@Getter
public enum SearchSortType {
	
	VOTOS_ASC("Votos: Mais votados"),
	
	RESPOSTAS_ASC("Respostas: menor para o maior"),
	
	RESPOSTAS_DESC("Respostas: maior para o menor"),
	
	DATA_DESC("Mais recentes");
	
	private final String label;
	
	SearchSortType(String label) {
		this.label = label;
	}
	
	public static SearchSortType valueOf(Integer ordinal) {
		if(ordinal != null) {
			for(SearchSortType sort : SearchSortType.values()) {
				if(sort.ordinal() == ordinal) {
					return sort;
				}
			}
		}
		return null;
	}
}
