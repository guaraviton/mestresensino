package br.com.mestres.ensino.webapp.spring.persistence.dao.helper;

import java.io.Serializable;

public abstract class CrudDAOImpl<T extends Serializable> extends DAO{

	public void salvar(T entidade){
		template.saveOrUpdate(entidade);
	}
	
	public void excluir(T entidade){
		template.delete(entidade);
	}
	
	/*public List<T> get() {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(T.);
		
        return (List<T>) template.findByCriteria(criteria);
    }*/
	
	/*public List<T> get(Serializable id) {
	
	DetachedCriteria criteria = DetachedCriteria.forClass(T.);
	
    return (List<T>) template.findByCriteria(criteria);
}*/
}
