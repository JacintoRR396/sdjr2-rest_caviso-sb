package com.devjr.ca.viso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devjr.ca.viso.entity.AddressEntity;

/**
 * Representa el Repositorio JPA respecto a la Dirección de una Persona
 * Física/Jurídica o Carrera.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 03/05/2020
 * @modify 03/05/2020
 */
@Repository
public interface IAddressRepo extends JpaRepository<AddressEntity, Integer> {

}
