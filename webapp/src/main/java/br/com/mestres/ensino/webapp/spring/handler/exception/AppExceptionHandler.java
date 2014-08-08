package br.com.mestres.ensino.webapp.spring.handler.exception;

import java.util.List;

import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.mestres.ensino.webapp.spring.dto.ValidationErrorDTO;
import br.com.mestres.ensino.webapp.spring.exception.AppBusinessException;
import br.com.mestres.ensino.webapp.spring.exception.AppDeserializeException;
import br.com.mestres.ensino.webapp.spring.util.message.AppMessageUtils;

import com.fasterxml.jackson.databind.JsonMappingException;

@ControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler({AppBusinessException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ValidationErrorDTO handleBusinessException(AppBusinessException abe) {
		ValidationErrorDTO dto = new ValidationErrorDTO();
		dto.addFieldError(null, abe.getMessage());
		return dto;
	}
	
	
	@ExceptionHandler({HttpMessageNotReadableException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ValidationErrorDTO handleMappingException(HttpMessageNotReadableException hmr) {
		if(hmr.getCause() instanceof JsonMappingException && hmr.getCause().getCause() instanceof AppDeserializeException){
			ValidationErrorDTO dto = new ValidationErrorDTO();
			AppDeserializeException ex = (AppDeserializeException) hmr.getCause().getCause();
			String localizedErrorMessage = AppMessageUtils.get("Invalido." + ex.getCampo());
			dto.addFieldError(ex.getCampo(), localizedErrorMessage);
			return dto;
		}else{
			throw hmr;
		}
	}
	
	@ExceptionHandler({MethodArgumentNotValidException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ValidationErrorDTO handleValidationException(MethodArgumentNotValidException mav) {
		BindingResult result = mav.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
 
        return processFieldErrors(fieldErrors);
	}
	
	private ValidationErrorDTO processFieldErrors(List<FieldError> fieldErrors) {
        ValidationErrorDTO dto = new ValidationErrorDTO();
 
        for (FieldError fieldError: fieldErrors) {
            String localizedErrorMessage = resolveLocalizedErrorMessage(fieldError);
            dto.addFieldError(fieldError.getField(), localizedErrorMessage);
        }
 
        return dto;
    }
 
    private String resolveLocalizedErrorMessage(FieldError fieldError) {
        String localizedErrorMessage = "";
 
        for(String key : fieldError.getCodes()){
        	try{
        		localizedErrorMessage = AppMessageUtils.get(key);
        		break;
        	}catch(NoSuchMessageException ex){}
        	
        }
 
        return localizedErrorMessage;
    }
}
