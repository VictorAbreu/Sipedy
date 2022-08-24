package br.com.vitt.sipedy.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import br.com.vitt.sipedy.entities.Cliente;
import br.com.vitt.sipedy.tests.Factory;

@DataJpaTest
public class ClienteRepositoryTests {
	@Autowired
	private ClienteRepository repository;
	
	private long existingId;
	private long nonExistingId;
	private long countTotalClientes;
	
	@BeforeEach
	void setUp() throws Exception{
		
		existingId = 1L;
		nonExistingId = 1000L;
		countTotalClientes = 21L;
		
	}
	
	@Test
	public void salvarDevePersistirComIncrementoAutomaticoQuandoOIdENulo() {
		
		Cliente cliente = Factory.createCliente();
		cliente.setId(null);
		cliente = repository.save(cliente);
		
		Assertions.assertNotNull(cliente.getId());
		Assertions.assertEquals(countTotalClientes + 1, cliente.getId());
	}
	
	@Test
	public void deleteDeveExcluirOObjetoQuandoOIdExistir() {
		
		repository.deleteById(existingId);
		
		Optional<Cliente> result = repository.findById(existingId);
		
		Assertions.assertFalse(result.isPresent());
	}
	
	@Test
	public void deleteDeveLancarResultDataAccessExceptionVazioQuandoOIdNaoExiste() {

		Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
			repository.deleteById(nonExistingId);
		});
	}
	
	@Test
	public void findByIdDeveRetornarOptionalClienteQuandoOIdExiste() {
		
		Optional<Cliente> result = repository.findById(existingId);
		
		Assertions.assertTrue(result.isPresent());
		
	}
	
	@Test
	public void findByIdDeveRetornarOptionalClienteNullQuandoIdNaoExiste() {
		
		Optional<Cliente> result = repository.findById(nonExistingId);
		
		Assertions.assertTrue(result.isEmpty());
		
	}
}
