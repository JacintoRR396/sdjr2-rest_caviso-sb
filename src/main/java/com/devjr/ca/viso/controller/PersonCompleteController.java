package com.devjr.ca.viso.controller;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devjr.ca.viso.domain.EPersonDocument;
import com.devjr.ca.viso.domain.PersonComplete;
import com.devjr.ca.viso.service.IPersonCompleteService;

/**
 * Representa el Controlador respecto a una Persona.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 20/04/2020
 * @modify 10/05/2020
 */
@RestController
@RequestMapping(path = "/personsComplete", produces = MediaType.APPLICATION_JSON)
@CrossOrigin(origins = "*")
public class PersonCompleteController {

	@Autowired
	private IPersonCompleteService service;

	/*********** GET ***********/
	@GetMapping()
	public ResponseEntity<List<PersonComplete>> getAll() {
		return ResponseEntity.ok().body(this.service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<PersonComplete> get(@PathVariable("id") final Integer id) {
		final PersonComplete entity = this.service.findById(id);
		if (entity != null) {
			return new ResponseEntity<>(entity, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	/*********** POST ***********/
	@PostMapping(consumes = MediaType.APPLICATION_JSON)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<PersonComplete> insert(@RequestBody final PersonComplete value) {
		return ResponseEntity.ok().body(this.service.save(value));
	}

	/*********** PUT ***********/
	@PutMapping(consumes = MediaType.APPLICATION_JSON)
	public ResponseEntity<PersonComplete> updateAll(@Valid @RequestBody final PersonComplete value) {
		return ResponseEntity.ok().body(this.service.save(value));
	}

	/*********** PATCH ***********/
	@PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON)
	public ResponseEntity<PersonComplete> update(@PathVariable("id") final Integer id,
			@RequestBody final PersonComplete value) {
		final PersonComplete entityDAO = this.service.findById(id);
		final PersonComplete.Builder entity = PersonComplete.valueOf(entityDAO).builder();
		if (entity != null) {
			if (value.getDocumentType().equals(EPersonDocument.EMPTY)) {
				entity.withDocumentType(value.getDocumentType());
			}
			if (!StringUtils.isEmpty(value.getDocumentNumber())) {
				entity.withDocumentNumber(value.getDocumentNumber());
			}
			if (!StringUtils.isEmpty(value.getName())) {
				entity.withName(value.getName());
			}
			if (!StringUtils.isEmpty(value.getSurname())) {
				entity.withSurname(value.getSurname());
			}
			if (value.getBirthdate() != null) {
				entity.withBirthdate(value.getBirthdate());
			}
			if (value.getBalance() != null) {
				entity.withBalance(value.getBalance());
			}
			if (!StringUtils.isEmpty(value.getPathImage())) {
				entity.withPathImage(value.getPathImage());
			}
			if (!StringUtils.isEmpty(value.getDescription())) {
				entity.withDescription(value.getDescription());
			}
			if (value.getAddress() != null) {
				entity.withAddress(value.getAddress());
			}
			if (value.getContact() != null) {
				entity.withContact(value.getContact());
			}
			return new ResponseEntity<>(this.service.save(entity.build()), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	/*********** DELETE ***********/
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") final Integer id) {
		this.service.deleteById(id);
	}

}
