package br.com.estudos.bolaoapi.model.dtos;

import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelecaoDTO {

	private Integer id;

	private String nome;

	@Lob
	private byte[] foto;

}
