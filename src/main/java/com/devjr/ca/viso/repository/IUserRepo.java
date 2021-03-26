package com.devjr.ca.viso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devjr.ca.viso.repository.entity.UserEntity;

/**
 * [REPO] JPA Repository for Users .
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 26/03/2021
 * @modify 26/03/2021
 */
@Repository
public interface IUserRepo extends JpaRepository<UserEntity, Integer> {

}
