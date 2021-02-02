package com.fernando.livraria.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController //Esta anotação define que a classe a seguir é pertencente a uma API de padrão REST
@RequestMapping("/api/v1/livros") //reserva o endereço onde está localizado o endpoint da API

public class Livrocontroller 
{
	@GetMapping
	@ApiOperation(value = "Retorna uma string por meio da API") //informa ao Swagger o propósito da existencia desta API, ou seja, um campo descritivo
	@ApiResponses(value = {
							@ApiResponse(code = 200, message = "Operação efetuada com Sucesso!") //indica os tipos de respostas que podem ocorrer quando acionada essa API, de acordo com o padrão
																								 // de respostas de requisições HTTP
	})
	public String hello() 
	{
		return "Olá! Bem Vindo a Livraria! Esta mensagem foi gerada por uma API REST neste endpoint";
	}
}
