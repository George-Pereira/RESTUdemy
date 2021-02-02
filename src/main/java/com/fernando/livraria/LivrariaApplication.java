package com.fernando.livraria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication //define a raiz do projeto e habilita o gerenciamento do projeto pelo springboot 
@ComponentScan("com.fernando.livraria") //indica o caminho onde o spring boot ira buscar por componentes, beans e entidades relacionadas ao projeto que precisam ser iniciadas para o seu funcionamento correto
@EnableSwagger2 //permite a ativação do swagger como ferramenta de documentação das APIs e seus endpoints
public class LivrariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivrariaApplication.class, args);
	}

}
