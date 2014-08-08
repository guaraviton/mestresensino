package br.com.mestres.ensino.webapp.spring.dto;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorDTO {
	
	private List<ErrorDTO> fieldErrors = new ArrayList<ErrorDTO>();
	
    public ValidationErrorDTO() {
 
    }
 
    public void addFieldError(String field, String message) {
        FieldErrorDTO error = new FieldErrorDTO(field, message);
        fieldErrors.add(error);
    }
    
    public void addError(String message) {
        ErrorDTO error = new ErrorDTO(message);
        fieldErrors.add(error);
    }

	public List<ErrorDTO> getFieldErrors() {
		return fieldErrors;
	}
    
}
