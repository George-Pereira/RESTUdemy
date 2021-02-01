package com.fernando.livraria.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class LivrariaExceptionHandler extends ResponseEntityExceptionHandler 
{
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> handlerEntityNotFoundException(EntityNotFoundException exception)
	{
		return buildResponseEntity(HttpStatus.BAD_REQUEST, exception.getMessage(), Collections.singletonList(exception.getMessage()));
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> handlerEntityExistsException(EntityExistsException exception)
	{
		return buildResponseEntity(HttpStatus.BAD_REQUEST, exception.getMessage(), Collections.singletonList(exception.getMessage()));
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) 
	{
		List<String> erros = new ArrayList<>();
		exception.getBindingResult().getFieldErrors().forEach(fieldError -> erros.add("Campo " + fieldError.getField().toUpperCase() + " " + fieldError.getDefaultMessage()));
		exception.getBindingResult().getGlobalErrors().forEach(globalError -> erros.add("Campo " + globalError.getObjectName() + " " + globalError.getDefaultMessage()));
		return buildResponseEntity(HttpStatus.BAD_REQUEST, "Argumento(s) informado(s) não são suportados por essa operação", erros);
	}
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) 
	{
		return buildResponseEntity(HttpStatus.BAD_REQUEST, "Erro de leitura do arquivo JSON, pode haver algum problema com o arquivo ou há informações inválidas", Collections.singletonList(ex.getLocalizedMessage()));
	}
	
	private ResponseEntity<Object> buildResponseEntity(HttpStatus httpstatus, String mensagem, List<String> erros)
	{
		ApiError errosApi = ApiError.builder().codigo(httpstatus.value()).status(httpstatus.getReasonPhrase()).mensagem(mensagem).erros(erros).ocorrencia(LocalDateTime.now()).build();
		return ResponseEntity.status(httpstatus).body(errosApi);
	}
}
