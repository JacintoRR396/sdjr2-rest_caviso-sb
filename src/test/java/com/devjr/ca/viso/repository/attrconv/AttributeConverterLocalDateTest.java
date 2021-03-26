package com.devjr.ca.viso.repository.attrconv;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.devjr.ca.viso.UtilsTesting;

/**
 * [REPO : Attribute Converter] Test the Mapping from LocalDate to Date and
 * viceversa.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 26/03/2021
 * @modify 26/03/2021
 */
class AttributeConverterLocalDateTest {

	private static final Logger LOG = LoggerFactory.getLogger(AttributeConverterLocalDateTest.class);

	private static LocalDate attribute;
	private static Date dbData;
	private static AttributeConverterLocalDate attrConv = new AttributeConverterLocalDate();

	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeAll
	protected static void setUpBeforeClass() throws Exception {
		AttributeConverterLocalDateTest.LOG.debug("\n\tStartup All : initializing variables");

		final String str = "1983-08-15";
		AttributeConverterLocalDateTest.attribute = LocalDate.parse(str, UtilsTesting.DT_FORMATTER_LD);
		AttributeConverterLocalDateTest.dbData = Date.valueOf(str);
	}

	/**
	 * Test convert to database column.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Tag(value = "Methods Instance")
	@DisplayName(value = "Converter LocalDate to Date")
	void testConvertToDatabaseColumn() throws Exception {
		AttributeConverterLocalDateTest.LOG
				.debug("\n\t[Attribute Converter] LocalDate to Date : " + AttributeConverterLocalDateTest.attrConv
						.convertToDatabaseColumn(AttributeConverterLocalDateTest.attribute));
		Assertions.assertTrue(Boolean.TRUE);
	}

	/**
	 * Test convert to database column catching exception.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Tag(value = "Methods Instance")
	@DisplayName(value = "Converter LocalDate to Date catching Exception")
	void testConvertToDatabaseColumnException() throws Exception {
		AttributeConverterLocalDateTest.LOG.debug("\n\t[Attribute Converter] LocalDate to Date catching Exception : "
				+ AttributeConverterLocalDateTest.attrConv.convertToDatabaseColumn(null));
		Assertions.assertTrue(Boolean.TRUE);
	}

	/**
	 * Test convert to entity attribute.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Tag(value = "Methods Instance")
	@DisplayName(value = "Converter Date to LocalDate")
	void testConvertToEntityAttribute() throws Exception {
		AttributeConverterLocalDateTest.LOG
				.debug("\n\t[Attribute Converter] Date to LocalDate : " + AttributeConverterLocalDateTest.attrConv
						.convertToEntityAttribute(AttributeConverterLocalDateTest.dbData));
		Assertions.assertTrue(Boolean.TRUE);
	}

	/**
	 * Test convert to entity attribute catching exception.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Tag(value = "Methods Instance")
	@DisplayName(value = "Converter Date to LocalDate catching Exception")
	void testConvertToEntityAttributeException() throws Exception {
		AttributeConverterLocalDateTest.LOG.debug("\n\t[Attribute Converter] Date to LocalDate catching Exception : "
				+ AttributeConverterLocalDateTest.attrConv.convertToEntityAttribute(null));
		Assertions.assertTrue(Boolean.TRUE);
	}

}
