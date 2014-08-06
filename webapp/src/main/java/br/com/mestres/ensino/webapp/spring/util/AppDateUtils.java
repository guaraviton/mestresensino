package br.com.mestres.ensino.webapp.spring.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.mestres.ensino.webapp.spring.exception.AppException;

public class AppDateUtils {
	
	private static final SimpleDateFormat SDF_DEFAULT = new SimpleDateFormat("dd/MM/yyyy");

	public static Date parse(String data) {
		try {
			return SDF_DEFAULT.parse(data);
		} catch (ParseException e) {
			throw new AppException("Erro ao parse data " + data, e);
		}
	}
	
	public static String format(Date data) {
		return SDF_DEFAULT.format(data);
	}
}
