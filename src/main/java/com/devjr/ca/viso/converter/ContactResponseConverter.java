package com.devjr.ca.viso.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.devjr.ca.viso.domain.Contact;
import com.devjr.ca.viso.entity.ContactEntity;
import com.devjr.ca.viso.zutils.UtilsLanguage;

/**
 * Representa al Convertidor entre el Dominio y el DAO respectp a los Medios de
 * Contacto de una Persona Física/Jurídica o Carrera.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 18/04/2020
 * @modify 18/04/2020
 */
@Component
public class ContactResponseConverter implements Converter<ContactEntity, Contact> {

	private static final Logger LOG = LoggerFactory.getLogger(ContactResponseConverter.class);

	@Override
	public Contact convert(final ContactEntity source) {
		try {
			return new Contact(source.getId(), source.getEmail(), source.getPhoneMobile(), source.getPhoneHome());
		} catch (final IllegalArgumentException | NullPointerException e) {
			ContactResponseConverter.LOG.info(UtilsLanguage.MSG_ERROR_CONVERT_TO_DOMAIN);
			return null;
		}
	}

}
