package com.devjr.ca.viso.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.devjr.ca.viso.domain.Contact;
import com.devjr.ca.viso.entity.ContactEntity;

@Component
public class ContactRequestConverter implements Converter<Contact, ContactEntity> {

	@Override
	public ContactEntity convert(final Contact source) {
		final ContactEntity entity = new ContactEntity();
		entity.setId(source.getId());
		entity.setEmail(source.getEmail());
		entity.setTlfMovil(source.getTlfMovil());
		entity.setTlfHome(source.getTlfHome());
		return entity;
	}

}
