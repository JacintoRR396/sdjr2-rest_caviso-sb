package com.devjr.ca.viso.service;

import java.util.List;

import com.devjr.ca.viso.domain.Contact;

/**
 * Representa el Servicio respecto a los Medios de Contacto de una Persona
 * Física/Jurídica o Carrera.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 18/04/2020
 * @modify 18/04/2020
 */
public interface IContactService {

	List<Contact> findAll();

	List<Contact> findAllOrderByEmail();

	List<Contact> searchByPhoneMobile(final String phoneMobile);

	List<Contact> searchByPhoneHome(final String phoneHome);

	Contact findById(Integer id);

	Contact save(Contact value);

	void deleteById(Integer id);

}
