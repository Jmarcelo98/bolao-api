package br.com.estudos.bolaoapi.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PalpiteDTO {

	private Integer id;

	private UsuarioDTO usuario;

	private ConfrontoDTO confronto;

	private Integer golSelecaoUm;

	private Integer golSelecaoDois;

	private Boolean foiPago;

}
