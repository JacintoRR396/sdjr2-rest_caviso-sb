package com.devjr.ca.viso.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.devjr.ca.viso.domain.PersonComplete;
import com.devjr.ca.viso.entity.AddressEntity;
import com.devjr.ca.viso.entity.ContactEntity;
import com.devjr.ca.viso.entity.PersonCompleteEntity;
import com.devjr.ca.viso.zutils.UtilsLanguage;

/**
 * Representa al Convertidor entre el DAO y el Dominio respecto a una Persona.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 23/04/2020
 * @modify 10/05/2020
 */
@Component
public class PersonCompleteRequestConverter implements Converter<PersonComplete, PersonCompleteEntity> {

	private static final Logger LOG = LoggerFactory.getLogger(PersonCompleteRequestConverter.class);

	@Autowired
	private AddressRequestConverter addressReqCon;

	@Autowired
	private ContactRequestConverter contactReqCon;

	@Override
	public PersonCompleteEntity convert(final PersonComplete source) {
		try {
			final PersonCompleteEntity entity = new PersonCompleteEntity();
			entity.setId(source.getId());
			entity.setDocumentType(source.getDocumentType());
			entity.setDocumentNumber(source.getDocumentNumber());
			entity.setName(source.getName());
			entity.setSurname(source.getSurname());
			entity.setBirthdate(source.getBirthdate());
			entity.setBalance(source.getBalance());
			entity.setPathImage(source.getPathImage());
			entity.setDescription(source.getDescription());
			final AddressEntity address = this.addressReqCon.convert(source.getAddress());
			entity.setAddress(address);
			final ContactEntity contact = this.contactReqCon.convert(source.getContact());
			entity.setContact(contact);
			return entity;
		} catch (final IllegalArgumentException e) {
			PersonCompleteRequestConverter.LOG.info(UtilsLanguage.MSG_ERROR_CONVERT_TO_ENTITY);
			return null;
		}
	}

}
