package br.com.estudos.bolaoapi.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

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

		confrontoRepository.save(Confronto.builder().id(null).dataJogo(confrontoDTO.getDataJogo()).selecaoUm(selecaoUm)
				.selecaoDois(selecaoDois).build());

	}

	public List<Confronto> buscarTodosOsConfrontosBySelecao(Integer idSelecao) {
		var selecao = selecaoService.buscarSelecaoPeloId(idSelecao);

		return confrontoRepository.findAllBySelecaoUmOrSelecaoDoisAndDataJogoLessThanEqual(selecao, selecao,
				LocalDate.now());
	}

}
