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

	public UsuarioDTO criar(UsuarioDTO usuarioDTO) {

		var usuarioExistente = buscarUsuarioPeloNomeCompletoEDataNascimento(usuarioDTO.getNomeCompleto(),
				usuarioDTO.getDataNascimento());

		if (usuarioExistente != null) {
			return UsuarioMapper.INSTANCE.entityToDTO(usuarioExistente);
		}

		var usuario = Usuario.builder().id(null).nomeCompleto(usuarioDTO.getNomeCompleto())
				.dataNascimento(usuarioDTO.getDataNascimento()).build();
		usuarioRepository.save(usuario);

		return UsuarioMapper.INSTANCE.entityToDTO(usuario);

	}

	private Usuario buscarUsuarioPeloNomeCompletoEDataNascimento(String nomeCompleto, LocalDate dataNascimento) {

		return usuarioRepository.findByNomeCompletoAndDataNascimento(nomeCompleto, dataNascimento).orElse(null);

	}

}
