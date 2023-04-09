package com.fatec.stacktec.searchapi.holder;

import org.springframework.data.annotation.Version;

import lombok.Data;

@Data
public abstract class BaseHolder {
	
	@Version 
	protected Long version;
	
	public abstract Object getCacheKey();
	
	public abstract String getCacheName();
}
