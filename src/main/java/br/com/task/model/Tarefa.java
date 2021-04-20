package br.com.task.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.task.repository.BaseRepository;


@Entity
@Table(name="tarefa")
public class Tarefa implements Serializable, BaseRepository {
	
	public static enum Prioridade {
        ALTA, MEDIA, BAIXA;
    }
	public static enum Situacao {
        EM_ANDAMENTO, CONCLUIDA;
    }

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	private String titulo;
	
	private String descricao;
	
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;
	
	@ManyToOne
	private Responsavel responsavel;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "prioridade")
	private Prioridade prioridade;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Situacao situacao = Situacao.EM_ANDAMENTO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao status) {
		this.situacao = status;
	}
	
	
	
	
	
}
