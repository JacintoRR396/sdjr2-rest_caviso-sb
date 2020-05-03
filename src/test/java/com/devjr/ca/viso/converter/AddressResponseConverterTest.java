package com.devjr.ca.viso.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.devjr.ca.viso.UtilsTesting;
import com.devjr.ca.viso.domain.Address;
import com.devjr.ca.viso.entity.AddressEntity;

/**
 * Testea al Convertidor entre el Dominio y el DAO respecto a la Dirección de
 * una Persona Física/Jurídica o Carrera.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 03/05/2020
 * @modify 03/05/2020
 */
public class AddressResponseConverterTest {

	private AddressEntity objEntity;

	@BeforeEach
	public void setUp() {
		this.objEntity = new AddressEntity(UtilsTesting.ID, UtilsTesting.STREET, UtilsTesting.NUMBER, UtilsTesting.TOWN,
				UtilsTesting.CITY, UtilsTesting.COUNTRY, UtilsTesting.POSTAL_CODE, UtilsTesting.ADDITIONAL_INFO);
	}

	@Test
	public void testConvert() throws Exception {
		final Address obj = new AddressResponseConverter().convert(this.objEntity);
		final boolean res = this.objEntity.getId().equals(obj.getId())
				&& this.objEntity.getStreet().equals(obj.getStreet())
				&& this.objEntity.getNumber().equals(obj.getNumber()) && this.objEntity.getTown().equals(obj.getTown())
				&& this.objEntity.getCity().equals(obj.getCity())
				&& this.objEntity.getCountry().equals(obj.getCountry())
				&& this.objEntity.getPostalCode().equals(obj.getPostalCode())
				&& this.objEntity.getAdditionalInfo().equals(obj.getAdditionalInfo());
		Assertions.assertTrue(res);
	}

	@Test
	public void testConvertWithException() throws Exception {
		Assertions.assertThrows(NullPointerException.class, () -> {
			new AddressResponseConverter().convert(null);
		});
	}

}
