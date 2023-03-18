package com.fatec.stacktec.StackTec.service;

import org.springframework.stereotype.Service;

import com.fatec.stacktec.StackTec.holder.DisciplinaHolder;
import com.fatec.stacktec.StackTec.repository.DisciplinaSearchRepository;
import com.fatec.stacktec.StackTec.search.ESBaseServiceImpl;

@Service
public class UsuarioSearchService extends ESBaseServiceImpl<DisciplinaSearchRepository, DisciplinaHolder> {


}
