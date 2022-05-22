package br.com.vitt.sipedy.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.vitt.sipedy.entities.User;

public class UserDTO implements Serializable{
	

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank(message = "Campo obrigatório")
	private String firstName;
	private String lastName;
	
	@Email(message = "Favor entrar com um email válido!")
	private String email;
	
	private String cpf;
	private String celular;
	
	Set<RoleDTO> roles = new HashSet<>();
	
	public UserDTO() {}

	public UserDTO(Long id, String firstName, String lastName, String email, String password, String celular, String cpf) {

		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.celular = celular;
		this.cpf = cpf;
	}
	
	public UserDTO(User entity) {
		
		id = entity.getId();
		firstName = entity.getFirstName();
		lastName = entity.getLastName();
		email = entity.getEmail();
		cpf = entity.getCpf();
		celular = entity.getCelular();
		entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Set<RoleDTO> getRoles() {
		return roles;
	}
	
}
