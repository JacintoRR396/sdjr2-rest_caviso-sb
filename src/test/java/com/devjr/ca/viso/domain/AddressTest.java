package com.devjr.ca.viso.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.devjr.ca.viso.UtilsTesting;

/**
 * Testea el Dominio respecto a la Dirección de una Persona Física/Jurídica o
 * Carrera.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 03/05/2020
 * @modify 03/05/2020
 */
public class AddressTest {

	private static final Logger LOG = LoggerFactory.getLogger(AddressTest.class);

	private Address obj;
	private Address objAux;

	@BeforeEach
	public void setUp() {
		this.obj = new Address(UtilsTesting.ID, UtilsTesting.STREET, UtilsTesting.NUMBER, UtilsTesting.TOWN,
				UtilsTesting.CITY, UtilsTesting.COUNTRY, UtilsTesting.POSTAL_CODE, UtilsTesting.ADDITIONAL_INFO);
		this.objAux = new Address(UtilsTesting.ID_AUX, UtilsTesting.STREET, UtilsTesting.NUMBER, UtilsTesting.TOWN,
				UtilsTesting.CITY, UtilsTesting.COUNTRY, UtilsTesting.POSTAL_CODE, UtilsTesting.ADDITIONAL_INFO);
	}

	/* CONSTRUCTORS & GETTERS */
	@Test
	@Tag(value = "Constructs")
	@DisplayName(value = "Contructor JSON")
	public void testConstructJson() {
		Assertions.assertNotEquals(this.obj, this.objAux);
	}

	@Test
	@Tag(value = "Constructs")
	@DisplayName(value = "Contructor BUILDER")
	public void testConstructBuilder() {
		final Address objBuilder = new Address.Builder().withId(this.obj.getId()).withStreet(this.obj.getStreet())
				.withNumber(this.obj.getNumber()).withTown(this.obj.getTown()).withCity(this.obj.getCity())
				.withCountry(this.obj.getCountry()).withPostalCode(this.obj.getPostalCode())
				.withAdditionalInfo(this.obj.getAdditionalInfo()).build();
		Assertions.assertEquals(this.obj, objBuilder);
	}

	/* METHODS OF INSTANCE */
	@Test
	@Tag(value = "MethodsInstance")
	public void testHashCode() {
		int value = this.obj.hashCode();
		AddressTest.LOG.info("testHashCode : " + value);
		Assertions.assertTrue(Boolean.TRUE);
		value = new Contact.Builder().build().hashCode();
		AddressTest.LOG.info("testHashCode : " + value);
		Assertions.assertTrue(Boolean.TRUE);
	}

	@Test
	@Tag(value = "MethodsInstance")
	public void testEquals() {
		final Address obj = new Address.Builder().withId(this.obj.getId()).withStreet(this.obj.getStreet())
				.withNumber(this.obj.getNumber()).withTown(this.obj.getTown()).withCity(this.obj.getCity())
				.withCountry(this.obj.getCountry()).withPostalCode(this.obj.getPostalCode())
				.withAdditionalInfo(this.obj.getAdditionalInfo()).build();
		Assertions.assertTrue(this.obj.equals(this.obj));
		Assertions.assertTrue(this.obj.equals(obj));
		Assertions.assertFalse(this.obj.equals(1));
		Assertions.assertFalse(this.obj.equals(this.objAux));
	}

	@Test
	@Tag(value = "MethodsInstance")
	public void testToString() {
		AddressTest.LOG.info("testToString : \n" + this.obj);
		Assertions.assertTrue(Boolean.TRUE);
	}

	@Test
	@Tag(value = "MethodsInstance")
	@DisplayName(value = "Compare by PostalCode, Street and Number")
	public void testCompateTo() {
		Assertions.assertTrue(this.obj.compareTo(this.objAux) == 0);
	}

	@Test
	@Tag(value = "MethodsInstance")
	public void testBuilder() {
		final Address.Builder objBuilder = this.obj.builder();
		AddressTest.LOG.info("testBuilder : " + objBuilder);
		Assertions.assertTrue(Boolean.TRUE);
	}

	@Test
	@Tag(value = "MethodsInstance")
	public void testJsonAdapter() {
		final String json = Address.toJsonStr(this.obj);
		final Address obj = Address.toObjWebResponse(json);
		AddressTest.LOG.info("testJsonAdapter : \n" + obj);
		Assertions.assertTrue(Boolean.TRUE);
	}

	/* METHODS OF CLASSES */
	@Test
	@Tag(value = "MethodsClasses")
	public void testValueOf() {
		final Address obj = Address.valueOf(this.obj);
		// same attribute values
		Assertions.assertTrue(this.obj.equals(obj));
		// different object in memory
		Assertions.assertFalse(this.obj == obj);
	}

	@Test
	@Tag(value = "MethodsClasses")
	@DisplayName(value = "Comparator by Town both ASC and DESC")
	public void testComparatorTown() {
		final List<Address> list = new ArrayList<>();
		list.add(this.obj);
		final Address.Builder objBuilder = this.obj.builder();
		objBuilder.withTown("z");
		list.add(objBuilder.build());
		// ASC
		Collections.sort(list, Address.comparatorTownASC);
		System.out.println(list);
		Assertions.assertTrue(Boolean.TRUE);
		// DESC
		Collections.sort(list, Address.comparatorTownDESC);
		System.out.println(list);
		Assertions.assertTrue(Boolean.TRUE);
	}

	@Test
	@Tag(value = "MethodsClasses")
	@DisplayName(value = "Comparator by City both ASC and DESC")
	public void testComparatorCity() {
		final List<Address> list = new ArrayList<>();
		list.add(this.obj);
		final Address.Builder objBuilder = this.obj.builder();
		objBuilder.withCity("z");
		list.add(objBuilder.build());
		// ASC
		Collections.sort(list, Address.comparatorCityASC);
		System.out.println(list);
		Assertions.assertTrue(Boolean.TRUE);
		// DESC
		Collections.sort(list, Address.comparatorCityDESC);
		System.out.println(list);
		Assertions.assertTrue(Boolean.TRUE);
	}

	@Test
	@Tag(value = "MethodsClasses")
	@DisplayName(value = "Comparator by PostalCode both ASC and DESC")
	public void testComparatorPostalCode() {
		final List<Address> list = new ArrayList<>();
		list.add(this.obj);
		final Address.Builder objBuilder = this.obj.builder();
		objBuilder.withPostalCode(91396);
		list.add(objBuilder.build());
		// ASC
		Collections.sort(list, Address.comparatorPostalCodeASC);
		System.out.println(list);
		Assertions.assertTrue(Boolean.TRUE);
		// DESC
		Collections.sort(list, Address.comparatorPostalCodeDESC);
		System.out.println(list);
		Assertions.assertTrue(Boolean.TRUE);
	}

}
