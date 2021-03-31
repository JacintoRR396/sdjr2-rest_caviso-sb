package com.devjr.ca.viso.repository.attrconv;

import java.util.Optional;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.devjr.ca.viso.service.domain.EUserRol;

/**
 * [REPO : Attribute Converter] Mapping from EUserRol to String and viceversa.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 26/03/2021
 * @modify 29/03/2021
 */
@Converter(autoApply = true)
public class AttributeConverterEUserRol implements AttributeConverter<EUserRol, String> {

	private static final Logger LOG = LoggerFactory.getLogger(AttributeConverterEUserRol.class);

	/**
	 * Convert to database column.
	 *
	 * @param attribute the EUserRol
	 * @return the String
	 */
	@Override
	public String convertToDatabaseColumn(final EUserRol attribute) {
		return EUserRol.converterToString(attribute);
	}

	/**
	 * Convert to entity attribute.
	 *
	 * @param dbData the String
	 * @return the EUserRol
	 */
	@Override
	public EUserRol convertToEntityAttribute(final String dbData) {
		final Optional<EUserRol> resOpt = EUserRol.converterFromString(dbData);
		if (resOpt.isPresent()) {
			return resOpt.get();
		} else {
			AttributeConverterEUserRol.LOG.error("[NOT Parse] Name invalid in Database : {}", dbData);
			return null;
		}
	}

}
