package br.com.estudos.bolaoapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudos.bolaoapi.model.dtos.PalpiteDTO;
import br.com.estudos.bolaoapi.services.PalpiteService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/palpites")
@AllArgsConstructor
public class PalpiteController {

	private final PalpiteService palpiteService;

	@PostMapping
	public ResponseEntity<Void> criar(@RequestBody PalpiteDTO palpiteDTO) {

		palpiteService.criar(palpiteDTO);

		return ResponseEntity.ok().build();

	}

}
