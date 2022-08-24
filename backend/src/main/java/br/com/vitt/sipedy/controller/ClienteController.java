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

import br.com.vitt.sipedy.dto.ClienteDTO;
import br.com.vitt.sipedy.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@GetMapping
	public ResponseEntity<Page<ClienteDTO>> findAll(Pageable pageable, 
			@RequestParam(value = "name", defaultValue = "") String name) {

		Page<ClienteDTO> list = service.findAllPaged(name.trim(), pageable);

		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> findById(@PathVariable Long id) {

		ClienteDTO dto = service.findById(id);

		return ResponseEntity.ok().body(dto);

	}

	@PostMapping
	public ResponseEntity<ClienteDTO> insert(@Valid @RequestBody ClienteDTO dto) {

		dto = service.insert(dto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

		return ResponseEntity.created(uri).body(dto);

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> update(@Valid @PathVariable Long id, @RequestBody ClienteDTO dto) {

		dto = service.update(id, dto);

		return ResponseEntity.ok().body(dto);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> delete(@PathVariable Long id) {

		service.delete(id);

		return ResponseEntity.noContent().build();

	}
}
