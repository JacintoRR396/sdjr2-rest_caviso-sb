package com.devjr.ca.viso.service.converter;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.devjr.ca.viso.repository.entity.UserEntity;
import com.devjr.ca.viso.service.domain.User;
import com.devjr.ca.viso.zutils.UtilsLanguage;

/**
 * [Service : Converter] User Service Converter.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 11/04/2021
 * @modify 11/04/2021
 */
@Component
public class UserServiceConverter implements IServiceConverter<User, UserEntity> {

	private static final Logger LOG = LoggerFactory.getLogger(UserServiceConverter.class);

	@Override
	public UserEntity convertToEntity(final User domain) {
		final UserEntity entity;
		try {
			entity = new UserEntity();
			entity.setId(domain.getId());
			entity.setUsername(domain.getUsername());
			entity.setPassword(domain.getPassword());
			domain.getAlias().ifPresent(s -> entity.setAlias(s));
			entity.setRol(domain.getRol());
			entity.setActive(domain.isActive());
			entity.setLastAccess(domain.getLastAccess());
		} catch (final NullPointerException e) {
			UserServiceConverter.LOG.info(UtilsLanguage.MSG_ERROR_CONVERT_FROM_DOMAIN_TO_ENTITY);
			throw new NullPointerException(UtilsLanguage.MSG_ERROR_CONVERT_FROM_DOMAIN_TO_ENTITY);
		}
		return entity;
	}

	@Override
	public User convertToDomain(final UserEntity entity) {
		final User domain;
		try {
			domain = new User();
			domain.setId(entity.getId());
			domain.setUsername(entity.getUsername());
			domain.setPassword(entity.getPassword());
			domain.setAlias(Optional.of(entity.getAlias()));
			domain.setRol(entity.getRol());
			domain.setActive(entity.isActive());
			domain.setLastAccess(entity.getLastAccess());
		} catch (final NullPointerException e) {
			UserServiceConverter.LOG.info(UtilsLanguage.MSG_ERROR_CONVERT_FROM_ENTITY_TO_DOMAIN);
			throw new NullPointerException(UtilsLanguage.MSG_ERROR_CONVERT_FROM_ENTITY_TO_DOMAIN);
		}
		return domain;
	}

}
