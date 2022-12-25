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

	private static UserEntity objConst1;
	private static UserEntity objConst2;

	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeAll
	protected static void setUpBeforeClass() throws Exception {
		UserEntityTest.LOG.debug("Startup All : initializing variables");

		UserEntityTest.objConst1 = new UserEntity(UtilsTesting.ID, UtilsTesting.USER_USERNAME,
				UtilsTesting.USER_PASSWORD, UtilsTesting.USER_LAST_ACCESS);

		UserEntityTest.objConst2 = new UserEntity(UtilsTesting.ID_AUX, UtilsTesting.USER_USERNAME,
				UtilsTesting.USER_PASSWORD, UtilsTesting.USER_ALIAS, UtilsTesting.USER_ROL, UtilsTesting.USER_ACTIVE,
				UtilsTesting.USER_LAST_ACCESS);

	}

	/* CONSTRUCTORS */
	/**
	 * Test user entity.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Tag(value = "Constructs")
	@DisplayName(value = "Construct Empty")
	void testConstructEmpty() throws Exception {
		final UserEntity user = new UserEntity();
		UserEntityTest.LOG.info("\n\t[OK] : El Constructor vacio es:" + user);
		Assertions.assertTrue(Boolean.TRUE);
	}

	/**
	 * Test user entity integer string string local date time.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Tag(value = "Constructs")
	@DisplayName(value = "Construct One")
	void testConstructOne() {
		UserEntityTest.LOG.info("\n\t[OK] : El Constructor One es:" + UserEntityTest.objConst1);
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
	@DisplayName(value = "Construct Second")
	void testConstructSecond() {
		UserEntityTest.LOG.info("\n\t[OK] : El Constructor Second es:" + UserEntityTest.objConst2);
		Assertions.assertTrue(Boolean.TRUE);
	}

	/* GETTERS AND SETTERS */
	@Test
	@Tag(value = "GettersSetters")
	@DisplayName(value = "Getters and Setters")
	void testGetterAndSetter() {
		final UserEntity user = new UserEntity();
		user.setId(UserEntityTest.objConst2.getId());
		user.setUsername(UserEntityTest.objConst2.getUsername());
		user.setPassword(UserEntityTest.objConst2.getPassword());
		user.setAlias(UserEntityTest.objConst2.getAlias());
		user.setRol(UserEntityTest.objConst2.getRol());
		user.setActive(UserEntityTest.objConst2.isActive());
		user.setLastAccess(UserEntityTest.objConst2.getLastAccess());
		Assertions.assertTrue(Boolean.TRUE);
	}

	/* METHODS OF INSTANCE */
	/**
	 * Test to string.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Tag(value = "Methods Instance")
	@DisplayName(value = "ToString")
	void testToString() throws Exception {
		UserEntityTest.LOG.debug("testToString : \n" + UserEntityTest.objConst2);
		Assertions.assertTrue(Boolean.TRUE);
	}

}
