package com.devjr.ca.viso.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devjr.ca.viso.entity.PersonEntity;
import com.devjr.ca.viso.service.IPersonService;

/**
 * Representa el Controlador respecto a una Persona Común.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 20/04/2020
 * @modify 20/04/2020
 */
@RestController
@RequestMapping(path = "/persons", produces = MediaType.APPLICATION_JSON)
@CrossOrigin(origins = "*")
public class PersonController {

	@Autowired
	private IPersonService service;

	/*********** GET ***********/
	@GetMapping()
	public List<PersonEntity> getAll() {
		return this.service.findAll();
	}

	@GetMapping(value = "/{id}")
	public PersonEntity get(@PathVariable("id") final Integer id) {
		return this.service.findById(id);
	}

	@PostMapping()
	public void insert(@RequestBody final PersonEntity value) {
		this.service.save(value);
	}

	@PutMapping()
	public void update(@RequestBody final PersonEntity value) {
		this.service.save(value);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") final Integer id) {
		this.service.deleteById(id);
	}

}
