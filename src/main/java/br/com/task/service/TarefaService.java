package br.com.task.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.task.dao.DAO;
import br.com.task.model.Tarefa;
import br.com.task.utilitarios.NegocioException;

public class TarefaService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private DAO<Tarefa> dao;
	
	public void salvar(Tarefa tarefa)throws NegocioException {
		if(tarefa.getTitulo().length() < 3) {
			throw new NegocioException("O Tìtulo da tarefa não pode ter menos que 3 caracteres");
		}
		dao.salvar(tarefa);
	}
	public void remover(Tarefa tarefa)throws NegocioException {
		dao.remover(Tarefa.class, tarefa.getId());
	}
	public List<Tarefa> listarTodos(){
		return dao.buscarTodos("select r from Tarefa r order by r.titulo");
	}
	
	
	
}
