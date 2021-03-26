package com.devjr.ca.viso.repository.attrconv;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * [REPO : Attribute Converter] Test the Mapping from Boolean to Byte(Tinyint)
 * and viceversa.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 26/03/2021
 * @modify 26/03/2021
 */
class AttributeConverterBooleanTest {

	private static final Logger LOG = LoggerFactory.getLogger(AttributeConverterBooleanTest.class);

	private static Boolean attributeTrue;
	private static Byte dbDataOne;
	private static Boolean attributeFalse;
	private static Byte dbDataZero;
	private static AttributeConverterBoolean attrConv = new AttributeConverterBoolean();

	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeAll
	protected static void setUpBeforeClass() throws Exception {
		AttributeConverterBooleanTest.LOG.debug("\n\tStartup All : initializing variables");

		AttributeConverterBooleanTest.attributeTrue = Boolean.TRUE;
		AttributeConverterBooleanTest.dbDataOne = 1;
		AttributeConverterBooleanTest.attributeFalse = Boolean.FALSE;
		AttributeConverterBooleanTest.dbDataZero = 0;
	}

	/**
	 * Test convert to database column true.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Tag(value = "Methods Instance")
	@DisplayName(value = "Converter Boolean to Byte with true")
	void testConvertToDatabaseColumnTrue() throws Exception {
		final Byte res = AttributeConverterBooleanTest.attrConv
				.convertToDatabaseColumn(AttributeConverterBooleanTest.attributeTrue);
		AttributeConverterBooleanTest.LOG.debug("\n\t[Attribute Converter] Boolean to Byte : " + res);
		Assertions.assertEquals((byte) 1, res);
	}

	/**
	 * Test convert to database column false.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Tag(value = "Methods Instance")
	@DisplayName(value = "Converter Boolean to Byte with false")
	void testConvertToDatabaseColumnFalse() throws Exception {
		final Byte res = AttributeConverterBooleanTest.attrConv
				.convertToDatabaseColumn(AttributeConverterBooleanTest.attributeFalse);
		AttributeConverterBooleanTest.LOG.debug("\n\t[Attribute Converter] Boolean to Byte : " + res);
		Assertions.assertEquals((byte) 0, res);
	}

	/**
	 * Test convert to entity attribute one.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Tag(value = "Methods Instance")
	@DisplayName(value = "Converter Byte toBoolean with 1")
	void testConvertToEntityAttributeOne() throws Exception {
		final Boolean res = AttributeConverterBooleanTest.attrConv
				.convertToEntityAttribute(AttributeConverterBooleanTest.dbDataOne);
		AttributeConverterBooleanTest.LOG.debug("\n\t[Attribute Converter] Byte to Boolean : " + res);
		Assertions.assertTrue(res);
	}

	/**
	 * Test convert to entity attribute zero.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Tag(value = "Methods Instance")
	@DisplayName(value = "Converter Byte toBoolean with 0")
	void testConvertToEntityAttributeZero() throws Exception {
		final Boolean res = AttributeConverterBooleanTest.attrConv
				.convertToEntityAttribute(AttributeConverterBooleanTest.dbDataZero);
		AttributeConverterBooleanTest.LOG.debug("\n\t[Attribute Converter] Byte to Boolean : " + res);
		Assertions.assertFalse(res);
	}

}
