package br.com.estudos.bolaoapi.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudos.bolaoapi.model.entities.Confronto;
import br.com.estudos.bolaoapi.services.ConfrontoService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/confrontos")
@AllArgsConstructor
public class ConfrontoController {

	private final ConfrontoService confrontoService;

	@GetMapping
	public ResponseEntity<List<Confronto>> buscarTodosOsConfrontosBySelecao(Integer idSelecao) {
		return ResponseEntity.ok(confrontoService.buscarTodosOsConfrontosBySelecao(idSelecao));
	}

}
