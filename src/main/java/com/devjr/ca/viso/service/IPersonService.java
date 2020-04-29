package com.devjr.ca.viso.service;

import java.util.List;

import com.devjr.ca.viso.domain.Person;

public interface IPersonService{

    List<Person> findAll();

    Person findById(Integer id);

    Person save(Person value);

    void deleteById(Integer id);

}
