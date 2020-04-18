package com.devjr.ca.viso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devjr.ca.viso.entity.ContactEntity;

public interface IContactRepo extends JpaRepository<ContactEntity, Integer> {

	@Query("from ContactEntity ce order by ce.email")
	// @Query(value = "SELECT * FROM contact ORDER BY email", nativeQuery = true)
	List<ContactEntity> findAllOrderByEmail();

	@Query("from ContactEntity ce where ce.phoneMobile like %?1%")
	List<ContactEntity> searchPhoneMovil(String phoneMobile);

	List<ContactEntity> findByPhoneHomeContainingOrderByEmailAsc(String phoneHome);

}
