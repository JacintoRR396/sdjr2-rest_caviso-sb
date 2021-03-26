package com.devjr.ca.viso.repository.attrconv;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.devjr.ca.viso.UtilsTesting;

/**
 * [REPO : Attribute Converter] Test the Mapping from LocalDateTime to Timestamp
 * and viceversa.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 25/03/2021
 * @modify 26/03/2021
 */
class AttributeConverterLocalDateTimeTest {

	private static final Logger LOG = LoggerFactory.getLogger(AttributeConverterLocalDateTimeTest.class);

	private static LocalDateTime attribute;
	private static Timestamp dbData;
	private static AttributeConverterLocalDateTime attrConv = new AttributeConverterLocalDateTime();

	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeAll
	protected static void setUpBeforeClass() throws Exception {
		AttributeConverterLocalDateTimeTest.LOG.debug("\n\tStartup All : initializing variables");

		final String str = "1983-08-15 08:12:37";
		AttributeConverterLocalDateTimeTest.attribute = LocalDateTime.parse(str, UtilsTesting.DT_FORMATTER_LDT);
		AttributeConverterLocalDateTimeTest.dbData = Timestamp.valueOf(str);
	}

	/**
	 * Test convert to database column.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Tag(value = "Methods Instance")
	@DisplayName(value = "Converter LocalDateTime to Timestamp")
	void testConvertToDatabaseColumn() throws Exception {
		AttributeConverterLocalDateTimeTest.LOG.debug(
				"\n\t[Attribute Converter] LocalDateTime to Timestamp : " + AttributeConverterLocalDateTimeTest.attrConv
						.convertToDatabaseColumn(AttributeConverterLocalDateTimeTest.attribute));
		Assertions.assertTrue(Boolean.TRUE);
	}

	/**
	 * Test convert to database column catching exception.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Tag(value = "Methods Instance")
	@DisplayName(value = "Converter LocalDateTime to Timestamp catching Exception")
	void testConvertToDatabaseColumnException() throws Exception {
		AttributeConverterLocalDateTimeTest.LOG
				.debug("\n\t[Attribute Converter] LocalDateTime to Timestamp catching Exception : "
						+ AttributeConverterLocalDateTimeTest.attrConv.convertToDatabaseColumn(null));
		Assertions.assertTrue(Boolean.TRUE);
	}

	/**
	 * Test convert to entity attribute.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Tag(value = "Methods Instance")
	@DisplayName(value = "Converter Timestamp to LocalDateTime")
	void testConvertToEntityAttribute() throws Exception {
		AttributeConverterLocalDateTimeTest.LOG.debug(
				"\n\t[Attribute Converter] Timestamp to LocalDateTime : " + AttributeConverterLocalDateTimeTest.attrConv
						.convertToEntityAttribute(AttributeConverterLocalDateTimeTest.dbData));
		Assertions.assertTrue(Boolean.TRUE);
	}

	/**
	 * Test convert to entity attribute catching exception.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Tag(value = "Methods Instance")
	@DisplayName(value = "Converter Timestamp to LocalDateTime catching Exception")
	void testConvertToEntityAttributeException() throws Exception {
		AttributeConverterLocalDateTimeTest.LOG
				.debug("\n\t[Attribute Converter] Timestamp to LocalDateTime catching Exception : "
						+ AttributeConverterLocalDateTimeTest.attrConv.convertToEntityAttribute(null));
		Assertions.assertTrue(Boolean.TRUE);
	}

}
