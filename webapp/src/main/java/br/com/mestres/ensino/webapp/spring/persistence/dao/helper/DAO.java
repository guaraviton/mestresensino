package br.com.mestres.ensino.webapp.spring.persistence.dao.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

public class DAO {

	@Autowired
	protected HibernateTemplate template;
	
}
