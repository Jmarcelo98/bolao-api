package br.com.estudos.bolaoapi.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultadoPalpite implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, updatable = false)
	private Integer golSelecaoUm;

	@Column(nullable = false, updatable = false)
	private Integer golSelecaoDois;

	@Column(nullable = false, updatable = true)
	private Boolean foiPago;

	@OneToOne(mappedBy = "resultadoPalpite")
	private Palpite palpite;

}
