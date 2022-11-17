package br.com.estudos.bolaoapi.model.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

	private Integer id;

	private String nomeCompleto;

	private LocalDate dataNascimento;

}
