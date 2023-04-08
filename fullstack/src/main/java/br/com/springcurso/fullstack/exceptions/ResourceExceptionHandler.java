package br.com.springcurso.fullstack.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	@ExceptionHandler(ResourceNotFoundExceptions.class)
	public ResponseEntity<StandardError> ResourceNotFound(ResourceNotFoundExceptions e,HttpServletRequest request){
		String error = "Exception Not Found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		String message = e.getMessage();
		StandardError err = new StandardError(Instant.now(), status.value(), error, message, request.getRequestURI() );
		return ResponseEntity.status(status).body(err);

		
	}

}
