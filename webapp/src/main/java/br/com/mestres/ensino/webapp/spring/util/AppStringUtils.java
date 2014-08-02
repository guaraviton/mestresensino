package br.com.mestres.ensino.webapp.spring.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppStringUtils {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AppStringUtils.class);

	public static boolean isNotBlank(String str) {
		return StringUtils.isNotBlank(str);
	}
}
