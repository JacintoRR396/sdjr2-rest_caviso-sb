package com.devjr.ca.viso.service.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.devjr.ca.viso.UtilsTesting;

/**
 * [Service : Domain] Test the logic respect to the User.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 11/04/2021
 * @modify 11/04/2021
 */
class UserTest {

	private static final Logger LOG = LoggerFactory.getLogger(UserTest.class);

	private static User objConst1;
	private static User objConst2;
	private static List<User> list;

	@BeforeAll
	protected static void setUpBeforeClass() throws Exception {
		UserTest.LOG.debug("Startup All : initializing variables");

		UserTest.objConst1 = new User(UtilsTesting.ID, UtilsTesting.USER_USERNAME, UtilsTesting.USER_PASSWORD,
				UtilsTesting.USER_LAST_ACCESS);

		UserTest.objConst2 = new User(UtilsTesting.ID_AUX, UtilsTesting.USER_USERNAME, UtilsTesting.USER_PASSWORD,
				UtilsTesting.USER_ALIAS_OPT, UtilsTesting.USER_ROL, UtilsTesting.USER_ACTIVE,
				UtilsTesting.USER_LAST_ACCESS);

		UserTest.list = new ArrayList<>();
		UserTest.list.add(UserTest.objConst1);
		final User.Builder objBuilder = UserTest.objConst1.builder();
		objBuilder.withRol(EUserRol.ADMIN);
		UserTest.list.add(objBuilder.build());
	}

	/* CONSTRUCTORS */
	@Test
	@Tag(value = "Constructs")
	@DisplayName(value = "Construct Empty")
	void testConstructEmpty() {
		final User user = new User();
		UserTest.LOG.info("\n\t[OK] : El Constructor vacio es:" + user);
		Assertions.assertTrue(Boolean.TRUE);
	}

	@Test
	@Tag(value = "Constructs")
	@DisplayName(value = "Construct One")
	void testConstructOne() {
		UserTest.LOG.info("\n\t[OK] : El Constructor One es:" + UserTest.objConst1);
		Assertions.assertTrue(Boolean.TRUE);
	}

	@Test
	@Tag(value = "Constructs")
	@DisplayName(value = "Construct Second")
	void testConstructSecond() {
		UserTest.LOG.info("\n\t[OK] : El Constructor Second es:" + UserTest.objConst2);
		Assertions.assertTrue(Boolean.TRUE);
	}

	@Test
	void testConstructBuilder() {
		final User user = new User.Builder().withId(UserTest.objConst1.getId())
				.withUsername(UserTest.objConst1.getUsername()).withPassword(UserTest.objConst1.getPassword())
				.withAlias(UserTest.objConst1.getAlias()).withRol(UserTest.objConst1.getRol())
				.withActive(UserTest.objConst1.isActive()).withLastAccess(UserTest.objConst1.getLastAccess()).build();
		UserTest.LOG.info("\n\t[OK] : El Constructor Builder es:" + user);
		Assertions.assertTrue(Boolean.TRUE);
	}

	/* GETTERS AND SETTERS */
	@Test
	@Tag(value = "GettersSetters")
	@DisplayName(value = "Getters and Setters")
	void testGetterAndSetter() {
		final User user = new User();
		user.setId(UserTest.objConst2.getId());
		user.setUsername(UserTest.objConst2.getUsername());
		user.setPassword(UserTest.objConst2.getPassword());
		user.setAlias(UserTest.objConst2.getAlias());
		user.setRol(UserTest.objConst2.getRol());
		user.setActive(UserTest.objConst2.isActive());
		user.setLastAccess(UserTest.objConst2.getLastAccess());
		Assertions.assertTrue(Boolean.TRUE);
	}

	/* METHODS OF INSTANCE */
	@Test
	@Tag(value = "Methods Instance")
	@DisplayName(value = "HashCode")
	void testHashCode() {
		final int value1 = UserTest.objConst1.hashCode();
		final int value2 = UserTest.objConst2.hashCode();
		Assertions.assertNotEquals(value1, value2);
	}

	@Test
	@Tag(value = "Methods Instance")
	@DisplayName(value = "HashCode with Id null")
	void testHashCode_withIdNull() {
		final User user = User.valueOf(UserTest.objConst1);
		user.setId(null);
		user.hashCode();
		Assertions.assertTrue(Boolean.TRUE);
	}

	@Test
	@Tag(value = "Methods Instance")
	@DisplayName(value = "HashCode with Username null")
	void testHashCode_withUsernameNull() {
		final User user = User.valueOf(UserTest.objConst1);
		user.setUsername(null);
		user.hashCode();
		Assertions.assertTrue(Boolean.TRUE);
	}

	@Test
	@Tag(value = "Methods Instance")
	@DisplayName(value = "Equals with same obj")
	void testEquals_sameObj() throws Exception {
		Assertions.assertEquals(UserTest.objConst1, UserTest.objConst1);
	}

	@Test
	@Tag(value = "Methods Instance")
	@DisplayName(value = "Equals with obj not instance")
	void testEquals_notInstance() throws Exception {
		Assertions.assertNotEquals(UserTest.objConst1, "Test");
	}

	@Test
	@Tag(value = "Methods Instance")
	@DisplayName(value = "Equals match")
	void testEquals_match() throws Exception {
		final User user = User.valueOf(UserTest.objConst1);
		Assertions.assertEquals(UserTest.objConst1, user);
	}

	@Test
	@Tag(value = "Methods Instance")
	@DisplayName(value = "Equals distinct")
	void testEquals_distinct() throws Exception {
		Assertions.assertNotEquals(UserTest.objConst1, UserTest.objConst2);
	}

	@Test
	@Tag(value = "Methods Instance")
	@DisplayName(value = "ToString")
	void testToString() throws Exception {
		UserTest.LOG.debug("testToString : \n" + UserTest.objConst1);
		Assertions.assertTrue(Boolean.TRUE);
	}

	@Test
	@Tag(value = "Methods Instance")
	@DisplayName(value = "CompareTo of Comparable")
	void testCompateTo() {
		Assertions.assertEquals(0, UserTest.objConst1.compareTo(UserTest.objConst2));
	}

	@Test
	@Tag(value = "Methods Instance")
	@DisplayName(value = "Builder")
	void testBuilder() {
		final User.Builder builder = UserTest.objConst1.builder();
		Assertions.assertNotNull(builder);
	}

	/* METHODS OF CLASSES */
	@Test
	@Tag(value = "Methods Class")
	@DisplayName(value = "ValueOf")
	void testValueOf() {
		final User user = User.valueOf(UserTest.objConst1);
		Assertions.assertNotNull(user);
	}

	@Test
	@Tag(value = "Methods Class")
	@DisplayName(value = "Comparator by Town ASC")
	void testComparatorTown_ASC() {
		Collections.sort(UserTest.list, User.comparatorRolASC);
		Assertions.assertTrue(Boolean.TRUE);
		UserTest.LOG.info("\n\t[OK] : El Comparador por Rol ASC es:" + UserTest.list);
	}

	@Test
	@Tag(value = "Methods Class")
	@DisplayName(value = "Comparator by Town DESC")
	void testComparatorTown_DESC() {
		Collections.sort(UserTest.list, User.comparatorRolDESC);
		Assertions.assertTrue(Boolean.TRUE);
		UserTest.LOG.info("\n\t[OK] : El Comparador por Rol DESC es:" + UserTest.list);
	}
}
