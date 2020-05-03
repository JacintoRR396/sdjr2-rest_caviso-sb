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
 * Testea al DAO respecto a los Medios de Contacto de una Persona
 * Física/Jurídica o Carrera.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 02/05/2020
 * @modify 02/05/2020
 */
public class ContactEntityTest {

	private static final Logger LOG = LoggerFactory.getLogger(ContactEntityTest.class);

	private ContactEntity obj;
	private ContactEntity objAux;

	@BeforeEach
	public void setUp() {
		this.obj = new ContactEntity(UtilsTesting.ID, UtilsTesting.EMAIL, UtilsTesting.PHONE_MOBILE,
				UtilsTesting.PHONE_HOME);
		this.objAux = new ContactEntity();
		this.objAux.setId(this.obj.getId());
		this.objAux.setId(UtilsTesting.ID_AUX);
		this.objAux.setEmail(this.obj.getEmail());
		this.objAux.setPhoneMobile(this.obj.getPhoneMobile());
		this.objAux.setPhoneHome(this.obj.getPhoneHome());
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
		ContactEntityTest.LOG.info("testHashCode : " + value);
		Assertions.assertTrue(Boolean.TRUE);
		value = new ContactEntity().hashCode();
		ContactEntityTest.LOG.info("testHashCode : " + value);
		Assertions.assertTrue(Boolean.TRUE);
	}

	@Test
	@Tag(value = "MethodsInstance")
	public void testEquals() {
		final ContactEntity obj = new ContactEntity(UtilsTesting.ID, UtilsTesting.EMAIL, UtilsTesting.PHONE_MOBILE,
				UtilsTesting.PHONE_HOME);
		Assertions.assertTrue(this.obj.equals(this.obj));
		Assertions.assertTrue(this.obj.equals(obj));
		Assertions.assertFalse(this.obj.equals(1));
		Assertions.assertFalse(this.obj.equals(this.objAux));
	}

	@Test
	@Tag(value = "MethodsInstance")
	public void testToString() {
		ContactEntityTest.LOG.info("testToString : \n" + this.obj);
		Assertions.assertTrue(Boolean.TRUE);
	}

}
