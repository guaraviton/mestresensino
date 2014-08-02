package br.com.mestres.ensino.webapp.spring.util;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppBeanProperties {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AppBeanProperties.class);

	public static void copyProperties(Object dest, Object orig){
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (Exception e) {
			LOGGER.error("Erro copyProperties", e);
		}
	}
}
