package com.devjr.ca.viso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devjr.ca.viso.entity.ContactEntity;
import com.devjr.ca.viso.service.IContactService;

@RestController
@RequestMapping(path = "/contacts")
public class ContactController {

	@Autowired
	private IContactService service;

	@GetMapping()
	public List<ContactEntity> getAll() {
		return this.service.findAll();
	}

	@GetMapping(value = "/{id}")
	public ContactEntity get(@PathVariable("id") final Integer id) {
		return this.service.findById(id);
	}

	@PostMapping()
	public void insert(@RequestBody final ContactEntity value) {
		this.service.save(value);
	}

	@PutMapping()
	public void update(@RequestBody final ContactEntity value) {
		this.service.save(value);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") final Integer id) {
		this.service.deleteById(id);
	}

}
