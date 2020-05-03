package com.devjr.ca.viso.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.devjr.ca.viso.UtilsTesting;
import com.devjr.ca.viso.domain.Contact;
import com.devjr.ca.viso.entity.ContactEntity;

/**
 * Testea al Convertidor entre el DAO y el Dominio respectp a los Medios de
 * Contacto de una Persona Física/Jurídica o Carrera.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 02/05/2020
 * @modify 02/05/2020
 */
public class ContactRequestConverterTest {

	private Contact obj;

	@BeforeEach
	public void setUp() {
		this.obj = new Contact(UtilsTesting.ID, UtilsTesting.EMAIL, UtilsTesting.PHONE_MOBILE, UtilsTesting.PHONE_HOME);
	}

	@Test
	public void testConvert() throws Exception {
		final ContactEntity objEntity = new ContactRequestConverter().convert(this.obj);
		final boolean res = this.obj.getId().equals(objEntity.getId())
				&& this.obj.getEmail().equals(objEntity.getEmail())
				&& this.obj.getPhoneMobile().equals(objEntity.getPhoneMobile())
				&& this.obj.getPhoneHome().equals(objEntity.getPhoneHome());
		Assertions.assertTrue(res);
	}

	@Test
	public void testConvertWithException() throws Exception {
		Assertions.assertThrows(NullPointerException.class, () -> {
			new ContactRequestConverter().convert(null);
		});
	}

}
