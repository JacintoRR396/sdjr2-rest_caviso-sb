package com.devjr.ca.viso.repository.attrconv;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * [REPO : Attribute Converter] Mapping from LocalDate to Date and viceversa.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 25/03/2021
 * @modify 26/03/2021
 */
@Converter(autoApply = true)
public class AttributeConverterLocalDate implements AttributeConverter<LocalDate, Date> {

	private static final Logger LOG = LoggerFactory.getLogger(AttributeConverterLocalDate.class);

	/**
	 * Convert to database column.
	 *
	 * @param attribute the LocalDate
	 * @return the Date
	 */
	@Override
	public Date convertToDatabaseColumn(final LocalDate attribute) {
		try {
			return Date.valueOf(attribute);
		} catch (final NullPointerException e) {
			AttributeConverterLocalDate.LOG.error("[NOT Parse] LocalDate to Date : {}", e.getMessage());
			return null;
		}
	}

	/**
	 * Convert to entity attribute.
	 *
	 * @param dbData the Date
	 * @return the LocalDate
	 */
	@Override
	public LocalDate convertToEntityAttribute(final Date dbData) {
		try {
			return dbData.toLocalDate();
		} catch (final NullPointerException e) {
			AttributeConverterLocalDate.LOG.error("[NOT Parse] Date to LocalDate : {}", e.getMessage());
			return null;
		}
	}

}
