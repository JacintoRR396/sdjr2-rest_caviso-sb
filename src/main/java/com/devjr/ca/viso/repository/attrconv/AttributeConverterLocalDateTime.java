package com.devjr.ca.viso.repository.attrconv;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * [REPO : Attribute Converter] Mapping from LocalDateTime to Timestamp and
 * viceversa.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 25/03/2021
 * @modify 26/03/2021
 */
@Converter(autoApply = true)
public class AttributeConverterLocalDateTime implements AttributeConverter<LocalDateTime, Timestamp> {

	private static final Logger LOG = LoggerFactory.getLogger(AttributeConverterLocalDateTime.class);

	/**
	 * Convert to database column.
	 *
	 * @param attribute the LocalDateTime
	 * @return the Timestamp
	 */
	@Override
	public Timestamp convertToDatabaseColumn(final LocalDateTime attribute) {
		try {
			return Timestamp.valueOf(attribute);
		} catch (final NullPointerException e) {
			AttributeConverterLocalDateTime.LOG.error("\n\t[NOT Parse] LocalDateTime to Timestamp : {}",
					e.getMessage());
			return null;
		}
	}

	/**
	 * Convert to entity attribute.
	 *
	 * @param dbData the Timestamp
	 * @return the LocalDateTime
	 */
	@Override
	public LocalDateTime convertToEntityAttribute(final Timestamp dbData) {
		try {
			return dbData.toLocalDateTime();
		} catch (final NullPointerException e) {
			AttributeConverterLocalDateTime.LOG.error("\n\t[NOT Parse] Timestamp to LocalDateTime : {}",
					e.getMessage());
			return null;
		}
	}

}
