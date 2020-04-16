package com.devjr.ca.viso.service;

import java.util.List;

import com.devjr.ca.viso.entity.ContactEntity;

public interface IContactService {

	List<ContactEntity> findAll();

	ContactEntity findById(Integer id);

	ContactEntity save(ContactEntity value);

	void deleteById(Integer id);

}
