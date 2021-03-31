package com.devjr.ca.viso.repository.attrconv;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.devjr.ca.viso.service.domain.EUserRol;

/**
 * [REPO : Attribute Converter] Test the Mapping from EUserRol to String and
 * viceversa.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 26/03/2021
 * @modify 29/03/2021
 */
class AttributeConverterEUserRolTest {

	private static final Logger LOG = LoggerFactory.getLogger(AttributeConverterEUserRolTest.class);

	private static EUserRol attribute;
	private static String dbData;
	private static AttributeConverterEUserRol attrConv = new AttributeConverterEUserRol();

	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeAll
	protected static void setUpBeforeClass() throws Exception {
		AttributeConverterEUserRolTest.LOG.debug("\n\tStartup All : initializing variables");

		AttributeConverterEUserRolTest.attribute = EUserRol.USER;
		AttributeConverterEUserRolTest.dbData = EUserRol.MEMBER.getName();
	}

	/**
	 * Test convert to database column.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Tag(value = "Methods Instance")
	@DisplayName(value = "Converter EUserRol to String")
	void testConvertToDatabaseColumn() throws Exception {
		final String res = AttributeConverterEUserRolTest.attrConv
				.convertToDatabaseColumn(AttributeConverterEUserRolTest.attribute);
		AttributeConverterEUserRolTest.LOG.debug("\n\t[Attribute Converter] EUserRol to String : " + res);
		Assertions.assertEquals(res, EUserRol.USER.getName());
	}

	/**
	 * Test convert to entity attribute.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Tag(value = "Methods Instance")
	@DisplayName(value = "Converter String to EUserRol")
	void testConvertToEntityAttribute() throws Exception {
		final EUserRol res = AttributeConverterEUserRolTest.attrConv
				.convertToEntityAttribute(AttributeConverterEUserRolTest.dbData);
		AttributeConverterEUserRolTest.LOG.debug("\n\t[Attribute Converter] String to EUserRol : " + res);
		Assertions.assertEquals(EUserRol.MEMBER, res);
	}

	/**
	 * Test convert to entity attribute with null.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Tag(value = "Methods Instance")
	@DisplayName(value = "Converter String to EUserRol with null")
	void testConvertToEntityAttributeNull() throws Exception {
		final EUserRol res = AttributeConverterEUserRolTest.attrConv.convertToEntityAttribute("Defecto");
		AttributeConverterEUserRolTest.LOG.debug("\n\t[Attribute Converter] String to EUserRol with null: " + res);
		Assertions.assertNull(res);
	}

}
