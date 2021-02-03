package com.fernando.livraria.autor.builder;

import com.fernando.livraria.autor.dto.AutorDTO;

import lombok.Builder;

@Builder
public class AutorDTOBuilder 
{
	@Builder.Default
	private final Long id = 1L;
	@Builder.Default
	private final Integer idade = 21;
	@Builder.Default
	private final String nome = "Fernando George Pereira";
	
	
	private AutorDTO buildAutorDTO() 
	{
		return new AutorDTO(id, nome, idade);
	}
}
