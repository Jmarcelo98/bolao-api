package br.com.estudos.bolaoapi.controllers;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudos.bolaoapi.model.dtos.UsuarioDTO;
import br.com.estudos.bolaoapi.services.UsuarioService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioController {

	private final UsuarioService usuarioService;

	@PostMapping
	public ResponseEntity<UsuarioDTO> criar(String nomeCompleto, LocalDate dataNascimento) {

		return ResponseEntity.ok(usuarioService.criar(nomeCompleto, dataNascimento));
	}

}
