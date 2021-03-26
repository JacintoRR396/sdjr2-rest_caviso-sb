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
 * @modify 26/03/2021
 */
@Converter(autoApply = true)
public class AttributeConverterBoolean implements AttributeConverter<Boolean, Byte> {

	/**
	 * Convert to database column.
	 *
	 * @param attribute the Boolean
	 * @return the Byte
	 */
	@Override
	public Byte convertToDatabaseColumn(final Boolean attribute) {
		return (byte) ((Boolean.TRUE.equals(attribute)) ? 1 : 0);
	}

	/**
	 * Convert to entity attribute.
	 *
	 * @param dbData the Byte
	 * @return the Boolean
	 */
	@Override
	public Boolean convertToEntityAttribute(final Byte dbData) {
		return (dbData == 1) ? Boolean.TRUE : Boolean.FALSE;
	}

}
