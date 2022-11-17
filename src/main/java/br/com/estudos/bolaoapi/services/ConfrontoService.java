package br.com.estudos.bolaoapi.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.estudos.bolaoapi.model.entities.Confronto;
import br.com.estudos.bolaoapi.repositories.ConfrontoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConfrontoService {

	private final SelecaoService selecaoService;

	private final ConfrontoRepository confrontoRepository;

	public List<Confronto> buscarTodosOsConfrontosBySelecao(Integer idSelecao) {
		var selecao = selecaoService.buscarSelecaoPeloId(idSelecao);

		return confrontoRepository.findAllBySelecaoUmOrSelecaoDoisAndDataLessThanEqual(selecao, selecao,
				LocalDate.now());
	}

}
