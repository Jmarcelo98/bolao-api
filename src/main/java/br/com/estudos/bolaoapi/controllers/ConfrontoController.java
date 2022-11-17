package br.com.estudos.bolaoapi.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudos.bolaoapi.model.dtos.ConfrontoDTO;
import br.com.estudos.bolaoapi.model.entities.Confronto;
import br.com.estudos.bolaoapi.services.ConfrontoService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/confrontos")
@AllArgsConstructor
public class ConfrontoController {

	private final ConfrontoService confrontoService;

	@PostMapping
	public ResponseEntity<Void> criar(@RequestBody ConfrontoDTO confrontoDTO) {
		System.err.println("entrou");
		confrontoService.criar(confrontoDTO);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/selecao/por-id/{id}")
	public ResponseEntity<List<Confronto>> buscarTodosOsConfrontosBySelecao(@PathVariable("id") Integer idSelecao) {
		return ResponseEntity.ok(confrontoService.buscarTodosOsConfrontosBySelecao(idSelecao));
	}

}
