package br.com.task.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.task.model.Tarefa;
import br.com.task.service.TarefaService;
import br.com.task.utilitarios.Menssage;
import br.com.task.utilitarios.NegocioException;

@Named("tarefBean")
@SessionScoped
public class TarefaMb implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Tarefa tarefa;
	@Inject
	private TarefaService service;
	
	private List<Tarefa> tarefas;
	
	@PostConstruct
	public void carregar() {
		tarefas = service.listarTodos();
	}
	
	public void adicionar() {
		try {
			service.salvar(tarefa);
			tarefa = new Tarefa();
			carregar();

			Menssage.info("Salvo com sucesso");
		} catch (NegocioException e) {
			// TODO: handle exception
			Menssage.Erro(e.getMessage());
		}
	}
	
	public void excluir() {
		try {
			service.remover(tarefa);
			carregar();

			Menssage.info("Tarefa " + tarefa.getTitulo() + " foi Excluida");
		} catch (NegocioException e) {
			// TODO: handle exception
			Menssage.Erro(e.getMessage());
		}
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}
	
	
	
}
