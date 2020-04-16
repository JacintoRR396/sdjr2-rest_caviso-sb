package com.devjr.ca.viso.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.devjr.ca.viso.entity.ContactEntity;
import com.devjr.ca.viso.service.IContactService;

@RestController
@RequestMapping(path = "/contacts", produces = MediaType.APPLICATION_JSON)
@CrossOrigin(origins = "*")
public class ContactController {

	@Autowired
	private IContactService service;

	@GetMapping()
	public List<ContactEntity> getAll() {
		return this.service.findAll();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ContactEntity> get(@PathVariable("id") final Integer id) {
		final ContactEntity entity = this.service.findById(id);
		if (entity != null)
			return new ResponseEntity<>(entity, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON)
	@ResponseStatus(HttpStatus.CREATED)
	public ContactEntity insert(@RequestBody final ContactEntity value) {
		return this.service.save(value);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON)
	public ContactEntity updateAll(@RequestBody final ContactEntity value) {
		return this.service.save(value);
	}

	@PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON)
	public ResponseEntity<ContactEntity> update(@PathVariable("id") final Integer id,
			@RequestBody final ContactEntity value) {
		final ContactEntity entity = this.service.findById(id);
		if (entity != null) {
			if (value.getEmail() != null) {
				entity.setEmail(value.getEmail());
			}
			if (value.getTlfMovil() != null) {
				entity.setTlfMovil(value.getTlfMovil());
			}
			if (value.getTlfHome() != null) {
				entity.setTlfHome(value.getTlfHome());
			}
			return new ResponseEntity<>(this.service.save(entity), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") final Integer id) {
		this.service.deleteById(id);
	}

}
