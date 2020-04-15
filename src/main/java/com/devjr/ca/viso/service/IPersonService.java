package com.devjr.ca.viso.service;

import java.util.List;

import com.devjr.ca.viso.entity.PersonEntity;

public interface IPersonService {

	List<PersonEntity> findAll();

	PersonEntity findById(Integer id);

	void save(PersonEntity value);

	void deleteById(Integer id);

}
