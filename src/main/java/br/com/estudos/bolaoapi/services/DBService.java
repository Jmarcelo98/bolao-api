package br.com.estudos.bolaoapi.services;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import br.com.estudos.bolaoapi.model.entities.Confronto;
import br.com.estudos.bolaoapi.model.entities.Palpite;
import br.com.estudos.bolaoapi.model.entities.Selecao;
import br.com.estudos.bolaoapi.model.entities.Usuario;
import br.com.estudos.bolaoapi.repositories.ConfrontoRepository;
import br.com.estudos.bolaoapi.repositories.PalpiteRepository;
import br.com.estudos.bolaoapi.repositories.SelecaoRepository;
import br.com.estudos.bolaoapi.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DBService {

	private final SelecaoRepository selecaoRepository;
	private final UsuarioRepository usuarioRepository;
	private final ConfrontoRepository confrontoRepository;
	private final PalpiteRepository palpiteRepository;

	public void instanciaBancoDeDadosH2() {

		var selecaoBrasil = Selecao.builder().id(null).nome("Brasil").foto(null).build();
		var selecaoServia = Selecao.builder().id(null).nome("Sérvia").foto(null).build();
		var selecaoCamaroes = Selecao.builder().id(null).nome("Camarões").foto(null).build();
		var selecaoSuica = Selecao.builder().id(null).nome("Suiça").foto(null).build();

		selecaoRepository.saveAll(Arrays.asList(selecaoBrasil, selecaoServia, selecaoCamaroes, selecaoSuica));

		var confronto1 = Confronto.builder().id(null).selecaoUm(selecaoBrasil).selecaoDois(selecaoServia)
				.dataJogo(LocalDate.of(2022, 11, 24)).build();
		var confronto2 = Confronto.builder().id(null).selecaoUm(selecaoBrasil).selecaoDois(selecaoSuica)
				.dataJogo(LocalDate.of(2022, 11, 28)).build();
		var confronto3 = Confronto.builder().id(null).selecaoUm(selecaoBrasil).selecaoDois(selecaoCamaroes)
				.dataJogo(LocalDate.of(2022, 12, 2)).build();

		confrontoRepository.saveAll(Arrays.asList(confronto1, confronto2, confronto3));

		var usuario1 = Usuario.builder().id(null).nome("João Marcelo").dataNascimento(LocalDate.of(1998, 11, 16))
				.build();

		usuarioRepository.saveAll(Arrays.asList(usuario1));

		var palpite1 = Palpite.builder().id(null).usuario(usuario1).confronto(confronto1).foiPago(false).golSelecaoUm(1)
				.golSelecaoDois(0).build();

		palpiteRepository.saveAll(Arrays.asList(palpite1));

	}

}
