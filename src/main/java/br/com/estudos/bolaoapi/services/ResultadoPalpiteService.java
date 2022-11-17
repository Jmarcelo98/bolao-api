package br.com.estudos.bolaoapi.services;

import org.springframework.stereotype.Service;

import br.com.estudos.bolaoapi.handlers.RecursoExistente;
import br.com.estudos.bolaoapi.handlers.RecursoNaoEncontrado;
import br.com.estudos.bolaoapi.mappers.SelecaoMapper;
import br.com.estudos.bolaoapi.model.dtos.SelecaoDTO;
import br.com.estudos.bolaoapi.model.entities.Selecao;
import br.com.estudos.bolaoapi.repositories.SelecaoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ResultadoPalpiteService {

	private final SelecaoRepository selecaoRepository;

	public void criar(SelecaoDTO selecaoDTO) {

		if (buscarSelecaoPeloNome(selecaoDTO.getNome()) != null) {
			throw new RecursoExistente("A seleção: " + selecaoDTO.getNome() + " já está cadastrada");
		}

		selecaoRepository.save(SelecaoMapper.INSTANCE.DTOToEntity(selecaoDTO));

	}

	public Selecao buscarSelecaoPeloNome(String nome) {
		return selecaoRepository.findByNome(nome).orElse(null);

	}

	public Selecao buscarSelecaoPeloId(Integer id) {

		return selecaoRepository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontrado("Seleção não encontrada através do ID"));

	}

}
