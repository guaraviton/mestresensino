package br.com.mestres.ensino.webapp.spring.exception;


public class AppDeserializeException extends AppException{
	
	private String campo;

	public AppDeserializeException(String campo, Exception e) {
		super(e);
		this.campo = campo;
	}

	public String getCampo() {
		return campo;
	}
}
