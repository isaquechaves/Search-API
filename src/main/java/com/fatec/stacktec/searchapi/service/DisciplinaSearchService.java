package com.fatec.stacktec.searchapi.service;

import org.springframework.stereotype.Service;

import com.fatec.stacktec.searchapi.holder.DisciplinaHolder;
import com.fatec.stacktec.searchapi.repository.DisciplinaSearchRepository;
import com.fatec.stacktec.searchapi.search.ESBaseServiceImpl;

@Service
public class DisciplinaSearchService extends ESBaseServiceImpl<DisciplinaSearchRepository, DisciplinaHolder> {

}
