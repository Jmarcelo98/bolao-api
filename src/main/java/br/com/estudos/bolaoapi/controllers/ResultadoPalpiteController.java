package br.com.estudos.bolaoapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudos.bolaoapi.services.ResultadoPalpiteService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/resultado-palpite")
@AllArgsConstructor
public class ResultadoPalpiteController {

	private final ResultadoPalpiteService resultadoPalpiteService;

}
