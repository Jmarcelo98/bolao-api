package br.com.estudos.bolaoapi.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudos.bolaoapi.model.dtos.SelecaoDTO;
import br.com.estudos.bolaoapi.services.SelecaoService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/selecoes")
@AllArgsConstructor
public class SelecaoController {

	private final SelecaoService selecaoService;

	@PostMapping
	public ResponseEntity<Void> criar(@RequestBody SelecaoDTO selecaoDTO) {
		selecaoService.criar(selecaoDTO);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/buscar-todas")
	public ResponseEntity<List<SelecaoDTO>> buscarTodasAsSelecoes() {
		return ResponseEntity.ok(selecaoService.buscarTodasAsSelecoes());
	}

}
