package com.fernando.livraria.autor.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fernando.livraria.autor.builder.AutorDTOBuilder;
import com.fernando.livraria.autor.mapper.AutorMapper;
import com.fernando.livraria.autor.repository.AutorRepository;

@ExtendWith(MockitoExtension.class)
public class AutorServiceTeste  //classe definida para executar testes unitários a respeito do módulo de Autor do sistema da livraria, compreendendo toda a relação entre dados
{
	
	private AutorDTOBuilder autorDTOBuilder;
	private final AutorMapper autorMapper = AutorMapper.INSTANCIA;
	@Mock
	private AutorRepository autorRepo;
	@InjectMocks
	private AutorService autorService;
	
	@BeforeEach
	void setUp() 
	{
		autorDTOBuilder = AutorDTOBuilder.builder().build();
	}
}
