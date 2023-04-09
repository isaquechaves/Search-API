package com.fatec.stacktec.searchapi.search;

public interface ESBaseService<HOLDER> {
	
	Iterable<HOLDER> saveAll(Iterable<HOLDER> holder);
	
	HOLDER save(HOLDER holder);
	
	void delete(Long elementId);

}
