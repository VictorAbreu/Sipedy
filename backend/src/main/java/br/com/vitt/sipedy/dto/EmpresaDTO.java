package br.com.vitt.sipedy.dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.vitt.sipedy.entities.Empresa;

public class EmpresaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L; 
	
	private Long id;
	private String nomeRazao;
	private String contato;
	private String cpfCnpj;
	private String rgIe;
	private String cep;
	private String endereco;
	private String cidade;
	private String estado;
	private String telefone;
	private String celular;
	private String email;
	
	public EmpresaDTO() {}
	
	public EmpresaDTO(Long id, String nomeRazao, String contato, String cpfCnpj, String rgIe, String cep,
			String endereco, String cidade, String estado, String telefone, String celular, String email) {
		super();
		this.id = id;
		this.nomeRazao = nomeRazao;
		this.contato = contato;
		this.cpfCnpj = cpfCnpj;
		this.rgIe = rgIe;
		this.cep = cep;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
	}
	
	public EmpresaDTO(Empresa entity) {
		this.id = entity.getId();
		this.nomeRazao = entity.getNomeRazao();
		this.contato = entity.getContato();
		this.cpfCnpj = entity.getCpfCnpj();
		this.rgIe = entity.getRgIe();
		this.cep = entity.getCep();
		this.endereco = entity.getEndereco();
		this.cidade = entity.getCidade();
		this.estado = entity.getEstado();
		this.telefone = entity.getTelefone();
		this.celular = entity.getCelular();
		this.email = entity.getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeRazao() {
		return nomeRazao;
	}

	public void setNomeRazao(String nomeRazao) {
		this.nomeRazao = nomeRazao;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getRgIe() {
		return rgIe;
	}

	public void setRgIe(String rgIe) {
		this.rgIe = rgIe;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
