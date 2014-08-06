package br.com.mestres.ensino.webapp.spring.exception;


public class AppException extends RuntimeException{

	public AppException(String mensagem, Exception e) {
		super(mensagem, e);
	}
}
