package br.com.luaraamaral;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com.luaraamaral")
public class GerenciamentoDeVagasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciamentoDeVagasApplication.class, args);
	}

}
