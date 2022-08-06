package br.com.vitt.sipedy.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import br.com.vitt.sipedy.entities.Empresa;
import br.com.vitt.sipedy.tests.Factory;

@DataJpaTest
public class EmpresaRepositoryTests {
	@Autowired
	private EmpresaRepository repository;
	
	private long existingId;
	private long nonExistingId;
	private long countTotalEmpresas;
	
	@BeforeEach
	void setUp() throws Exception{
		
		existingId = 1L;
		nonExistingId = 1000L;
		countTotalEmpresas = 2L;
		
	}
	
	@Test
	public void salvarDevePersistirComIncrementoAutomaticoQuandoOIdENulo() {
		
		Empresa empresa = Factory.createEmpresa();
		empresa.setId(null);
		empresa = repository.save(empresa);
		
		Assertions.assertNotNull(empresa.getId());
		Assertions.assertEquals(countTotalEmpresas + 1, empresa.getId());
	}
	
	@Test
	public void deleteDeveExcluirOObjetoQuandoOIdExistir() {
		
		repository.deleteById(existingId);
		
		Optional<Empresa> result = repository.findById(existingId);
		
		Assertions.assertFalse(result.isPresent());
	}
	
	@Test
	public void deleteDeveLancarResultDataAccessExceptionVazioQuandoOIdNaoExiste() {

		Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
			repository.deleteById(nonExistingId);
		});
	}
	
	@Test
	public void findByIdDeveRetornarOptionalEmpresaQuandoOIdExiste() {
		
		Optional<Empresa> result = repository.findById(existingId);
		
		Assertions.assertTrue(result.isPresent());
		
	}
	
	@Test
	public void findByIdDeveRetornarOptionalEmpresaNullQuandoIdNaoExiste() {
		
		Optional<Empresa> result = repository.findById(nonExistingId);
		
		Assertions.assertTrue(result.isEmpty());
		
	}
}
