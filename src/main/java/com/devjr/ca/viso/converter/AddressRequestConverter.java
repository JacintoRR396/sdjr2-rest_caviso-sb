package com.devjr.ca.viso.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.devjr.ca.viso.domain.Address;
import com.devjr.ca.viso.entity.AddressEntity;
import com.devjr.ca.viso.zutils.UtilsLanguage;

/**
 * Representa al Convertidor entre el DAO y el Dominio respecto a la Dirección
 * de una Persona Física/Jurídica o Carrera.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 03/05/2020
 * @modify 03/05/2020
 */
@Component
public class AddressRequestConverter implements Converter<Address, AddressEntity> {

	private static final Logger LOG = LoggerFactory.getLogger(AddressRequestConverter.class);

	@Override
	public AddressEntity convert(final Address source) {
		try {
			final AddressEntity entity = new AddressEntity();
			entity.setId(source.getId());
			entity.setStreet(source.getStreet());
			entity.setNumber(source.getNumber());
			entity.setTown(source.getTown());
			entity.setCity(source.getCity());
			entity.setCountry(source.getCountry());
			entity.setPostalCode(source.getPostalCode());
			entity.setAdditionalInfo(source.getAdditionalInfo());
			return entity;
		} catch (final NullPointerException e) {
			AddressRequestConverter.LOG.info(UtilsLanguage.MSG_ERROR_CONVERT_TO_ENTITY);
			throw new NullPointerException(UtilsLanguage.MSG_ERROR_CONVERT_TO_ENTITY);
		} catch (final IllegalArgumentException e) {
			AddressRequestConverter.LOG.info(UtilsLanguage.MSG_ERROR_CONVERT_TO_ENTITY);
			throw new IllegalArgumentException(UtilsLanguage.MSG_ERROR_CONVERT_TO_ENTITY);
		}
	}

}
