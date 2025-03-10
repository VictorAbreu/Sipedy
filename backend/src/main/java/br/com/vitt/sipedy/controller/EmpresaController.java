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

import br.com.vitt.sipedy.dto.EmpresaDTO;
import br.com.vitt.sipedy.services.EmpresaService;

@RestController
@RequestMapping(value = "/empresas")
public class EmpresaController {

	@Autowired
	private EmpresaService service;

	@GetMapping
	public ResponseEntity<Page<EmpresaDTO>> findAll(Pageable pageable, 
			@RequestParam(value = "name", defaultValue = "") String name) {

		Page<EmpresaDTO> list = service.findAllPaged(name.trim(), pageable);

		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<EmpresaDTO> findById(@PathVariable Long id) {

		EmpresaDTO dto = service.findById(id);

		return ResponseEntity.ok().body(dto);

	}

	@PostMapping
	public ResponseEntity<EmpresaDTO> insert(@Valid @RequestBody EmpresaDTO dto) {

		dto = service.insert(dto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

		return ResponseEntity.created(uri).body(dto);

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<EmpresaDTO> update(@Valid @PathVariable Long id, @RequestBody EmpresaDTO dto) {

		dto = service.update(id, dto);

		return ResponseEntity.ok().body(dto);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<EmpresaDTO> delete(@PathVariable Long id) {

		service.delete(id);

		return ResponseEntity.noContent().build();

	}
}
