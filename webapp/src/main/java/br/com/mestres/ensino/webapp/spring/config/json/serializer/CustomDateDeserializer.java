package br.com.mestres.ensino.webapp.spring.config.json.serializer;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.validation.BindingResult;

import br.com.mestres.ensino.webapp.spring.exception.AppDeserializeException;
import br.com.mestres.ensino.webapp.spring.exception.AppException;
import br.com.mestres.ensino.webapp.spring.util.AppDateUtils;
import br.com.mestres.ensino.webapp.spring.util.AppStringUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomDateDeserializer extends JsonDeserializer<Date>{

	@Resource
	private BindingResult result;
	
	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		try{
			String data = jp.getText();
			return AppStringUtils.isNotBlank(data) ? AppDateUtils.parse(data) : null;
		}catch (AppException e){
			throw new AppDeserializeException(jp.getCurrentName(), e);
		}
		
	}
	
}
