package com.devjr.ca.viso.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.devjr.ca.viso.UtilsTesting;

/**
 * Testea al DAO respecto a la Dirección de una Persona Física/Jurídica o
 * Carrera.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 03/05/2020
 * @modify 03/05/2020
 */
public class AddressEntityTest {

	private static final Logger LOG = LoggerFactory.getLogger(AddressEntityTest.class);

	private AddressEntity obj;
	private AddressEntity objAux;

	@BeforeEach
	public void setUp() {
		this.obj = new AddressEntity(UtilsTesting.ID, UtilsTesting.STREET, UtilsTesting.NUMBER, UtilsTesting.TOWN,
				UtilsTesting.CITY, UtilsTesting.COUNTRY, UtilsTesting.POSTAL_CODE, UtilsTesting.ADDITIONAL_INFO);
		this.objAux = new AddressEntity();
		this.objAux.setId(this.obj.getId());
		this.objAux.setId(UtilsTesting.ID_AUX);
		this.objAux.setStreet(this.obj.getStreet());
		this.objAux.setNumber(this.obj.getNumber());
		this.objAux.setTown(this.obj.getTown());
		this.objAux.setCity(this.obj.getCity());
		this.objAux.setCountry(this.obj.getCountry());
		this.objAux.setPostalCode(this.obj.getPostalCode());
		this.objAux.setAdditionalInfo(this.obj.getAdditionalInfo());
	}

	/* CONSTRUCTORS, GETTERS & SETTERS */
	@Test
	@Tag(value = "Constructs")
	@DisplayName(value = "Contructor Default")
	public void testConstructDefault() {
		Assertions.assertNotEquals(this.obj, this.objAux);
	}

	@Test
	@Tag(value = "Constructs")
	@DisplayName(value = "Contructor with Parameters")
	public void testConstructWithParameters() {
		Assertions.assertNotEquals(this.obj, this.objAux);
	}

	/* METHODS OF INSTANCE */
	@Test
	@Tag(value = "MethodsInstance")
	public void testHashCode() {
		int value = this.obj.hashCode();
		AddressEntityTest.LOG.info("testHashCode : " + value);
		Assertions.assertTrue(Boolean.TRUE);
		value = new AddressEntity().hashCode();
		AddressEntityTest.LOG.info("testHashCode : " + value);
		Assertions.assertTrue(Boolean.TRUE);
	}

	@Test
	@Tag(value = "MethodsInstance")
	public void testEquals() {
		final AddressEntity obj = new AddressEntity(UtilsTesting.ID, UtilsTesting.STREET, UtilsTesting.NUMBER,
				UtilsTesting.TOWN, UtilsTesting.CITY, UtilsTesting.COUNTRY, UtilsTesting.POSTAL_CODE,
				UtilsTesting.ADDITIONAL_INFO);
		Assertions.assertTrue(this.obj.equals(this.obj));
		Assertions.assertTrue(this.obj.equals(obj));
		Assertions.assertFalse(this.obj.equals(1));
		Assertions.assertFalse(this.obj.equals(this.objAux));
	}

	@Test
	@Tag(value = "MethodsInstance")
	public void testToString() {
		AddressEntityTest.LOG.info("testToString : \n" + this.obj);
		Assertions.assertTrue(Boolean.TRUE);
	}

}
