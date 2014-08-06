package br.com.mestres.ensino.webapp.spring.config;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
@ComponentScan(basePackages = { "br.com.mestres.ensino.webapp.spring" })
@PropertySource({ "classpath:webapp.properties" })
public class WebAppConfig extends WebMvcConfigurationSupport {

	private static final String TILES_DEFINITION_FILE = "classpath:tiles-definitions.xml";

	@Value("${default.locale}")
	private String defaultLocale;

	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(TILES_DEFINITION_FILE);
		return tilesConfigurer;
	}

	@Bean
	public UrlBasedViewResolver viewResover() {
		UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
		urlBasedViewResolver.setViewClass(TilesView.class);
		return urlBasedViewResolver;
	}

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver lr = new SessionLocaleResolver();
		lr.setDefaultLocale(new Locale(defaultLocale));
		return lr;
	}
	
		@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations(
				"/resources/");
	}

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		String[] resources = { "classpath:labels", "classpath:messages" };
		messageSource.setBasenames(resources);
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {
		converters.add(jacksonConverter());
		addDefaultHttpMessageConverters(converters);
	}

	public MappingJackson2HttpMessageConverter jacksonConverter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.getObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		converter.getObjectMapper().disable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		converter.getObjectMapper().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		converter.getObjectMapper().enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);		return converter;
	}	

	/*
	 * @Override public void addInterceptors(final InterceptorRegistry registry)
	 * { registry.addInterceptor(new LocaleChangeInterceptor()); }
	 */
}
