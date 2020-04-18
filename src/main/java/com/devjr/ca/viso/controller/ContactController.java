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

	@GetMapping("/orderByEmail")
	public ResponseEntity<List<Contact>> getAllOrderByEmail() {
		return ResponseEntity.ok().body(this.service.findAllOrderByEmail());
	}

	@GetMapping("/searchByPhoneMobile/{phoneMobile}")
	public ResponseEntity<List<Contact>> getAllByPhoneMovil(@PathVariable("phoneMobile") final String phoneMobile) {
		return ResponseEntity.ok().body(this.service.searchByPhoneMobile(phoneMobile));
	}

	@GetMapping("/searchByPhoneHome/{phoneHome}")
	public ResponseEntity<List<Contact>> getAllByPhoneHome(@PathVariable("phoneHome") final String phoneHome) {
		return ResponseEntity.ok().body(this.service.searchByPhoneHome(phoneHome));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Contact> get(@PathVariable("id") final Integer id) {
		final Contact entity = this.service.findById(id);
		if (entity != null)
			return new ResponseEntity<>(entity, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	/*********** PSOT ***********/
	@PostMapping(consumes = MediaType.APPLICATION_JSON)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Contact> insert(@RequestBody final Contact value) {
		return ResponseEntity.ok().body(this.service.save(value));
	}

	/*********** PUT ***********/
	@PutMapping(consumes = MediaType.APPLICATION_JSON)
	public ResponseEntity<Contact> updateAll(@Valid @RequestBody final Contact value) {
		return ResponseEntity.ok().body(this.service.save(value));
	}

	/*********** PATCH ***********/
	@PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON)
	public ResponseEntity<Contact> update(@PathVariable("id") final Integer id, @RequestBody final Contact value) {
		final Contact entityDAO = this.service.findById(id);
		final Contact.Builder entity = Contact.valueOf(entityDAO).builder();
		if (entity != null) {
			if (value.getEmail() != null) {
				entity.withEmail(value.getEmail());
			}
			if (value.getPhoneMobile() != null) {
				entity.withPhoneMobile(value.getPhoneMobile());
			}
			if (value.getPhoneHome() != null) {
				entity.withPhoneHome(value.getPhoneHome());
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
