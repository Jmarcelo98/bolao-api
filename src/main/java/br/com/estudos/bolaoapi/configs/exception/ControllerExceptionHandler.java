package br.com.estudos.bolaoapi.configs.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.estudos.bolaoapi.handlers.RecursoExistente;
import br.com.estudos.bolaoapi.handlers.RecursoNaoEncontrado;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestControllerAdvice()
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(RecursoNaoEncontrado.class)
	public ResponseEntity<Object> handleResourceNotFoundException(RecursoNaoEncontrado ex, WebRequest request) {

		var headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		var status = HttpStatus.NOT_FOUND;
		var body = new ResponseError();

		body.setCode(status.value());
		body.setDescription(ex.getMessage());
		return handleExceptionInternal(ex, body, headers, status, request);
	}

	@ExceptionHandler(RecursoExistente.class)
	public ResponseEntity<Object> handleResourceExistenteException(RecursoExistente ex, WebRequest request) {

		var headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		var status = HttpStatus.BAD_REQUEST;
		var body = new ResponseError();

		body.setCode(status.value());
		body.setDescription(ex.getMessage());
		return handleExceptionInternal(ex, body, headers, status, request);
	}

}
