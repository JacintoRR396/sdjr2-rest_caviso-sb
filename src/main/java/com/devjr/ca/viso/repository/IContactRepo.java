package com.devjr.ca.viso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devjr.ca.viso.entity.ContactEntity;

public interface IContactRepo extends JpaRepository<ContactEntity, Integer> {

//	List<ContactEntity> findAllOrderByEmail();

}
