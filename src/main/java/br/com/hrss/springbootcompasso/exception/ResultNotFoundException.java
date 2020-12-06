package br.com.hrss.springbootcompasso.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResultNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResultNotFoundException(String exception) {
		super(exception);
	}

}
