package com.devjr.ca.viso.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.devjr.ca.viso.domain.Contact;
import com.devjr.ca.viso.entity.ContactEntity;

@Component
public class ContactResponseConverter implements Converter<ContactEntity, Contact> {

	@Override
	public Contact convert(final ContactEntity source) {
		return new Contact(source.getId(), source.getEmail(), source.getPhoneMobile(), source.getPhoneHome());
	}

}
