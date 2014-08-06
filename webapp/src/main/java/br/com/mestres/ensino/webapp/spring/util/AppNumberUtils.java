package br.com.mestres.ensino.webapp.spring.util;

import java.text.NumberFormat;
import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.mestres.ensino.webapp.spring.exception.AppException;

public class AppNumberUtils {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AppNumberUtils.class);

	public static Integer converte(String numero){
		NumberFormat nb = NumberFormat.getInstance();
		try {
			return nb.parse(numero).intValue();
		} catch (ParseException e) {
			LOGGER.error("Erro converter numero" + numero, e);
			throw new AppException("Erro converter numero" + numero, e);
		}
	}
}
