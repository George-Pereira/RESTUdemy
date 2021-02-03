package com.fernando.livraria.autor.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fernando.livraria.autor.dto.AutorDTO;
import com.fernando.livraria.autor.entity.Autor;

@Mapper
public interface AutorMapper //responsável por realizar o mapeamento e a conexão entre o DTO e o Model do projeto e vice-versa
{
	AutorMapper INSTANCIA = Mappers.getMapper(AutorMapper.class);
	Autor toModel(AutorDTO autorDto);
	AutorDTO toDTO(Autor autor);
}
