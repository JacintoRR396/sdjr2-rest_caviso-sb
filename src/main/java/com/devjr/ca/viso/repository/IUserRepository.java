package com.devjr.ca.viso.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devjr.ca.viso.repository.entity.UserEntity;
import com.devjr.ca.viso.service.domain.EUserRol;

/**
 * [REPO] JPA Repository for Users .
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 26/03/2021
 * @modify 31/03/2021
 */
@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Integer> {

	UserEntity findByUsername(String username);

	UserEntity findByUsernameIgnoreCase(String username);

	List<UserEntity> findByRol(EUserRol rol);

	List<UserEntity> findByActive(Boolean active);

	List<UserEntity> findByLastAccess(LocalDateTime lastAccess);

	List<UserEntity> findByLastAccessLessThan(LocalDateTime lastAccess);

	List<UserEntity> findByLastAccessGreaterThan(LocalDateTime lastAccess);

	@Query(value = "SELECT * FROM user WHERE username = ?1 AND password = ?2 AND active = 1", nativeQuery = true)
	UserEntity findByUsernameAndPasswordAndActiveTRUE(String username, String password);

}
