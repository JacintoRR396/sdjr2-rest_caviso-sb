package com.devjr.ca.viso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devjr.ca.viso.entity.PersonEntity;

public interface IPersonRepo extends JpaRepository<PersonEntity, Integer> {

}
