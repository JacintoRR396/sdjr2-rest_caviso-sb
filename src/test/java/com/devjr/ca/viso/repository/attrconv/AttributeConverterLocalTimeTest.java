package com.devjr.ca.viso.repository.attrconv;

import java.sql.Time;
import java.time.LocalTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.devjr.ca.viso.UtilsTesting;

/**
 * [REPO : Attribute Converter] Test the Mapping from LocalTime to Time and
 * viceversa.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 26/03/2021
 * @modify 26/03/2021
 */
class AttributeConverterLocalTimeTest {

	private static final Logger LOG = LoggerFactory.getLogger(AttributeConverterLocalTimeTest.class);

	private static LocalTime attribute;
	private static Time dbData;
	private static AttributeConverterLocalTime attrConv = new AttributeConverterLocalTime();

	@BeforeAll
	protected static void setUpBeforeClass() throws Exception {
		AttributeConverterLocalTimeTest.LOG.debug("\n\tStartup All : initializing variables");

		final String str = "08:12:37";
		AttributeConverterLocalTimeTest.attribute = LocalTime.parse(str, UtilsTesting.DT_FORMATTER_LT);
		AttributeConverterLocalTimeTest.dbData = Time.valueOf(str);
	}

	/**
	 * Test convert to database column.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Tag(value = "Methods Instance")
	@DisplayName(value = "Converter LocalTime to Time")
	void testConvertToDatabaseColumn() throws Exception {
		AttributeConverterLocalTimeTest.LOG
				.debug("\n\t[Attribute Converter] LocalTime to Time : " + AttributeConverterLocalTimeTest.attrConv
						.convertToDatabaseColumn(AttributeConverterLocalTimeTest.attribute));
		Assertions.assertTrue(Boolean.TRUE);
	}

	/**
	 * Test convert to database column catching exception.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Tag(value = "Methods Instance")
	@DisplayName(value = "Converter LocalTime to Time catching Exception")
	void testConvertToDatabaseColumnException() throws Exception {
		AttributeConverterLocalTimeTest.LOG.debug("\n\t[Attribute Converter] LocalTime to Time catching Exception : "
				+ AttributeConverterLocalTimeTest.attrConv.convertToDatabaseColumn(null));
		Assertions.assertTrue(Boolean.TRUE);
	}

	/**
	 * Test convert to entity attribute.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Tag(value = "Methods Instance")
	@DisplayName(value = "Converter Time to LocalTime")
	void testConvertToEntityAttribute() throws Exception {
		AttributeConverterLocalTimeTest.LOG
				.debug("\n\t[Attribute Converter] Time to LocalTime : " + AttributeConverterLocalTimeTest.attrConv
						.convertToEntityAttribute(AttributeConverterLocalTimeTest.dbData));
		Assertions.assertTrue(Boolean.TRUE);
	}

	/**
	 * Test convert to entity attribute catching exception.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Tag(value = "Methods Instance")
	@DisplayName(value = "Converter Time to LocalTime catching Exception")
	void testConvertToEntityAttributeException() throws Exception {
		AttributeConverterLocalTimeTest.LOG.debug("\n\t[Attribute Converter] Time to LocalTime catching Exception : "
				+ AttributeConverterLocalTimeTest.attrConv.convertToEntityAttribute(null));
		Assertions.assertTrue(Boolean.TRUE);
	}

}
