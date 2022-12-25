package com.br.sat.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.sat.dto.SoftwareDTO;
import com.br.sat.service.SoftwareService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path = "/sat/api/software")
public class SoftwareController {

	@Autowired
	private SoftwareService softwareService;

	@GetMapping()
	@Operation(summary = "Get List Softwares")
	public ResponseEntity<List<SoftwareDTO>> findAllSoftware() {
		List<SoftwareDTO> listSoftwareDTO = softwareService.findAll();
		return ResponseEntity.ok().body(listSoftwareDTO);
	}

	@GetMapping(value = "/{id}")
	@Operation(summary = "Get software through id")
	public ResponseEntity<SoftwareDTO> findByIdSoftware(@PathVariable Integer id) {
		SoftwareDTO softwareDTO = softwareService.findById(id);
		return ResponseEntity.ok().body(softwareDTO);
	}

	@PostMapping()
	@Operation(summary = "Post software")
	public ResponseEntity<Void> inserSoftware(@Valid @RequestBody SoftwareDTO newSoftwarejDTO) {
		SoftwareDTO softwareDTO = softwareService.insert(newSoftwarejDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(softwareDTO.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	@Operation(summary = "Put software through id")
	public ResponseEntity<?> updateSoftware(@Valid @RequestBody SoftwareDTO softwareDTO, @PathVariable Integer id) {
		softwareDTO.setId(id);
		softwareService.update(softwareDTO, id);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Delete software through id")
	public ResponseEntity<Void> deleteSoftware(@PathVariable Integer id) {
		softwareService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
