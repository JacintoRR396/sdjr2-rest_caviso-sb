package com.devjr.ca.viso.controller;

import java.util.List;

import javax.validation.Valid;
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

import com.devjr.ca.viso.domain.Contact;
import com.devjr.ca.viso.service.IContactService;

@RestController
@RequestMapping(path = "/contacts", produces = MediaType.APPLICATION_JSON)
@CrossOrigin(origins = "*")
public class ContactController {

	@Autowired
	private IContactService service;

	/*********** GET ***********/
	@GetMapping()
	public ResponseEntity<List<Contact>> getAll() {
		return ResponseEntity.ok().body(this.service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Contact> get(@PathVariable("id") final Integer id) {
		final Contact entity = this.service.findById(id);
		if (entity != null)
			return new ResponseEntity<>(entity, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Contact> insert(@RequestBody final Contact value) {
		return ResponseEntity.ok().body(this.service.save(value));
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON)
	public ResponseEntity<Contact> updateAll(@Valid @RequestBody final Contact value) {
		return ResponseEntity.ok().body(this.service.save(value));
	}

	@PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON)
	public ResponseEntity<Contact> update(@PathVariable("id") final Integer id, @RequestBody final Contact value) {
		final Contact entity = this.service.findById(id);
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
