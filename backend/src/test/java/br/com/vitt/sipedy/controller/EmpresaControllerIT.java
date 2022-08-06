package br.com.vitt.sipedy.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.vitt.sipedy.dto.EmpresaDTO;
import br.com.vitt.sipedy.tests.Factory;
import br.com.vitt.sipedy.tests.TokenUtil;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class EmpresaControllerIT {
	@Autowired
	private TokenUtil tokenUtil;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private long existingId;
	private long nonExistingId;
	private long countTotalProduct;
	private String userName;
	private String password;
	
	@BeforeEach
	void setUp() throws Exception {
		
		existingId = 1L;
		nonExistingId = 1000L;
		countTotalProduct = 2L;
		
		userName = "maria@gmail.com";
		password = "123456";
		
	}
	
	@Test
	public void findAllDeveriaRetornarPageOrdenadoQuandoOrdenadoPorNomeRazao() throws Exception{
		String accessToken = tokenUtil.obtainAccessToken(mockMvc, userName, password);
		
		ResultActions result = mockMvc.perform(get("/empresas?page=0&size=12&sort=nomeRazao,asc")
				.header("Authorization", "Bearer " + accessToken)
				.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.totalElements").value(countTotalProduct));
		result.andExpect(jsonPath("$.content").exists());
		result.andExpect(jsonPath("$.content[0].nomeRazao").value("Vende Melhor Ltda"));
		result.andExpect(jsonPath("$.content[1].nomeRazao").value("Vende Tudo Ltda"));
		
	}
	
	@Test
	public void updateDeveriaRetornarEmpresaDTOQuandoIdExistir() throws Exception {
		
		String accessToken = tokenUtil.obtainAccessToken(mockMvc, userName, password);
		
		EmpresaDTO productDTO = Factory.createEmpresaDto();
		
		String jsonBody = objectMapper.writeValueAsString(productDTO);
		
		String expectedName = productDTO.getNomeRazao();
		
		ResultActions result = mockMvc.perform(put("/empresas/{id}", existingId)
				.header("Authorization", "Bearer " + accessToken)
				.content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isOk());
		
		result.andExpect(jsonPath("$.id").value(existingId));
		result.andExpect(jsonPath("$.nomeRazao").value(expectedName));
		
	}
	
	@Test
	public void updateDeveriaRetornarNotFoundQuandoIdNaoExistir() throws Exception {
		
		String accessToken = tokenUtil.obtainAccessToken(mockMvc, userName, password);
		
		EmpresaDTO productDTO = Factory.createEmpresaDto();
		
		String jsonBody = objectMapper.writeValueAsString(productDTO);
		
		
		ResultActions result = mockMvc.perform(put("/empresas/{id}", nonExistingId)
				.header("Authorization", "Bearer " + accessToken)
				.content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isNotFound());

		
	}
}
