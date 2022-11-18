package br.com.estudos.bolaoapi.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.estudos.bolaoapi.model.entities.Confronto;
import br.com.estudos.bolaoapi.model.entities.Selecao;

public interface ConfrontoRepository extends JpaRepository<Confronto, Integer> {

	List<Confronto> findAllBySelecaoUmOrSelecaoDoisAndDataJogoLessThanEqual(Selecao selecaoUm, Selecao selecaoDois,
			LocalDate dataJogo);

	@Query("SELECT CASE WHEN EXISTS " + "( SELECT c FROM Confronto c WHERE c.selecaoUm = ?1 or c.selecaoUm = ?2 "
			+ "AND c.selecaoDois = ?1 or c.selecaoDois = ?2 and c.dataJogo = ?3 ) then 'TRUE' else 'FALSE' END From Confronto")
	Boolean verificarSeConfrontoExiste(Selecao selecaoUm, Selecao selecaoDois, LocalDate dataJogo);

}
