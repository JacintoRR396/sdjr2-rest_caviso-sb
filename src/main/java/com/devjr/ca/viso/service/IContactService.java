package com.devjr.ca.viso.service;

import java.util.List;

import com.devjr.ca.viso.domain.Contact;

public interface IContactService {

	List<Contact> findAll();

	List<Contact> findAllOrderByEmail();

	List<Contact> searchByPhoneMobile(final String phoneMobile);

	List<Contact> searchByPhoneHome(final String phoneHome);

	Contact findById(Integer id);

	Contact save(Contact value);

	void deleteById(Integer id);

}
