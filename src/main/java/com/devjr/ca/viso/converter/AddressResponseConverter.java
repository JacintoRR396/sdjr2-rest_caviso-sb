package com.devjr.ca.viso.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.devjr.ca.viso.domain.Address;
import com.devjr.ca.viso.entity.AddressEntity;
import com.devjr.ca.viso.zutils.UtilsLanguage;

/**
 * Representa al Convertidor entre el Dominio y el DAO respecto a la Dirección
 * de una Persona Física/Jurídica o Carrera.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 03/05/2020
 * @modify 03/05/2020
 */
@Component
public class AddressResponseConverter implements Converter<AddressEntity, Address> {

	private static final Logger LOG = LoggerFactory.getLogger(AddressResponseConverter.class);

	@Override
	public Address convert(final AddressEntity source) {
		try {
			return new Address(source.getId(), source.getStreet(), source.getNumber(), source.getTown(),
					source.getCity(), source.getCountry(), source.getPostalCode(), source.getAdditionalInfo());
		} catch (final NullPointerException e) {
			// AddressResponseConverter.LOG.info(UtilsLanguage.MSG_ERROR_CONVERT_TO_DOMAIN);
			throw new NullPointerException(UtilsLanguage.MSG_ERROR_CONVERT_FROM_DOMAIN_TO_ENTITY);
		} catch (final IllegalArgumentException e) {
			// AddressResponseConverter.LOG.info(UtilsLanguage.MSG_ERROR_CONVERT_TO_DOMAIN);
			throw new IllegalArgumentException(UtilsLanguage.MSG_ERROR_CONVERT_FROM_DOMAIN_TO_ENTITY);
		}
	}

}
