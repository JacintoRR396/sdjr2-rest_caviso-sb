package com.devjr.ca.viso.service;

import java.util.List;

import com.devjr.ca.viso.domain.Address;

/**
 * Representa el Servicio respecto a la Dirección de una Persona Física/Jurídica
 * o Carrera.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 03/05/2020
 * @modify 03/05/2020
 */
public interface IAddressService {

	List<Address> findAll();

	Address findById(Integer id);

	Address save(Address value);

	void deleteById(Integer id);

}
