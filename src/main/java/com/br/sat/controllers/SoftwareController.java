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

import com.br.sat.entity.Software;
import com.br.sat.service.SoftwareService;

@RestController
@RequestMapping(path = "/sat/api/software")
public class SoftwareController {

	@Autowired
	private SoftwareService softwareService;

	@GetMapping()
	public ResponseEntity<List<Software>> findAllSoftware() {
		List<Software> listObj = softwareService.findAll();
		return ResponseEntity.ok().body(listObj);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Software> findByIdSoftware(@PathVariable Integer id) {
		Software ResultObj = softwareService.findById(id);
		return ResponseEntity.ok().body(ResultObj);
	}

	@PostMapping()
	public ResponseEntity<Void> inserSoftware(@Valid @RequestBody Software obj) {

		Software ResultObj = softwareService.insert(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ResultObj.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateSoftware(@Valid @RequestBody Software obj, @PathVariable Integer id) {
		obj.setId(id);
		softwareService.update(obj);
		return ResponseEntity.noContent().build();

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteSoftware(@PathVariable Integer id) {
		softwareService.delete(id);
		return ResponseEntity.noContent().build();
	}	

}
