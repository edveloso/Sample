package br.com.edveloso.processo.persistence;

import java.util.List;

import br.com.edveloso.processo.entidade.Processo;

public interface IProcessoDAO {

	void salvar(Processo processo);

	void update(Processo processo);
	
	List<Processo> list();

	Processo getProcesso(Integer id);

	void delete(Processo processo); 

	
}