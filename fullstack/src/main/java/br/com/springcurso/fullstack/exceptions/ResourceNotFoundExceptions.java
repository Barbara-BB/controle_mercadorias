package br.com.springcurso.fullstack.exceptions;

public class ResourceNotFoundExceptions extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundExceptions(Object id) {
		super("Resource not found with id=" +id);
	}

}