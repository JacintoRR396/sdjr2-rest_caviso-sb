package com.devjr.ca.viso.repository.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.devjr.ca.viso.UtilsTesting;

/**
 * [REPO : Entity] Test the create and map the data table with respect to the
 * User.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 24/03/2021
 * @modify 26/03/2021
 */
class UserEntityTest {

	private static final Logger LOG = LoggerFactory.getLogger(UserEntityTest.class);

	private static UserEntity objConstEmpty;
	private static UserEntity objConst1;
	private static UserEntity objConst2;
	private static UserEntity objAux;

	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeAll
	protected static void setUpBeforeClass() throws Exception {
		UserEntityTest.LOG.debug("Startup All : initializing variables");

		UserEntityTest.objConstEmpty = new UserEntity();

		UserEntityTest.objConst1 = new UserEntity(UtilsTesting.ID, UtilsTesting.USER_USERNAME,
				UtilsTesting.USER_PASSWORD, UtilsTesting.USER_LAST_ACCESS);

		UserEntityTest.objConst2 = new UserEntity(UtilsTesting.ID_AUX, UtilsTesting.USER_USERNAME,
				UtilsTesting.USER_PASSWORD, UtilsTesting.USER_ALIAS, UtilsTesting.USER_ROL, UtilsTesting.USER_ACTIVE,
				UtilsTesting.USER_LAST_ACCESS);

		UserEntityTest.objAux = new UserEntity();
		UserEntityTest.objAux.setId(UserEntityTest.objConst2.getId());
		UserEntityTest.objAux.setUsername(UserEntityTest.objConst2.getUsername());
		UserEntityTest.objAux.setPassword(UserEntityTest.objConst2.getPassword());
		UserEntityTest.objAux.setAlias(UserEntityTest.objConst2.getAlias());
		UserEntityTest.objAux.setRol(UserEntityTest.objConst2.getRol());
		UserEntityTest.objAux.setActive(UserEntityTest.objConst2.isActive());
		UserEntityTest.objAux.setLastAccess(UserEntityTest.objConst2.getLastAccess());
	}

	/**
	 * Test user entity.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Tag(value = "Constructs")
	@DisplayName(value = "Construct Empty")
	void testUserEntity() throws Exception {
		UserEntityTest.LOG.debug("Construct Empty : \n" + UserEntityTest.objConstEmpty);
		Assertions.assertTrue(Boolean.TRUE);
	}

	/**
	 * Test user entity integer string string local date time.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Tag(value = "Constructs")
	@DisplayName(value = "Construct 1")
	void testUserEntityIntegerStringStringLocalDateTime() throws Exception {
		UserEntityTest.LOG.debug("Construct 1 : \n" + UserEntityTest.objConst1);
		Assertions.assertTrue(Boolean.TRUE);
	}

	/**
	 * Test user entity integer string string string E user rol boolean local date
	 * time.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Tag(value = "Constructs")
	@DisplayName(value = "Construct 2")
	void testUserEntityIntegerStringStringStringEUserRolBooleanLocalDateTime() throws Exception {
		UserEntityTest.LOG.debug("Construct 2 : \n" + UserEntityTest.objConst2);
		Assertions.assertTrue(Boolean.TRUE);
	}

	/**
	 * Test to string.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Tag(value = "Methods Instance")
	@DisplayName(value = "To String")
	void testToString() throws Exception {
		UserEntityTest.LOG.debug("testToString : \n" + UserEntityTest.objConst2);
		Assertions.assertTrue(Boolean.TRUE);
	}

}
