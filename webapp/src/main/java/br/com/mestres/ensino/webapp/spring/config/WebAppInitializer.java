package br.com.mestres.ensino.webapp.spring.config;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.springframework.web.WebApplicationInitializer;


public class WebAppInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		configurarBeanUtilsConverter();
	}

	private void configurarBeanUtilsConverter() {
		ConvertUtils.register(new IntegerConverter(null), Integer.class);
		ConvertUtils.register(new DateConverter(null), Date.class);
	}



}
