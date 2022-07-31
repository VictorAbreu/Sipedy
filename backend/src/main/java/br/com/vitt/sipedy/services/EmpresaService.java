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

import br.com.vitt.sipedy.dto.EmpresaDTO;
import br.com.vitt.sipedy.entities.Empresa;
import br.com.vitt.sipedy.repositories.EmpresaRepository;
import br.com.vitt.sipedy.services.exceptions.DatabaseException;
import br.com.vitt.sipedy.services.exceptions.ResourceNotFoundException;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Transactional(readOnly = true)
	public Page<EmpresaDTO> findAllPaged(String name, Pageable pageable) {

		Page<Empresa> page = empresaRepository.find(name, pageable);

		return page.map(x -> new EmpresaDTO(x));
	}

	@Transactional(readOnly = true)
	public EmpresaDTO findById(Long id) {

		Optional<Empresa> obj = empresaRepository.findById(id);
		Empresa entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

		return new EmpresaDTO(entity);
	}
	
	@Transactional
	public EmpresaDTO insert(EmpresaDTO dto) {

		Empresa entity = new Empresa();
		copyDtoToEntity(dto, entity);
		entity = empresaRepository.save(entity);
		return new EmpresaDTO(entity);

	}

	@Transactional
	public EmpresaDTO update(Long id, EmpresaDTO dto) {

		try {
			Empresa entity = empresaRepository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = empresaRepository.save(entity);
			return new EmpresaDTO(entity);
		} catch (EntityNotFoundException e) {

			throw new ResourceNotFoundException("Id nout found " + id);

		}

	}

	public void delete(Long id) {
		try {
			empresaRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}

	}

	private void copyDtoToEntity(EmpresaDTO dto, Empresa entity) {

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
