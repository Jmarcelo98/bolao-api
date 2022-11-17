package br.com.estudos.bolaoapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudos.bolaoapi.services.PlacarPalpiteService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/placar-palpite")
@AllArgsConstructor
public class PlacarPalpiteController {

	private final PlacarPalpiteService placarPalpiteService;

//	@PostMapping
//	public ResponseEntity<Void> criar() {
//
//	}

}
