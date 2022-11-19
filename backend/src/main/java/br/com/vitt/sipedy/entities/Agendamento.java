package br.com.vitt.sipedy.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_agendamento")
public class Agendamento implements Serializable{
	
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String descricao;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Date data;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Date inicio;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Date fim;
	private Boolean lembrete;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public Agendamento() {}
	
	public Agendamento(Long id, String titulo, String descricao, Date data, Date inicio, Date fim,
			Boolean lembrete, User user) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
		this.inicio = inicio;
		this.fim = fim;
		this.lembrete = lembrete;
		this.user = user;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agendamento other = (Agendamento) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
