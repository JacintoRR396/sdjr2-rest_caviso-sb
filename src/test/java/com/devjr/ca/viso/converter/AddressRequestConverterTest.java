package com.devjr.ca.viso.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.devjr.ca.viso.UtilsTesting;
import com.devjr.ca.viso.domain.Address;
import com.devjr.ca.viso.entity.AddressEntity;

/**
 * Testea al Convertidor entre el DAO y el Dominio respecto a la Dirección de
 * una Persona Física/Jurídica o Carrera.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 03/05/2020
 * @modify 03/05/2020
 */
public class AddressRequestConverterTest {

	private Address obj;

	@BeforeEach
	public void setUp() {
		this.obj = new Address(UtilsTesting.ID, UtilsTesting.STREET, UtilsTesting.NUMBER, UtilsTesting.TOWN,
				UtilsTesting.CITY, UtilsTesting.COUNTRY, UtilsTesting.POSTAL_CODE, UtilsTesting.ADDITIONAL_INFO);
	}

	@Test
	public void testConvert() throws Exception {
		final AddressEntity objEntity = new AddressRequestConverter().convert(this.obj);
		final boolean res = this.obj.getId().equals(objEntity.getId())
				&& this.obj.getStreet().equals(objEntity.getStreet())
				&& this.obj.getNumber().equals(objEntity.getNumber()) && this.obj.getTown().equals(objEntity.getTown())
				&& this.obj.getCity().equals(objEntity.getCity())
				&& this.obj.getCountry().equals(objEntity.getCountry())
				&& this.obj.getPostalCode().equals(objEntity.getPostalCode())
				&& this.obj.getAdditionalInfo().equals(objEntity.getAdditionalInfo());
		Assertions.assertTrue(res);
	}

	@Test
	public void testConvertWithException() throws Exception {
		Assertions.assertThrows(NullPointerException.class, () -> {
			new AddressRequestConverter().convert(null);
		});
	}

}
