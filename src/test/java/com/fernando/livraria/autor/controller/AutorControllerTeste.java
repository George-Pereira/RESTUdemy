package com.fernando.livraria.autor.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.fernando.livraria.autor.builder.AutorDTOBuilder;
import com.fernando.livraria.autor.service.AutorService;

@ExtendWith(MockitoExtension.class)
public class AutorControllerTeste 
{
	@Mock
	private AutorService autorService;
	@InjectMocks
	private AutorController autorController;
	
	private MockMvc mockmvc;
	
	private AutorDTOBuilder autorDTOBuilder;
	
	@BeforeEach
	void setUp() 
	{
		autorDTOBuilder = AutorDTOBuilder.builder().build();
		mockmvc = MockMvcBuilders.standaloneSetup(autorController).setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver()).setViewResolvers((s, locale) -> new MappingJackson2JsonView()).build();
		
	}
}
