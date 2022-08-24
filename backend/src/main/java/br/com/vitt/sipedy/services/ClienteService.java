package br.com.vitt.sipedy.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vitt.sipedy.dto.ClienteDTO;
import br.com.vitt.sipedy.entities.Cliente;
import br.com.vitt.sipedy.repositories.ClienteRepository;
import br.com.vitt.sipedy.services.exceptions.DatabaseException;
import br.com.vitt.sipedy.services.exceptions.ResourceNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Transactional(readOnly = true)
	public Page<ClienteDTO> findAllPaged(String name, Pageable pageable) {

		Page<Cliente> page = repository.find(name, pageable);

		return page.map(x -> new ClienteDTO(x));
	}

	@Transactional(readOnly = true)
	public ClienteDTO findById(Long id) {

		Optional<Cliente> obj = repository.findById(id);
		Cliente entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

		return new ClienteDTO(entity);
	}
	
	@Transactional
	public ClienteDTO insert(ClienteDTO dto) {

		Cliente entity = new Cliente();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ClienteDTO(entity);

	}

	@Transactional
	public ClienteDTO update(Long id, ClienteDTO dto) {

		try {
			Cliente entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new ClienteDTO(entity);
		} catch (EntityNotFoundException e) {

			throw new ResourceNotFoundException("Id nout found " + id);

		}

	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}

	}

	private void copyDtoToEntity(ClienteDTO dto, Cliente entity) {

		entity.setNomeRazao(dto.getNomeRazao());
		entity.setContato(dto.getContato());
		entity.setCpfCnpj(dto.getCpfCnpj());
		entity.setRgIe(dto.getRgIe());
		entity.setCep(dto.getCep());
		entity.setEndereco(dto.getEndereco());
		entity.setCidade(dto.getCidade());
		entity.setEstado(dto.getEstado());
		entity.setTelefone(dto.getTelefone());
		entity.setCelular(dto.getCelular());
		entity.setEmail(dto.getEmail());

	}

}
