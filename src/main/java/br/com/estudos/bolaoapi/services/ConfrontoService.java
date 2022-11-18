package br.com.estudos.bolaoapi.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.estudos.bolaoapi.handlers.RecursoExistente;
import br.com.estudos.bolaoapi.handlers.RecursoNaoEncontrado;
import br.com.estudos.bolaoapi.model.dtos.ConfrontoDTO;
import br.com.estudos.bolaoapi.model.entities.Confronto;
import br.com.estudos.bolaoapi.repositories.ConfrontoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConfrontoService {

	private final SelecaoService selecaoService;

	private final ConfrontoRepository confrontoRepository;

	public void criar(ConfrontoDTO confrontoDTO) {

		var selecaoUm = selecaoService.buscarSelecaoPeloId(confrontoDTO.getSelecaoUm().getId());

		var selecaoDois = selecaoService.buscarSelecaoPeloId(confrontoDTO.getSelecaoDois().getId());

		var confronto = Confronto.builder().id(null).dataJogo(confrontoDTO.getDataJogo()).selecaoUm(selecaoUm)
				.selecaoDois(selecaoDois).build();

		if (verificarSeConfrontoExiste(confronto)) {
			throw new RecursoExistente("O confronto " + confronto.getSelecaoUm().getNome() + " x "
					+ confronto.getSelecaoDois().getNome() + " no dia: " + confronto.getDataJogo() + " já existe");
		}

		confrontoRepository.save(confronto);

	}

	public Confronto buscarConfrontoPeloId(Integer id) {
		return confrontoRepository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontrado("Confronto não encontrado através do ID: " + id));
	}

	public List<Confronto> buscarTodosOsConfrontosBySelecao(Integer idSelecao) {
		var selecao = selecaoService.buscarSelecaoPeloId(idSelecao);

		return confrontoRepository.findAllBySelecaoUmOrSelecaoDoisAndDataJogoLessThanEqual(selecao, selecao,
				LocalDate.now());
	}

	private Boolean verificarSeConfrontoExiste(Confronto confronto) {
		return confrontoRepository.verificarSeConfrontoExiste(confronto.getSelecaoUm(), confronto.getSelecaoDois(),
				confronto.getDataJogo());

	}

}
