package br.com.mestres.ensino.webapp.spring.config.json.serializer;

import java.io.IOException;
import java.util.Date;

import br.com.mestres.ensino.webapp.spring.util.AppDateUtils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomDateSerializer extends JsonSerializer<Date>{

	@Override
	public void serialize(Date value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
        jgen.writeString(AppDateUtils.format(value));
		
	}  
}
