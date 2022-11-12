package br.com.vitt.sipedy.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vitt.sipedy.dto.AgendamentoDTO;
import br.com.vitt.sipedy.entities.Agendamento;
import br.com.vitt.sipedy.repositories.AgendamentoRepository;
import br.com.vitt.sipedy.services.exceptions.DatabaseException;
import br.com.vitt.sipedy.services.exceptions.ResourceNotFoundException;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository repository;

	@Transactional(readOnly = true)
	public List<AgendamentoDTO> findAllPaged() {

		List<Agendamento> page = repository.findAll();

		return page.stream().map(x -> new AgendamentoDTO(x)).toList();
	}

	@Transactional(readOnly = true)
	public AgendamentoDTO findById(Long id) {
		Optional<Agendamento> obj = repository.findById(id);
		Agendamento entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

		return new AgendamentoDTO(entity);
	}

	@Transactional
	public AgendamentoDTO insert(AgendamentoDTO dto) {

		Agendamento entity = new Agendamento();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new AgendamentoDTO(entity);

	}

	@Transactional
	public AgendamentoDTO update(Long id, AgendamentoDTO dto) {

		try {
			Agendamento entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new AgendamentoDTO(entity);
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

	private void copyDtoToEntity(AgendamentoDTO dto, Agendamento entity) {

		entity.setTitulo(dto.getTitulo());
		entity.setDescricao(dto.getDescricao());
		entity.setData(dto.getData());
		entity.setHoraInicio(dto.getHoraInicio());
		entity.setHoraFim(dto.getHoraInicio());
		entity.setLembrete(dto.getLembrete());
		entity.setUser(dto.getUser());
	}

}
