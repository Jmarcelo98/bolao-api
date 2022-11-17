package br.com.estudos.bolaoapi.model.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfrontoDTO {

	private Integer id;

	private SelecaoDTO selecaoUm;

	private SelecaoDTO selecaoDois;

	private LocalDate dataJogo;

}
