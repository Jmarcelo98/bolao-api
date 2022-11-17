package br.com.estudos.bolaoapi.configs.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.estudos.bolaoapi.services.DBService;
import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@Profile("dev")
public class DevConfig {

	private final DBService dbService;

	@Bean
	public boolean instantiateDatabase() {
		dbService.instanciaBancoDeDadosH2();
		return true;
	}

}