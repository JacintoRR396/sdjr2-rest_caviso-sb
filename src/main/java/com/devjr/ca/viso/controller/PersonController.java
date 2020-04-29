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
import com.devjr.ca.viso.domain.Person;
import com.devjr.ca.viso.service.IPersonService;

/**
 * Representa el Controlador respecto a una Persona Común.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 20/04/2020
 * @modify 23/04/2020
 */
@RestController
@RequestMapping(path = "/persons", produces = MediaType.APPLICATION_JSON)
@CrossOrigin(origins = "*")
public class PersonController{

    @Autowired
    private IPersonService service;

    /*********** GET ***********/
    @GetMapping()
    public ResponseEntity<List<Person>> getAll(){
        return ResponseEntity.ok().body(this.service.findAll());
    }

    /*********** PSOT ***********/
    @PostMapping(consumes = MediaType.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Person> insert(@RequestBody
    final Person value){
        return ResponseEntity.ok().body(this.service.save(value));
    }

    /*********** PUT ***********/
    @PutMapping(consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<Person> updateAll(@Valid
    @RequestBody
    final Person value){
        return ResponseEntity.ok().body(this.service.save(value));
    }

    /*********** PATCH ***********/
    @PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<Person> update(@PathVariable("id")
    final Integer id, @RequestBody
    final Person value){
        final Person entityDAO = this.service.findById(id);
        final Person.Builder entity = Person.valueOf(entityDAO).builder();
        if(entity != null){
            if(value.getDocumentType().equals(EPersonDocument.EMPTY)){
                entity.withDocumentType(value.getDocumentType());
            }
            if(!StringUtils.isEmpty(value.getDocumentNumber())){
                entity.withDocumentNumber(value.getDocumentNumber());
            }
            if(!StringUtils.isEmpty(value.getName())){
                entity.withName(value.getName());
            }
            if(!StringUtils.isEmpty(value.getSurname())){
                entity.withSurname(value.getSurname());
            }
            if(value.getBirthdate() != null){
                entity.withBirthdate(value.getBirthdate());
            }
            if(value.getBalance() != null){
                entity.withBalance(value.getBalance());
            }
            if(!StringUtils.isEmpty(value.getPathImage())){
                entity.withPathImage(value.getPathImage());
            }
            if(!StringUtils.isEmpty(value.getDescription())){
                entity.withDescription(value.getDescription());
            }
            if(value.getContact() != null){
                entity.withContact(value.getContact());
            }
            return new ResponseEntity<>(this.service.save(entity.build()), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    /*********** DELETE ***********/
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id")
    final Integer id){
        this.service.deleteById(id);
    }

}
