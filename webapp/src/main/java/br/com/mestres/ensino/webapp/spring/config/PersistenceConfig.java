package br.com.mestres.ensino.webapp.spring.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.mestres.ensino.webapp.spring.persistence.model.Aluno;
import br.com.mestres.ensino.webapp.spring.persistence.model.AlunoAula;
import br.com.mestres.ensino.webapp.spring.persistence.model.Aula;
import br.com.mestres.ensino.webapp.spring.persistence.model.Professor;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:persistence-mysql.properties" })
@ComponentScan({ "br.com.mestres.ensino.webapp.spring.persistence" })
public class PersistenceConfig {
	
	@Value("${jndi.datasource}")
    private String jndiDataSource;
	
	@Value("${hibernate.dialect}")
    private String hibernateDialect;
	
	@Value("${hibernate.globally_quoted_identifiers}")
    private String hibernateGloballyQuotedIdentifiers;
	
	@Value("${hibernate.show_sql}")
    private String hibernateShowSql;
	
	@Value("${hibernate.format_sql}")
    private String hibernateFormatSql;
	
	@Value("${spring.package_to_scan}")
    private String springPackageToScan;
	
	/*@Autowired
	private Environment env;*/

	@Bean
	public LocalSessionFactoryBean sessionFactory() throws Exception {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(restDataSource());
		sessionFactory.setPackagesToScan(new String[] {springPackageToScan});
		sessionFactory.setHibernateProperties(hibernateProperties());
		//sessionFactory.setAnnotatedClasses(annotatedClasses());
		return sessionFactory;
	}

	@Bean
	public DataSource restDataSource() throws Exception {
	    JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        dsLookup.setResourceRef(true);
        DataSource dataSource = dsLookup.getDataSource("jdbc/"+jndiDataSource);
        return dataSource;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}
	
	@Bean
	@Autowired
	public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory) {
		HibernateTemplate hibernateTemplate = new HibernateTemplate();
		hibernateTemplate.setSessionFactory(sessionFactory);
		return hibernateTemplate;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	Class<?>[] annotatedClasses() {
		return new Class<?>[]{
				Aluno.class,
				Professor.class,
				Aula.class,
				AlunoAula.class
		};
		
	}

	Properties hibernateProperties() {
		return new Properties() {
			private static final long serialVersionUID = 1L;

			{
				setProperty("hibernate.dialect", hibernateDialect);
				setProperty("hibernate.globally_quoted_identifiers", hibernateGloballyQuotedIdentifiers);
				setProperty("hibernate.show_sql", hibernateShowSql);
				setProperty("hibernate.format_sql", hibernateFormatSql);
			}
		};
	}
}
