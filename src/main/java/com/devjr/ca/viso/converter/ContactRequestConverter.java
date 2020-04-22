package com.devjr.ca.viso.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.devjr.ca.viso.domain.Contact;
import com.devjr.ca.viso.entity.ContactEntity;
import com.devjr.ca.viso.zutils.UtilsLanguage;

/**
 * Representa al Convertidor entre el DAO y el Dominio respectp a los Medios de
 * Contacto de una Persona Física/Jurídica o Carrera.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 18/04/2020
 * @modify 18/04/2020
 */
@Component
public class ContactRequestConverter implements Converter<Contact, ContactEntity> {

	private static final Logger LOG = LoggerFactory.getLogger(ContactRequestConverter.class);

	@Override
	public ContactEntity convert(final Contact source) {
		try {
			final ContactEntity entity = new ContactEntity();
			entity.setId(source.getId());
			entity.setEmail(source.getEmail());
			entity.setPhoneMobile(source.getPhoneMobile());
			entity.setPhoneHome(source.getPhoneHome());
			return entity;
		} catch (final IllegalArgumentException e) {
			ContactRequestConverter.LOG.info(UtilsLanguage.MSG_ERROR_CONVERT_TO_ENTITY);
			return null;
		}
	}

}
