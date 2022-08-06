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

import br.com.vitt.sipedy.dto.EmpresaDTO;
import br.com.vitt.sipedy.services.EmpresaService;
import br.com.vitt.sipedy.services.exceptions.DatabaseException;
import br.com.vitt.sipedy.services.exceptions.ResourceNotFoundException;
import br.com.vitt.sipedy.tests.Factory;
import br.com.vitt.sipedy.tests.TokenUtil;

@SpringBootTest
@AutoConfigureMockMvc
public class EmpresaControllerTests {
	@Autowired
	private TokenUtil tokenUtil;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmpresaService service;
	@Autowired
	private ObjectMapper objectMapper;

	private PageImpl<EmpresaDTO> page;

	private EmpresaDTO empresaDTO;
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

		empresaDTO = Factory.createEmpresaDto();

		page = new PageImpl<>(List.of(empresaDTO));

		when(service.findAllPaged(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(page);

		when(service.findById(existingId)).thenReturn(empresaDTO);

		when(service.findById(nonExistingId)).thenThrow(ResourceNotFoundException.class);

		when(service.update(eq(existingId), any())).thenReturn(empresaDTO);

		when(service.update(eq(nonExistingId), any())).thenThrow(ResourceNotFoundException.class);
		
		doNothing().when(service).delete(existingId);
		doThrow(ResourceNotFoundException.class).when(service).delete(nonExistingId);
		doThrow(DatabaseException.class).when(service).delete(dependentId);
		
		when(service.insert(any())).thenReturn(empresaDTO);
	}
	
	@Test
	public void deleteDeveriaRetornarNoContentQuandoIdExistir() throws Exception {
		
		String accessToken = tokenUtil.obtainAccessToken(mockMvc, userName, password);
		
		ResultActions result = mockMvc.perform(delete("/empresas/{id}", existingId)
				.header("Authorization", "Bearer " + accessToken)
				.accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isNoContent());
		
	}
	
	@Test
	public void deleteDeveriaRetornarNotFoundQuandoIdNaoExistir() throws Exception {
		
		String accessToken = tokenUtil.obtainAccessToken(mockMvc, userName, password);
		
		ResultActions result = mockMvc.perform(delete("/empresas/{id}", nonExistingId)
				.header("Authorization", "Bearer " + accessToken)
				.accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isNotFound());
		
	}
	
	@Test
	public void insertDeveriaRetonarEmpresaDTOCriado() throws Exception {
		
		String accessToken = tokenUtil.obtainAccessToken(mockMvc, userName, password);
		
		String jsonBody = objectMapper.writeValueAsString(empresaDTO);
		
		ResultActions result = mockMvc.perform(post("/empresas")
				.header("Authorization", "Bearer " + accessToken)
				.content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isCreated());
		result.andExpect(jsonPath("$.id").exists());
		result.andExpect(jsonPath("$.nomeRazao").exists());
		
	}
	
	@Test
	public void updateDeveriaRetonarEmpresaDTOQuandoIdExistir() throws Exception {
		
		String accessToken = tokenUtil.obtainAccessToken(mockMvc, userName, password);
		
		String jsonBody = objectMapper.writeValueAsString(empresaDTO);
		
		ResultActions result = mockMvc.perform(put("/empresas/{id}", existingId)
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
		
		String jsonBody = objectMapper.writeValueAsString(empresaDTO);
				
				ResultActions result = mockMvc.perform(put("/empresas/{id}", nonExistingId)
						.header("Authorization", "Bearer " + accessToken)
						.content(jsonBody)
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON));
				
				result.andExpect(status().isNotFound());
		
	}

	@Test
	public void findAllDeveriaRetornarPage() throws Exception {
		String accessToken = tokenUtil.obtainAccessToken(mockMvc, userName, password);

		ResultActions result = mockMvc.perform(get("/empresas")
				.header("Authorization", "Bearer " + accessToken)
				.accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isOk());
	}

	@Test
	public void findByIdDeveriaRetornarEmpresaQuandoIdExistir() throws Exception {
		String accessToken = tokenUtil.obtainAccessToken(mockMvc, userName, password);

		ResultActions result = mockMvc.perform(get("/empresas/{id}", existingId)
				.header("Authorization", "Bearer " + accessToken)
				.accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.id").exists());
		result.andExpect(jsonPath("$.nomeRazao").exists());
	}

	@Test
	public void findByIdDeveriaRetornarNotFoundQuandoIdNaoExistir() throws Exception {
		String accessToken = tokenUtil.obtainAccessToken(mockMvc, userName, password);

		ResultActions result = mockMvc.perform(get("/empresas/{id}", nonExistingId)
				.header("Authorization", "Bearer " + accessToken)
				.accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isNotFound());
	}
}
