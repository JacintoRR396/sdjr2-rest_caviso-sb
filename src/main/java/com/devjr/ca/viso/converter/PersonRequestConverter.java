package com.devjr.ca.viso.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.devjr.ca.viso.domain.Person;
import com.devjr.ca.viso.entity.PersonEntity;
import com.devjr.ca.viso.zutils.UtilsLanguage;

/**
 * Representa al Convertidor entre el DAO y el Dominio respecto a una Persona
 * Genérica.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 23/04/2020
 * @modify 10/05/2020
 */
@Component
public class PersonRequestConverter implements Converter<Person, PersonEntity> {

	private static final Logger LOG = LoggerFactory.getLogger(PersonRequestConverter.class);

	@Override
	public PersonEntity convert(final Person source) {
		try {
			final PersonEntity entity = new PersonEntity();
			entity.setId(source.getId());
			entity.setDocumentType(source.getDocumentType());
			entity.setDocumentNumber(source.getDocumentNumber());
			entity.setName(source.getName());
			entity.setSurname(source.getSurname());
			entity.setBirthdate(source.getBirthdate());
			entity.setBalance(source.getBalance());
			entity.setPathImage(source.getPathImage());
			entity.setDescription(source.getDescription());
			return entity;
		} catch (final IllegalArgumentException e) {
			PersonRequestConverter.LOG.info(UtilsLanguage.MSG_ERROR_CONVERT_TO_ENTITY);
			return null;
		}
	}

}
