package br.com.estudos.bolaoapi.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estudos.bolaoapi.model.entities.Confronto;
import br.com.estudos.bolaoapi.model.entities.Selecao;

public interface ConfrontoRepository extends JpaRepository<Confronto, Integer> {

	List<Confronto> findAllBySelecaoUmOrSelecaoDoisAndDataLessThanEqual(Selecao selecaoUm, Selecao selecaoDois,
			LocalDate data);

}
