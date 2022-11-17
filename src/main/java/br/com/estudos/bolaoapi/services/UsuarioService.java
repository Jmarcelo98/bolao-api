package br.com.estudos.bolaoapi.services;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import br.com.estudos.bolaoapi.mappers.UsuarioMapper;
import br.com.estudos.bolaoapi.model.dtos.UsuarioDTO;
import br.com.estudos.bolaoapi.model.entities.Usuario;
import br.com.estudos.bolaoapi.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	public UsuarioDTO criar(String nomeCompleto, LocalDate dataNascimento) {

		var usuarioExistente = buscarUsuarioPeloNomeCompletoETelefone(nomeCompleto, dataNascimento);

		if (usuarioExistente != null) {
			return UsuarioMapper.INSTANCE.entityToDTO(usuarioExistente);
		}

		var usuario = Usuario.builder().id(null).nomeCompleto(nomeCompleto).dataNascimento(dataNascimento).build();
		usuarioRepository.save(usuario);

		return UsuarioMapper.INSTANCE.entityToDTO(usuario);

	}

	private Usuario buscarUsuarioPeloNomeCompletoETelefone(String nomeCompleto, LocalDate dataNascimento) {

		return usuarioRepository.findByNomeCompletoAndDataNascimento(nomeCompleto, dataNascimento).orElse(null);

	}

}
