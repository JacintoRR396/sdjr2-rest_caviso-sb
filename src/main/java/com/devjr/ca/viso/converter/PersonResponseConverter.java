package com.devjr.ca.viso.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.devjr.ca.viso.domain.Person;
import com.devjr.ca.viso.entity.PersonEntity;
import com.devjr.ca.viso.zutils.UtilsDomain;

/**
 * Representa al Convertidor entre el Dominio y el DAO respecto a una Persona
 * Genérica.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 23/04/2020
 * @modify 10/05/2020
 */
@Component
public class PersonResponseConverter implements Converter<PersonEntity, Person> {

	private static final Logger LOG = LoggerFactory.getLogger(PersonResponseConverter.class);

	@Override
	public Person convert(final PersonEntity source) {
		try {
			final String documentType = source.getDocumentType().name();
			final String birthdate = UtilsDomain.parseLocalDateToString(source.getBirthdate(),
					UtilsDomain.S_FORMAT_DATE_FRONT);
			return new Person(source.getId(), documentType, source.getDocumentNumber(), source.getName(),
					source.getSurname(), birthdate, source.getBalance(), source.getPathImage(),
					source.getDescription());
		} catch (final IllegalArgumentException e) {
			// PersonResponseConverter.LOG.info(UtilsLanguage.MSG_ERROR_CONVERT_TO_DOMAIN);
			return null;
		}
	}

}
