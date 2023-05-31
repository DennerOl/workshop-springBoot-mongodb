package com.denerol.workshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}
/* Trata a exceção de busca de ID que não
 * existe na base de dados	
 */
	
	
}
