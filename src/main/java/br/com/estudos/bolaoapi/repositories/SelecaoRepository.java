package br.com.estudos.bolaoapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estudos.bolaoapi.model.entities.Selecao;

public interface SelecaoRepository extends JpaRepository<Selecao, Integer> {

	Optional<Selecao> findByNome(String nome);

}
