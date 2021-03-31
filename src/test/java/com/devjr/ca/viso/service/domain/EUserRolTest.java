package com.devjr.ca.viso.service.domain;

import java.util.Arrays;
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
 * [SERVICE : Domain] Test the Enumerated representing the roles of a User.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 23/03/2021
 * @modify 29/03/2021
 */
class EUserRolTest {

	private static final Logger LOG = LoggerFactory.getLogger(EUserRolTest.class);

	private static String[] userRolNames;
	private static List<EUserRol> allRols;

	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeAll
	protected static void setUpBeforeClass() throws Exception {
		EUserRolTest.LOG.debug("Startup All : initializing variables");
		EUserRolTest.userRolNames = new String[] { UtilsTesting.USER_ROL_USER, UtilsTesting.USER_ROL_MEMBER,
				UtilsTesting.USER_ROL_ADMIN };
		EUserRolTest.allRols = Arrays.asList(EUserRol.values());
	}

	/**
	 * Test get name.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Tag(value = "Getters")
	@DisplayName(value = "Get Name")
	void testGetName() throws Exception {
		for (int i = 0; i < EUserRolTest.userRolNames.length; i++) {
			Assertions.assertEquals(EUserRolTest.userRolNames[i], EUserRol.values()[i].getName());
		}
	}

	/**
	 * Test get code.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Tag(value = "Getters")
	@DisplayName(value = "Get Code")
	void testGetCode() throws Exception {
		for (int i = 0; i < EUserRol.values().length; i++) {
			Assertions.assertEquals(i + 1, EUserRol.values()[i].getCode());
		}
	}

	/**
	 * Test comparator by code ASC.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Tag(value = "Method Class")
	@DisplayName(value = "Comparator by Code Asc")
	void testComparatorByCodeASC() throws Exception {
		Collections.sort(EUserRolTest.allRols, EUserRol.comparatorByCodeASC);
		EUserRolTest.LOG.debug("List order by code asc : " + EUserRolTest.allRols);
		Assertions.assertTrue(Boolean.TRUE);
	}

	/**
	 * Test comparator by code desc.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Tag(value = "Method Class")
	@DisplayName(value = "Comparator by Code Desc")
	void testComparatorByCodeDesc() throws Exception {
		Collections.sort(EUserRolTest.allRols, EUserRol.comparatorByCodeDESC);
		EUserRolTest.LOG.debug("List order by code desc : " + EUserRolTest.allRols);
		Assertions.assertTrue(Boolean.TRUE);
	}

	/**
	 * Test converter from string.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Tag(value = "Method Class")
	@DisplayName(value = "Converter from String")
	void testConverterFromString() throws Exception {
		for (int i = 0; i < EUserRolTest.userRolNames.length; i++) {
			Assertions.assertEquals(EUserRol.values()[i],
					EUserRol.converterFromString(EUserRolTest.userRolNames[i]).get());
		}
	}

	/**
	 * Test converter to string.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Tag(value = "Method Class")
	@DisplayName(value = "Converter to String")
	void testConverterToString() throws Exception {
		for (int i = 0; i < EUserRolTest.userRolNames.length; i++) {
			Assertions.assertEquals(EUserRolTest.userRolNames[i], EUserRol.converterToString(EUserRol.values()[i]));
		}
	}

}
