package br.com.mestres.ensino.webapp.spring.dto;

public class FieldErrorDTO extends ErrorDTO{
	
	private String field;

	public FieldErrorDTO(String field, String message) {
		super(message);
		this.field = field;
		
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
}
