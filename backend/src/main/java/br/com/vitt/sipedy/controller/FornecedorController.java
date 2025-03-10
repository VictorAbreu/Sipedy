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

import br.com.vitt.sipedy.dto.FornecedorDTO;
import br.com.vitt.sipedy.services.FornecedorService;

@RestController
@RequestMapping(value = "/fornecedores")
public class FornecedorController {

	@Autowired
	private FornecedorService service;

	@GetMapping
	public ResponseEntity<Page<FornecedorDTO>> findAll(Pageable pageable, 
			@RequestParam(value = "name", defaultValue = "") String name) {

		Page<FornecedorDTO> list = service.findAllPaged(name.trim(), pageable);

		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<FornecedorDTO> findById(@PathVariable Long id) {

		FornecedorDTO dto = service.findById(id);

		return ResponseEntity.ok().body(dto);

	}

	@PostMapping
	public ResponseEntity<FornecedorDTO> insert(@Valid @RequestBody FornecedorDTO dto) {

		dto = service.insert(dto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

		return ResponseEntity.created(uri).body(dto);

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<FornecedorDTO> update(@Valid @PathVariable Long id, @RequestBody FornecedorDTO dto) {

		dto = service.update(id, dto);

		return ResponseEntity.ok().body(dto);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<FornecedorDTO> delete(@PathVariable Long id) {

		service.delete(id);

		return ResponseEntity.noContent().build();

	}
}
