package com.devjr.ca.viso.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devjr.ca.viso.repository.IUserRepository;
import com.devjr.ca.viso.repository.entity.UserEntity;
import com.devjr.ca.viso.service.IUserService;
import com.devjr.ca.viso.service.converter.UserServiceConverter;
import com.devjr.ca.viso.service.domain.User;
import com.devjr.ca.viso.zutils.UtilsLanguage;

/**
 * [Service] Implement Service respect to the User.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 11/04/2021
 * @modify 11/04/2021
 */
@Service
public class UserServiceImpl implements IUserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private IUserRepository repo;

	@Autowired
	private UserServiceConverter converter;

	/*********** GET ***********/
	@Override
	public List<User> findAll() {
		final List<UserEntity> listDAO = this.repo.findAll();
		final List<User> listDomain = listDAO.stream().map(ce -> this.converter.convertToDomain(ce))
				.collect(Collectors.toList());
		if (listDomain.isEmpty()) {
			UserServiceImpl.LOG.info(UtilsLanguage.MSG_ERROR_GET_ALL_BBDD);
		}
		return listDomain;
	}

	@Override
	public User findById(final Integer id) {
		final Optional<UserEntity> opt = this.repo.findById(id);
		User domain = null;
		if (opt.isPresent()) {
			domain = this.converter.convertToDomain(opt.get());
		}
		UserServiceImpl.LOG.info(UtilsLanguage.MSG_ERROR_GET_ONE_BBDD);
		return domain;
	}

	/*********** POST - PUT - PATCH ***********/
	@Override
	public User save(final User value) {
		final UserEntity entity = this.converter.convertToEntity(value);
		final User domain = this.converter.convertToDomain(this.repo.save(entity));
		UserServiceImpl.LOG.info(UtilsLanguage.MSG_OK_ADD_UPDATE_BBDD);
		return domain;
	}

	/*********** DELETE ***********/
	@Override
	public void deleteById(final Integer id) {
		try {
			this.repo.deleteById(id);
			UserServiceImpl.LOG.info(UtilsLanguage.MSG_OK_DELETE_BBDD);
		} catch (final EmptyResultDataAccessException e) {
			UserServiceImpl.LOG.info(UtilsLanguage.MSG_ERROR_DELETE_BBDD);
		}
	}

}
