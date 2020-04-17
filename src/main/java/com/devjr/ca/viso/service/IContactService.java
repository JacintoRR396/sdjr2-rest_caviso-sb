package com.devjr.ca.viso.service;

import java.util.List;

import com.devjr.ca.viso.domain.Contact;

public interface IContactService {

	List<Contact> findAll();

	// List<ContactEntity> findAllOrderByEmail();

	Contact findById(Integer id);

	Contact save(Contact value);

	void deleteById(Integer id);

}
