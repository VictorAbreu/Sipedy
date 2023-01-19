package br.com.vitt.sipedy.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.vitt.sipedy.dto.AgendamentoDTO;
import br.com.vitt.sipedy.dto.AgendamentoSaveDTO;
import br.com.vitt.sipedy.services.AgendamentoService;

@RestController
@RequestMapping(value = "/agendamentos")
public class AgendamentoController {
	
	@Autowired
	private AgendamentoService service;
	
	@GetMapping
	public ResponseEntity<Page<AgendamentoDTO>> findAll(Pageable pageable, 
			@RequestParam(value = "data", defaultValue = "" ) String data, 
			@RequestParam(value = "userId", defaultValue = "" ) String userId) {

		Page<AgendamentoDTO> list = service.findAllPaged(data, userId, pageable);

		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<AgendamentoDTO> findById(@PathVariable Long id) {

		AgendamentoDTO dto = service.findById(id);

		return ResponseEntity.ok().body(dto);

	}

	@PostMapping
	public ResponseEntity<AgendamentoSaveDTO> insert(@Valid @RequestBody AgendamentoSaveDTO dto) {

		dto = service.insert(dto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

		return ResponseEntity.created(uri).body(dto);

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<AgendamentoSaveDTO> update(@Valid @PathVariable Long id, @RequestBody AgendamentoSaveDTO dto) {

		dto = service.update(id, dto);

		return ResponseEntity.ok().body(dto);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<AgendamentoDTO> delete(@PathVariable Long id) {

		service.delete(id);

		return ResponseEntity.noContent().build();

	}

}
