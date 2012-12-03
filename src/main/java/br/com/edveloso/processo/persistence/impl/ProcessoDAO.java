package br.com.edveloso.processo.persistence.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import br.com.edveloso.processo.entidade.Processo;
import br.com.edveloso.processo.persistence.IProcessoDAO;


@Repository
public class ProcessoDAO extends HibernateDaoSupport implements IProcessoDAO {
	
	@Autowired
	public ProcessoDAO(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	public void salvar(Processo processo){
		getHibernateTemplate().save(processo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Processo> list() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Processo.class);
		return getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public Processo getProcesso(Integer id) {
		return getHibernateTemplate().get(Processo.class, id);
	}

	@Override
	public void update(Processo processo) {
		getHibernateTemplate().update(processo);
	}

	@Override
	public void delete(Processo processo) {
		getHibernateTemplate().delete(processo);
	}

}
