package br.com.task.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.task.dao.DAO;
import br.com.task.model.Responsavel;
import br.com.task.utilitarios.NegocioException;

public class ResponsavelService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private DAO<Responsavel> dao;
	
	public void salvar(Responsavel responsavel)throws NegocioException {
		if(responsavel.getNome().length() < 3) {
			throw new NegocioException("O nome do responsável não pode ter menos que 3 caracteres");
		}
		dao.salvar(responsavel);
	}
	
	public void remover(Responsavel responsavel)throws NegocioException {
		dao.remover(Responsavel.class, responsavel.getId());
	}
	
	public List<Responsavel> listarTodos(){
		return dao.buscarTodos("select r from Responsavel r order by r.nome");
	}
	
	
	
}
