package com.devjr.ca.viso.service;

import java.util.List;

import com.devjr.ca.viso.domain.PersonComplete;

public interface IPersonCompleteService {

	List<PersonComplete> findAll();

	PersonComplete findById(Integer id);

	PersonComplete save(PersonComplete value);

	void deleteById(Integer id);

}
