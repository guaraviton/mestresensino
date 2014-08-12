package br.com.mestres.ensino.webapp.spring.persistence.dao.helper;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import br.com.mestres.ensino.webapp.spring.domain.StatusRegistro;
import br.com.mestres.ensino.webapp.spring.exception.AppException;
import br.com.mestres.ensino.webapp.spring.persistence.dao.CrudDAO;
import br.com.mestres.ensino.webapp.spring.persistence.model.BaseEntity;

public abstract class CrudDAOImpl<T extends BaseEntity> extends DAO implements CrudDAO<T>{

	private Class<? extends BaseEntity> entityClass = null;
	
	@SuppressWarnings("unchecked") 
	public CrudDAOImpl() {
		Type builderClass = this.getClass().getGenericSuperclass();
		Type tType = ((ParameterizedType)builderClass).getActualTypeArguments()[0];
		String className = tType.toString().split(" ")[1];
		try {
			entityClass = (Class<? extends BaseEntity>) Class.forName(className);
		} catch (ClassNotFoundException e) {
			throw new AppException("Erro ao definir classe " + entityClass.getClass().getName());
		}
    }
	
	public static String usuario = "teste";
	
	@Override
	public void salvar(T entidade){
		if(entidade.getId() == null){
			entidade.setDataInclusao(Calendar.getInstance().getTime());
			entidade.setUsuarioInclusao(usuario);
			entidade.setStatusRegistro(StatusRegistro.ATIVO.getCodigo());
		}
		entidade.setDataUltimaAtualizacao(Calendar.getInstance().getTime());
		entidade.setUsuarioUltimaAtualizacao(usuario);
		
		template.saveOrUpdate(entidade);
	}
	
	@Override
	public void excluir(T entidade){
		//entidade.setStatusRegistro(StatusRegistro.EXCLUIDO.getCodigo());
		template.delete(entidade);
	}
	
	@SuppressWarnings("unchecked") 
	@Override
	public List<T> get() {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
        return (List<T>) template.findByCriteria(criteria);
    }
	
	@SuppressWarnings("unchecked") 
	@Override
	public T get(Integer id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
		criteria.add(Restrictions.eq("id", id));
		List<T> retorno = (List<T>) template.findByCriteria(criteria);
	    return retorno.isEmpty() ? null : retorno.get(0);
	}
}
