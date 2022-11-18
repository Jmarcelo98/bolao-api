package br.com.estudos.bolaoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estudos.bolaoapi.model.entities.Confronto;
import br.com.estudos.bolaoapi.model.entities.Palpite;
import br.com.estudos.bolaoapi.model.entities.Usuario;

public interface PalpiteRepository extends JpaRepository<Palpite, Integer> {

	Boolean existsByUsuarioAndConfrontoAndGolSelecaoUmAndGolSelecaoDois(Usuario usuario, Confronto confronto,
			Integer golSelecaoUm, Integer golSelecaoDois);

}
