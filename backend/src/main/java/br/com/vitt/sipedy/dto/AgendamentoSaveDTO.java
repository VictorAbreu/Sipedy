package br.com.vitt.sipedy.dto;

import java.io.Serializable;
import java.util.Date;

import br.com.vitt.sipedy.entities.Agendamento;
import br.com.vitt.sipedy.entities.User;

public class AgendamentoSaveDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String titulo;
	private String descricao;
	private Date data;
	private Date inicio;
	private Date fim;
	private Boolean lembrete;
	private Long user;
	
	public AgendamentoSaveDTO() {
	}
	
	public AgendamentoSaveDTO(Long id, String titulo, String descricao, Date data, Date inicio, Date fim,
			Boolean lembrete, User user) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
		this.inicio = inicio;
		this.fim = fim;
		this.lembrete = lembrete;
		this.user = user.getId();
	}
	
	public AgendamentoSaveDTO(Agendamento entity) {
		this.id = entity.getId();
		this.titulo = entity.getTitulo();
		this.descricao = entity.getDescricao();
		this.data = entity.getData();
		this.inicio = entity.getInicio();
		this.fim = entity.getFim();
		this.lembrete = entity.getLembrete();
		this.user = entity.getUser().getId();
	}

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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public Boolean getLembrete() {
		return lembrete;
	}

	public void setLembrete(Boolean lembrete) {
		this.lembrete = lembrete;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

}
