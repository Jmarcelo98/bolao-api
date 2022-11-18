package br.com.estudos.bolaoapi.services;

import org.springframework.stereotype.Service;

import br.com.estudos.bolaoapi.handlers.RecursoExistente;
import br.com.estudos.bolaoapi.model.dtos.PalpiteDTO;
import br.com.estudos.bolaoapi.model.entities.Confronto;
import br.com.estudos.bolaoapi.model.entities.Palpite;
import br.com.estudos.bolaoapi.model.entities.Usuario;
import br.com.estudos.bolaoapi.repositories.PalpiteRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PalpiteService {

	private final PalpiteRepository palpiteRepository;

	private final ConfrontoService confrontoService;

	private final UsuarioService usuarioService;

	public void criar(PalpiteDTO palpiteDTO) {

		var confronto = confrontoService.buscarConfrontoPeloId(palpiteDTO.getConfronto().getId());

		var usuario = usuarioService.buscarPeloId(palpiteDTO.getUsuario().getId());

		if (verificarSePalpiteExiste(usuario, confronto, palpiteDTO)) {
			throw new RecursoExistente("O palpite de: " + confronto.getSelecaoUm().getNome() + " "
					+ palpiteDTO.getGolSelecaoUm() + " x " + confronto.getSelecaoDois().getNome() + " "
					+ palpiteDTO.getGolSelecaoDois() + ", criado por: " + usuario.getNome() + " já existe");
		}

		var palpite = Palpite.builder().id(null).confronto(confronto).usuario(usuario).foiPago(false)
				.golSelecaoUm(palpiteDTO.getGolSelecaoUm()).golSelecaoDois(palpiteDTO.getGolSelecaoDois()).build();

		palpiteRepository.save(palpite);

		System.err.println("em criar");

	}

	private Boolean verificarSePalpiteExiste(Usuario usuario, Confronto confronto, PalpiteDTO palpiteDTO) {
		return palpiteRepository.existsByUsuarioAndConfrontoAndGolSelecaoUmAndGolSelecaoDois(usuario, confronto,
				palpiteDTO.getGolSelecaoUm(), palpiteDTO.getGolSelecaoDois());
	}

}
