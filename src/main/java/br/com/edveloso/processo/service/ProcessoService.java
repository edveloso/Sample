package br.com.edveloso.processo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.edveloso.processo.entidade.Processo;
import br.com.edveloso.processo.persistence.IProcessoDAO;
import br.com.edveloso.processo.util.Assert;

@Service
public class ProcessoService {

	@Autowired
	private IProcessoDAO processoDAO;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void salvar(Processo processo){
		processoDAO.salvar(processo);
	}

	
	public IProcessoDAO getProcessoDAO() {
		return processoDAO;
	}

	public void setProcessoDAO(IProcessoDAO processoDAO) {
		this.processoDAO = processoDAO;
	}

	public List<Processo> listar() {
		
		return processoDAO.list();
	}


	public Processo getProcesso(Integer id) {
		return processoDAO.getProcesso(id);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void update(Processo processo) {
		this.processoDAO.update(processo);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void delete(Integer id) {
		Processo processo = this.processoDAO.getProcesso(id);
		if(Assert.objectNull(processo)) return;
		this.processoDAO.delete(processo);
	}

}
