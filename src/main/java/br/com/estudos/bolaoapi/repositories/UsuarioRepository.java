package br.com.estudos.bolaoapi.repositories;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estudos.bolaoapi.model.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Optional<Usuario> findByNomeAndDataNascimento(String nomeCompleto, LocalDate dataNascimento);

}
