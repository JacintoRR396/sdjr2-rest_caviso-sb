package com.devjr.ca.viso.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.devjr.ca.viso.domain.Address;
import com.devjr.ca.viso.domain.Contact;
import com.devjr.ca.viso.domain.PersonComplete;
import com.devjr.ca.viso.entity.PersonCompleteEntity;
import com.devjr.ca.viso.zutils.UtilsDomain;

/**
 * Representa al Convertidor entre el Dominio y el DAO respecto a una Persona.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 23/04/2020
 * @modify 10/05/2020
 */
@Component
public class PersonCompleteResponseConverter implements Converter<PersonCompleteEntity, PersonComplete> {

	private static final Logger LOG = LoggerFactory.getLogger(PersonCompleteResponseConverter.class);

	@Autowired
	private AddressResponseConverter addressResCon;

	@Autowired
	private ContactResponseConverter contactResCon;

	@Override
	public PersonComplete convert(final PersonCompleteEntity source) {
		try {
			final String documentType = source.getDocumentType().name();
			final String birthdate = UtilsDomain.parseLocalDateToString(source.getBirthdate(),
					UtilsDomain.S_FORMAT_DATE_FRONT);
			final Address address = this.addressResCon.convert(source.getAddress());
			final Contact contact = this.contactResCon.convert(source.getContact());
			return new PersonComplete(source.getId(), documentType, source.getDocumentNumber(), source.getName(),
					source.getSurname(), birthdate, source.getBalance(), source.getPathImage(), source.getDescription(),
					address, contact);
		} catch (final IllegalArgumentException e) {
			// PersonCompleteResponseConverter.LOG.info(UtilsLanguage.MSG_ERROR_CONVERT_TO_DOMAIN);
			return null;
		}
	}

}
