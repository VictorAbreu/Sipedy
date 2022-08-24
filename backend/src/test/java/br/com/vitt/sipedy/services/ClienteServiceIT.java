package br.com.vitt.sipedy.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import br.com.vitt.sipedy.dto.ClienteDTO;
import br.com.vitt.sipedy.repositories.ClienteRepository;
import br.com.vitt.sipedy.services.exceptions.ResourceNotFoundException;

@SpringBootTest
@Transactional
public class ClienteServiceIT {
	@Autowired
	private ClienteService service;
	
	@Autowired
	private ClienteRepository repository;
	
	private long existingId;
	private long nonExistingId;
	private long countTotalProduct;
	
	@BeforeEach
	void setUp() throws Exception {
		
		existingId = 1L;
		nonExistingId = 1000L;
		countTotalProduct = 21L;
		
	}
	
	@Test
	public void findAllPagedDeveriaRetornarPageQuandoPag0Size10() {
		
		PageRequest pageRequest = PageRequest.of(0, 10);
		
		Page<ClienteDTO> result = service.findAllPaged("", pageRequest);
		
		Assertions.assertFalse(result.isEmpty());
		Assertions.assertEquals(0, result.getNumber());
		Assertions.assertEquals(10, result.getSize());
		Assertions.assertEquals(countTotalProduct, result.getTotalElements());
	}
	
	@Test
	public void findAllPagedDeveriaRetornarPageVazioQuandoPageNaoExistir() {
		
		PageRequest pageRequest = PageRequest.of(50, 10);
		
		Page<ClienteDTO> result = service.findAllPaged("", pageRequest);
		
		Assertions.assertTrue(result.isEmpty());

	}
	
	@Test
	public void findAllPagedDeveriaRetornarPageOrdenadoQuandoOrdenadoPorNomeRazao() {
		
		PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("nomeRazao"));
		
		Page<ClienteDTO> result = service.findAllPaged("", pageRequest);
		
		Assertions.assertFalse(result.isEmpty());
		Assertions.assertEquals("Auto Silva", result.getContent().get(0).getNomeRazao());
		Assertions.assertEquals("Auto peças carro top", result.getContent().get(1).getNomeRazao());

	}
	
	@Test
	public void deleteDeveriaDeletarQuandoIdExistir() {
		
		service.delete(existingId);
		
		Assertions.assertEquals(countTotalProduct - 1, repository.count());
		
	}
	
	@Test
	public void deleteDeveriaLancarResourceNotFoundExceptionQuandoIdNaoExistir() {
		
		
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			
			service.delete(nonExistingId);
			
		});
		
	}
}
