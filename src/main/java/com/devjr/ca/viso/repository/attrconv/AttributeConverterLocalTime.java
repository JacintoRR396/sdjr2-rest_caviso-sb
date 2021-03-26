package com.devjr.ca.viso.repository.attrconv;

import java.sql.Time;
import java.time.LocalTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * [REPO : Attribute Converter] Mapping from LocalTime to Time and viceversa.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 25/03/2021
 * @modify 26/03/2021
 */
@Converter(autoApply = true)
public class AttributeConverterLocalTime implements AttributeConverter<LocalTime, Time> {

	private static final Logger LOG = LoggerFactory.getLogger(AttributeConverterLocalTime.class);

	/**
	 * Convert to database column.
	 *
	 * @param attribute the LocalTime
	 * @return the Time
	 */
	@Override
	public Time convertToDatabaseColumn(final LocalTime attribute) {
		try {
			return Time.valueOf(attribute);
		} catch (final NullPointerException e) {
			AttributeConverterLocalTime.LOG.error("[NOT Parse] LocalTime to Time : {}", e.getMessage());
			return null;
		}
	}

	/**
	 * Convert to entity attribute.
	 *
	 * @param dbData the Time
	 * @return the LocalTime
	 */
	@Override
	public LocalTime convertToEntityAttribute(final Time dbData) {
		try {
			return dbData.toLocalTime();
		} catch (final NullPointerException e) {
			AttributeConverterLocalTime.LOG.error("[NOT Parse] Time to LocalTime : {}", e.getMessage());
			return null;
		}
	}

}
