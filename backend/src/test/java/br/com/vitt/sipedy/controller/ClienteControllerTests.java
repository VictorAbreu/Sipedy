package br.com.vitt.sipedy.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.vitt.sipedy.dto.ClienteDTO;
import br.com.vitt.sipedy.services.ClienteService;
import br.com.vitt.sipedy.services.exceptions.DatabaseException;
import br.com.vitt.sipedy.services.exceptions.ResourceNotFoundException;
import br.com.vitt.sipedy.tests.Factory;
import br.com.vitt.sipedy.tests.TokenUtil;

@SpringBootTest
@AutoConfigureMockMvc
public class ClienteControllerTests {
	@Autowired
	private TokenUtil tokenUtil;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ClienteService service;
	@Autowired
	private ObjectMapper objectMapper;

	private PageImpl<ClienteDTO> page;

	private ClienteDTO clienteDTO;
	private long existingId;
	private long nonExistingId;
	private long dependentId;
	
	private String userName;
	private String password;

	@BeforeEach
	void setUp() throws Exception {

		existingId = 1L;
		nonExistingId = 1000L;
		dependentId = 3L;
		
		userName = "maria@gmail.com";
		password = "123456";

		clienteDTO = Factory.createClienteDto();

		page = new PageImpl<>(List.of(clienteDTO));

		when(service.findAllPaged(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(page);

		when(service.findById(existingId)).thenReturn(clienteDTO);

		when(service.findById(nonExistingId)).thenThrow(ResourceNotFoundException.class);

		when(service.update(eq(existingId), any())).thenReturn(clienteDTO);

		when(service.update(eq(nonExistingId), any())).thenThrow(ResourceNotFoundException.class);
		
		doNothing().when(service).delete(existingId);
		doThrow(ResourceNotFoundException.class).when(service).delete(nonExistingId);
		doThrow(DatabaseException.class).when(service).delete(dependentId);
		
		when(service.insert(any())).thenReturn(clienteDTO);
	}
	
	@Test
	public void deleteDeveriaRetornarNoContentQuandoIdExistir() throws Exception {
		
		String accessToken = tokenUtil.obtainAccessToken(mockMvc, userName, password);
		
		ResultActions result = mockMvc.perform(delete("/clientes/{id}", existingId)
				.header("Authorization", "Bearer " + accessToken)
				.accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isNoContent());
		
	}
	
	@Test
	public void deleteDeveriaRetornarNotFoundQuandoIdNaoExistir() throws Exception {
		
		String accessToken = tokenUtil.obtainAccessToken(mockMvc, userName, password);
		
		ResultActions result = mockMvc.perform(delete("/clientes/{id}", nonExistingId)
				.header("Authorization", "Bearer " + accessToken)
				.accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isNotFound());
		
	}
	
	@Test
	public void insertDeveriaRetonarClienteDTOCriado() throws Exception {
		
		String accessToken = tokenUtil.obtainAccessToken(mockMvc, userName, password);
		
		String jsonBody = objectMapper.writeValueAsString(clienteDTO);
		
		ResultActions result = mockMvc.perform(post("/clientes")
				.header("Authorization", "Bearer " + accessToken)
				.content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isCreated());
		result.andExpect(jsonPath("$.id").exists());
		result.andExpect(jsonPath("$.nomeRazao").exists());
		
	}
	
	@Test
	public void updateDeveriaRetonarClienteDTOQuandoIdExistir() throws Exception {
		
		String accessToken = tokenUtil.obtainAccessToken(mockMvc, userName, password);
		
		String jsonBody = objectMapper.writeValueAsString(clienteDTO);
		
		ResultActions result = mockMvc.perform(put("/clientes/{id}", existingId)
				.header("Authorization", "Bearer " + accessToken)
				.content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isOk());
		
		result.andExpect(jsonPath("$.id").exists());
		result.andExpect(jsonPath("$.nomeRazao").exists());
		
	}
	
	@Test
	public void updateDeveriaRetornarNotFoundQuandoIdNaoExistir() throws Exception {
		
		String accessToken = tokenUtil.obtainAccessToken(mockMvc, userName, password);
		
		String jsonBody = objectMapper.writeValueAsString(clienteDTO);
				
				ResultActions result = mockMvc.perform(put("/clientes/{id}", nonExistingId)
						.header("Authorization", "Bearer " + accessToken)
						.content(jsonBody)
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON));
				
				result.andExpect(status().isNotFound());
		
	}

	@Test
	public void findAllDeveriaRetornarPage() throws Exception {
		String accessToken = tokenUtil.obtainAccessToken(mockMvc, userName, password);

		ResultActions result = mockMvc.perform(get("/clientes")
				.header("Authorization", "Bearer " + accessToken)
				.accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isOk());
	}

	@Test
	public void findByIdDeveriaRetornarClienteQuandoIdExistir() throws Exception {
		String accessToken = tokenUtil.obtainAccessToken(mockMvc, userName, password);

		ResultActions result = mockMvc.perform(get("/clientes/{id}", existingId)
				.header("Authorization", "Bearer " + accessToken)
				.accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.id").exists());
		result.andExpect(jsonPath("$.nomeRazao").exists());
	}

	@Test
	public void findByIdDeveriaRetornarNotFoundQuandoIdNaoExistir() throws Exception {
		String accessToken = tokenUtil.obtainAccessToken(mockMvc, userName, password);

		ResultActions result = mockMvc.perform(get("/clientes/{id}", nonExistingId)
				.header("Authorization", "Bearer " + accessToken)
				.accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isNotFound());
	}
}
