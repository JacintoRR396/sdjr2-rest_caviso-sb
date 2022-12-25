package com.devjr.ca.viso.service;

import java.util.List;

import com.devjr.ca.viso.service.domain.User;

/**
 * [Service] Interface Service respect to the User.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 11/04/2021
 * @modify 11/04/2021
 */
public interface IUserService {

	List<User> findAll();

	User findById(Integer id);

	User save(User value);

	void deleteById(Integer id);

}
