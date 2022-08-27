package br.com.vitt.sipedy.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import br.com.vitt.sipedy.entities.Fornecedor;
import br.com.vitt.sipedy.tests.Factory;

@DataJpaTest
public class FornecedorRepositoryTests {
	@Autowired
	private FornecedorRepository repository;
	
	private long existingId;
	private long nonExistingId;
	private long countTotalFornecedors;
	
	@BeforeEach
	void setUp() throws Exception{
		
		existingId = 1L;
		nonExistingId = 1000L;
		countTotalFornecedors = 21L;
		
	}
	
	@Test
	public void salvarDevePersistirComIncrementoAutomaticoQuandoOIdENulo() {
		
		Fornecedor fornecedor = Factory.createFornecedor();
		fornecedor.setId(null);
		fornecedor = repository.save(fornecedor);
		
		Assertions.assertNotNull(fornecedor.getId());
		Assertions.assertEquals(countTotalFornecedors + 1, fornecedor.getId());
	}
	
	@Test
	public void deleteDeveExcluirOObjetoQuandoOIdExistir() {
		
		repository.deleteById(existingId);
		
		Optional<Fornecedor> result = repository.findById(existingId);
		
		Assertions.assertFalse(result.isPresent());
	}
	
	@Test
	public void deleteDeveLancarResultDataAccessExceptionVazioQuandoOIdNaoExiste() {

		Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
			repository.deleteById(nonExistingId);
		});
	}
	
	@Test
	public void findByIdDeveRetornarOptionalFornecedorQuandoOIdExiste() {
		
		Optional<Fornecedor> result = repository.findById(existingId);
		
		Assertions.assertTrue(result.isPresent());
		
	}
	
	@Test
	public void findByIdDeveRetornarOptionalFornecedorNullQuandoIdNaoExiste() {
		
		Optional<Fornecedor> result = repository.findById(nonExistingId);
		
		Assertions.assertTrue(result.isEmpty());
		
	}
}
