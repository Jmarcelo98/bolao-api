package br.com.estudos.bolaoapi.handlers;

public class RecursoExistente extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RecursoExistente(String mensagem) {
		super(mensagem);
	}

}