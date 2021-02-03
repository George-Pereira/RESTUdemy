package com.fernando.livraria.autor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.livraria.autor.mapper.AutorMapper;
import com.fernando.livraria.autor.repository.AutorRepository;

@Service
public class AutorService 
{
	private final static AutorMapper autorMapper = AutorMapper.INSTANCIA;
	
	private AutorRepository autorRepo;
	
	@Autowired
	public AutorService(AutorRepository autorRepo) 
	{
		this.autorRepo = autorRepo;
	}
}
