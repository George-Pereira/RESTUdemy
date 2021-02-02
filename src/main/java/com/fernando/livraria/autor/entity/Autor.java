package com.fernando.livraria.autor.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fernando.livraria.entity.Auditoria;
import com.fernando.livraria.livro.entity.Livro;

import lombok.Data;

@Data //através desta anotação do lombok é indicado que esta classe possui atributos pertencentes a uma entidade de negócio do projeto, assim sendo necessários Getters, Setters e Construtores
@Entity //indica que esta é uma entidade de negócio
public class Autor extends Auditoria
{
	@Id //assinala que o atributo abaixo é a chave primaria de um banco de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY) //define o tipo de valor gerado pelo SGBD, que será integrado ao projeto, quando se faz necessário a geração de valores automaticamente 
	private Long id;
	@Column(nullable= false, unique= true) //define propriedades acerca das colunas na tabela de um banco de dados, neste caso são deifnidos atributos NOT NULL e UNIQUE para atribuições no banco
	private String nome;
	@Column(columnDefinition = "integer default 0") //columnDefinition define que o valor inicial padrão desta coluna é sempre 0
	private int idade;
	@OneToMany(mappedBy = "autor", fetch = FetchType.LAZY) //Define o tipo de relação existente entre entidades de negócio e o sentido dessa relação, assim como o tipo de procura no banco, apontado
														   // pelo fetchtype - neste caso quando em LAZY, só serão trazidas para a aplicação as informações definidas e nada mais, em EAGER, o
														  // banco trará mais informações, inclusive pertencentes a entidade relacionada, onde nesse caso seriam pertencentes a tabela livro
	private List<Livro> obras;
}
