package br.com.vitt.sipedy.dto;

import static br.com.vitt.sipedy.services.Formatters.DateFormatter.converteDateParaString;
import static br.com.vitt.sipedy.services.Formatters.DateFormatter.converteDateParaStringHorario;

import java.io.Serializable;
import java.util.Date;

import br.com.vitt.sipedy.entities.Agendamento;
import br.com.vitt.sipedy.entities.User;

public class AgendamentoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String titulo;
	private String descricao;
	private String data;
	private String inicio;
	private String fim;
	private Boolean lembrete;
	private Long user;

	public AgendamentoDTO() {
	}

	public AgendamentoDTO(Long id, String titulo, String descricao, Date data, Date inicio, Date fim,
			Boolean lembrete, User user) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = converteDateParaString(data);
		this.inicio = converteDateParaStringHorario(inicio);
		this.fim = converteDateParaStringHorario(fim);
		this.lembrete = lembrete;
		this.user = user.getId();
	}
	
	public AgendamentoDTO(Agendamento entity) {
		this.id = entity.getId();
		this.titulo = entity.getTitulo();
		this.descricao = entity.getDescricao();
		this.data = converteDateParaString(entity.getData());
		this.inicio = converteDateParaStringHorario(entity.getInicio());
		this.fim = converteDateParaStringHorario(entity.getFim());
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFim() {
		return fim;
	}

	public void setFim(String fim) {
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
