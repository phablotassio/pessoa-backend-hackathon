package com.stefanini.pessoa.dtos;


public class NegocioExceptionDto {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public NegocioExceptionDto(String message) {
		super();
		this.message = message;
	}
	
	
	
	

}
