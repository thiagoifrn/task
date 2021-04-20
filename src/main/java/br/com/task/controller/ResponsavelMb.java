package br.com.task.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.task.model.Responsavel;
import br.com.task.service.ResponsavelService;
import br.com.task.utilitarios.Menssage;
import br.com.task.utilitarios.NegocioException;

@Named("respBean")
@SessionScoped
public class ResponsavelMb implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Responsavel responsavel;
	@Inject
	private ResponsavelService responsavelService;

	private List<Responsavel> responsaveis = new ArrayList<Responsavel>();

	@PostConstruct
	public void carregar() {
		responsaveis = responsavelService.listarTodos();
	}

	public void adicionar() {
		try {
			responsavelService.salvar(responsavel);
			responsavel = new Responsavel();
			carregar();

			Menssage.info("Salvo com sucesso");
		} catch (NegocioException e) {
			// TODO: handle exception
			Menssage.Erro(e.getMessage());
		}
	}

	public void excluir() {
		try {
			responsavelService.remover(responsavel);
			carregar();

			Menssage.info("Responsável " + responsavel.getNome() + " foi Excluido");
		} catch (NegocioException e) {
			// TODO: handle exception
			Menssage.Erro(e.getMessage());
		}
	}


	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public List<Responsavel> getResponsaveis() {
		return responsaveis;
	}

}
