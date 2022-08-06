package br.com.vitt.sipedy.services;

import static org.mockito.ArgumentMatchers.any;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.vitt.sipedy.dto.EmpresaDTO;
import br.com.vitt.sipedy.entities.Empresa;
import br.com.vitt.sipedy.repositories.EmpresaRepository;
import br.com.vitt.sipedy.services.exceptions.DatabaseException;
import br.com.vitt.sipedy.services.exceptions.ResourceNotFoundException;
import br.com.vitt.sipedy.tests.Factory;

@ExtendWith(SpringExtension.class)
public class EmpresaServiceTests {
	@InjectMocks
	private EmpresaService service;

	@Mock
	private EmpresaRepository repository;

	private long existingId;
	private long nonExistingId;
	private long dependentId;
	private PageImpl<Empresa> page;
	private Empresa empresa;
	private EmpresaDTO empresaDTO;

	@BeforeEach
	void setUp() throws Exception {
		existingId = 1L;
		nonExistingId = 1000L;
		dependentId = 4L;
		empresa = Factory.createEmpresa();
		empresaDTO = Factory.createEmpresaDto();
		page = new PageImpl<>(List.of(empresa));

		Mockito.when(repository.findAll((Pageable) any())).thenReturn(page);

		Mockito.when(repository.save(any())).thenReturn(empresa);

		Mockito.when(repository.getOne(existingId)).thenReturn(empresa);
		Mockito.when(repository.getOne(nonExistingId)).thenThrow(EntityNotFoundException.class);

		Mockito.when(repository.findById(existingId)).thenReturn(Optional.of(empresa));
		Mockito.when(repository.findById(nonExistingId)).thenReturn(Optional.empty());
		
		Mockito.when(repository.find(any(), any())).thenReturn(page);
		
		Mockito.doNothing().when(repository).deleteById(existingId);
		Mockito.doThrow(EmptyResultDataAccessException.class).when(repository).deleteById(nonExistingId);
		Mockito.doThrow(DataIntegrityViolationException.class).when(repository).deleteById(dependentId);
	}
	
	@Test
	public void updateDeveriaLancarResourceNotFoundExceptionQuandoIdNaoExistir() {

		Assertions.assertThrows(ResourceNotFoundException.class, () -> {

			service.update(nonExistingId, empresaDTO);

		});
	}

	@Test
	public void updateDeveriaRetornarEmpresaDTOQuandoIdExistir() {

		EmpresaDTO dto = service.update(existingId, empresaDTO);

		Assertions.assertNotNull(dto);

	}

	@Test
	public void findByIdDeveriaRetornarEmpresaDTOQuandoIdExistir() {

		EmpresaDTO dto = service.findById(existingId);

		Assertions.assertNotNull(dto);

		Mockito.verify(repository, Mockito.times(1)).findById(existingId);

	}

	@Test
	public void findByIdDeveriaLancarResourceNotFoundExceptionQuandoIdNaoExistir() {

		Assertions.assertThrows(ResourceNotFoundException.class, () -> {

			service.findById(nonExistingId);

			Mockito.verify(repository, Mockito.times(1)).findById(nonExistingId);

		});
	}

	@Test
	public void findAllPagesDeveriaRetornarPage() {

		Pageable pageable = PageRequest.of(0, 10);

		Page<EmpresaDTO> result = service.findAllPaged("", pageable);

		Assertions.assertNotNull(result);

	}

	@Test
	public void deleteDeveriaLancarDatabaseExceptionQuandoIdNaoExistir() {

		Assertions.assertThrows(DatabaseException.class, () -> {
			service.delete(dependentId);
		});

		Mockito.verify(repository, Mockito.times(1)).deleteById(dependentId);
	}

	@Test
	public void deleteDeveriaLancarResourceNotFoundExceptionQuandoIdNaoExistir() {

		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.delete(nonExistingId);
		});

		Mockito.verify(repository, Mockito.times(1)).deleteById(nonExistingId);
	}

	@Test
	public void deleteNaoDeveriaFazerNadaQuandoIdExistir() {

		Assertions.assertDoesNotThrow(() -> {
			service.delete(existingId);
		});

		Mockito.verify(repository, Mockito.times(1)).deleteById(existingId);
	}
}
