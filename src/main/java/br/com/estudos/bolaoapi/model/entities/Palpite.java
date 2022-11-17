package br.com.estudos.bolaoapi.model.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Palpite implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "ID_USUARIO", nullable = false, updatable = false)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "ID_CONFRONTO", nullable = false)
	private Confronto confronto;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_RESULTADO_PALPITE", nullable = false)
	private ResultadoPalpite resultadoPalpite;

}
