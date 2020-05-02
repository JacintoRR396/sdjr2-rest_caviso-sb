package com.devjr.ca.viso.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.devjr.ca.viso.UtilsTesting;
import com.devjr.ca.viso.domain.Contact;
import com.devjr.ca.viso.entity.ContactEntity;

/**
 * Testea al Convertidor entre el Dominio y el DAO respectp a los Medios de
 * Contacto de una Persona Física/Jurídica o Carrera.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 02/05/2020
 * @modify 02/05/2020
 */
public class ContactResponseConverterTest {

	private ContactEntity objEntity;

	@BeforeEach
	public void setUp() {
		this.objEntity = new ContactEntity(UtilsTesting.ID, UtilsTesting.EMAIL, UtilsTesting.PHONE_MOBILE,
				UtilsTesting.PHONE_HOME);
	}

	@Test
	public void testConvert() throws Exception {
		final Contact obj = new ContactResponseConverter().convert(this.objEntity);
		final boolean res = this.objEntity.getId().equals(obj.getId())
				&& this.objEntity.getEmail().equals(obj.getEmail())
				&& this.objEntity.getPhoneMobile().equals(obj.getPhoneMobile())
				&& this.objEntity.getPhoneHome().equals(obj.getPhoneHome());
		Assertions.assertTrue(res);
	}

	@Test
	public void testConvertWithException() throws Exception {
		Assertions.assertThrows(NullPointerException.class, () -> {
			new ContactResponseConverter().convert(null);
		});
	}

}
