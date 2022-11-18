package br.com.estudos.bolaoapi.model.dtos;

import java.time.LocalDate;

import io.swagger.annotations.ApiModelProperty;
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

	@ApiModelProperty(required = true, example = "2022-11-24")
	private LocalDate dataJogo;

}
