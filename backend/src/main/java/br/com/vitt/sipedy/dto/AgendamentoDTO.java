package br.com.vitt.sipedy.dto;

import java.io.Serializable;
import java.util.Date;

import br.com.vitt.sipedy.entities.Agendamento;
import br.com.vitt.sipedy.entities.User;

public class AgendamentoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String titulo;
	private String descricao;
	private Date data;
	private Date horaInicio;
	private Date horaFim;
	private Boolean lembrete;
	private User user;

	public AgendamentoDTO() {
	}

	public AgendamentoDTO(Long id, String titulo, String descricao, Date data, Date horaInicio, Date horaFim,
			Boolean lembrete, User user) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.lembrete = lembrete;
		this.user = user;
	}
	
	public AgendamentoDTO(Agendamento entity) {
		this.id = entity.getId();
		this.titulo = entity.getTitulo();
		this.descricao = entity.getDescricao();
		this.data = entity.getData();
		this.horaInicio = entity.getHoraInicio();
		this.horaFim = entity.getHoraFim();
		this.lembrete = entity.getLembrete();
		this.user = entity.getUser();
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

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(Date horaFim) {
		this.horaFim = horaFim;
	}

	public Boolean getLembrete() {
		return lembrete;
	}

	public void setLembrete(Boolean lembrete) {
		this.lembrete = lembrete;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
