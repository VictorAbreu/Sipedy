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

import br.com.vitt.sipedy.dto.FornecedorDTO;
import br.com.vitt.sipedy.entities.Fornecedor;
import br.com.vitt.sipedy.repositories.FornecedorRepository;
import br.com.vitt.sipedy.services.exceptions.DatabaseException;
import br.com.vitt.sipedy.services.exceptions.ResourceNotFoundException;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository repository;

	@Transactional(readOnly = true)
	public Page<FornecedorDTO> findAllPaged(String name, Pageable pageable) {

		Page<Fornecedor> page = repository.find(name, pageable);

		return page.map(x -> new FornecedorDTO(x));
	}

	@Transactional(readOnly = true)
	public FornecedorDTO findById(Long id) {

		Optional<Fornecedor> obj = repository.findById(id);
		Fornecedor entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

		return new FornecedorDTO(entity);
	}
	
	@Transactional
	public FornecedorDTO insert(FornecedorDTO dto) {

		Fornecedor entity = new Fornecedor();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new FornecedorDTO(entity);

	}

	@Transactional
	public FornecedorDTO update(Long id, FornecedorDTO dto) {

		try {
			Fornecedor entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new FornecedorDTO(entity);
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

	private void copyDtoToEntity(FornecedorDTO dto, Fornecedor entity) {

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
