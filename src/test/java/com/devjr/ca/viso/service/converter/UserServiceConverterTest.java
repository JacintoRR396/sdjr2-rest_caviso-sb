package com.devjr.ca.viso.service.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.devjr.ca.viso.UtilsTesting;
import com.devjr.ca.viso.repository.entity.UserEntity;
import com.devjr.ca.viso.service.domain.User;

/**
 * [Service : Converter] Test the User Service Converter.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 11/04/2021
 * @modify 11/04/2021
 */
class UserServiceConverterTest {

	private static final Logger LOG = LoggerFactory.getLogger(UserServiceConverterTest.class);

	private static User domain;
	private static UserEntity entity;
	private static UserServiceConverter converter;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		UserServiceConverterTest.LOG.debug("Startup All : initializing variables");

		UserServiceConverterTest.domain = new User(UtilsTesting.ID, UtilsTesting.USER_USERNAME,
				UtilsTesting.USER_PASSWORD, UtilsTesting.USER_LAST_ACCESS);

		UserServiceConverterTest.entity = new UserEntity(UtilsTesting.ID, UtilsTesting.USER_USERNAME,
				UtilsTesting.USER_PASSWORD, UtilsTesting.USER_LAST_ACCESS);

		UserServiceConverterTest.converter = new UserServiceConverter();
	}

	@Test
	void testConvertToEntity() throws Exception {
		final UserEntity res = UserServiceConverterTest.converter.convertToEntity(UserServiceConverterTest.domain);
		Assertions.assertNotNull(res);
	}

	@Test
	void testConvertToEntity_withException() throws Exception {
		Assertions.assertThrows(NullPointerException.class, () -> {
			UserServiceConverterTest.converter.convertToEntity(null);
		});
	}

	@Test
	void testConvertToDomain() throws Exception {
		final User res = UserServiceConverterTest.converter.convertToDomain(UserServiceConverterTest.entity);
		Assertions.assertNotNull(res);
	}

	@Test
	void testConvertToDomain_withException() throws Exception {
		Assertions.assertThrows(NullPointerException.class, () -> {
			UserServiceConverterTest.converter.convertToDomain(null);
		});
	}

}
