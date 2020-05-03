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

import com.devjr.ca.viso.domain.Address;
import com.devjr.ca.viso.service.IAddressService;

/**
 * Representa el Controlador respecto a la Dirección de una Persona
 * Física/Jurídica o Carrera.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 03/05/2020
 * @modify 03/05/2020
 */
@RestController
@RequestMapping(path = "/addresses", produces = MediaType.APPLICATION_JSON)
@CrossOrigin(origins = "*")
public class AddressController {

	@Autowired
	private IAddressService service;

	/*********** GET ***********/
	@GetMapping()
	public ResponseEntity<List<Address>> getAll() {
		return ResponseEntity.ok().body(this.service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Address> get(@PathVariable("id") final Integer id) {
		final Address entity = this.service.findById(id);
		if (entity != null) {
			return new ResponseEntity<>(entity, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	/*********** POST ***********/
	@PostMapping(consumes = MediaType.APPLICATION_JSON)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Address> insert(@RequestBody final Address value) {
		return ResponseEntity.ok().body(this.service.save(value));
	}

	/*********** PUT ***********/
	@PutMapping(consumes = MediaType.APPLICATION_JSON)
	public ResponseEntity<Address> updateAll(@Valid @RequestBody final Address value) {
		return ResponseEntity.ok().body(this.service.save(value));
	}

	/*********** PATCH ***********/
	@PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON)
	public ResponseEntity<Address> update(@PathVariable("id") final Integer id, @RequestBody final Address value) {
		final Address entityDAO = this.service.findById(id);
		final Address.Builder entity = Address.valueOf(entityDAO).builder();
		if (entity != null) {
			if (!StringUtils.isEmpty(value.getStreet())) {
				entity.withStreet(value.getStreet());
			}
			if (!StringUtils.isEmpty(value.getNumber())) {
				entity.withNumber(value.getNumber());
			}
			if (!StringUtils.isEmpty(value.getTown())) {
				entity.withTown(value.getTown());
			}
			if (!StringUtils.isEmpty(value.getCity())) {
				entity.withCity(value.getCity());
			}
			if (!StringUtils.isEmpty(value.getCountry())) {
				entity.withCountry(value.getCountry());
			}
			if (value.getPostalCode() != null) {
				entity.withPostalCode(value.getPostalCode());
			}
			if (!StringUtils.isEmpty(value.getAdditionalInfo())) {
				entity.withAdditionalInfo(value.getAdditionalInfo());
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
