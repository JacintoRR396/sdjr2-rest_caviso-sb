package com.devjr.ca.viso.repository.attrconv;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * [REPO : Attribute Converter] Mapping from Boolean to Byte(Tinyint) and
 * viceversa.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 26/03/2021
 * @modify 31/03/2021
 */
@Converter(autoApply = true)
public class AttributeConverterBoolean implements AttributeConverter<Boolean, Integer> {

	/**
	 * Convert to database column.
	 *
	 * @param attribute the Boolean
	 * @return the Integer
	 */
	@Override
	public Integer convertToDatabaseColumn(final Boolean attribute) {
		return ((Boolean.TRUE.equals(attribute)) ? 1 : 0);
	}

	/**
	 * Convert to entity attribute.
	 *
	 * @param dbData the Integer
	 * @return the Boolean
	 */
	@Override
	public Boolean convertToEntityAttribute(final Integer dbData) {
		return (dbData == 1) ? Boolean.TRUE : Boolean.FALSE;
	}

}
