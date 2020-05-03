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
import com.devjr.ca.viso.zutils.UtilsRegExp;

/**
 * Testea el Dominio respecto a los Medios de Contacto de una Persona
 * Física/Jurídica o Carrera.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 02/05/2020
 * @modify 02/05/2020
 */
public class ContactTest {

	private static final Logger LOG = LoggerFactory.getLogger(ContactTest.class);

	private Contact obj;
	private Contact objAux;

	@BeforeEach
	public void setUp() {
		this.obj = new Contact(UtilsTesting.ID, UtilsTesting.EMAIL, UtilsTesting.PHONE_MOBILE, UtilsTesting.PHONE_HOME);
		this.objAux = new Contact(UtilsTesting.ID_AUX, UtilsTesting.EMAIL, UtilsTesting.PHONE_MOBILE,
				UtilsTesting.PHONE_HOME);
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
		final Contact objBuilder = new Contact.Builder().withId(this.obj.getId()).withEmail(this.obj.getEmail())
				.withPhoneMobile(this.obj.getPhoneMobile()).withPhoneHome(this.obj.getPhoneHome()).build();
		Assertions.assertEquals(this.obj, objBuilder);
	}

	/* REGULAR EXPRESSION */
	@Test
	@Tag(value = "RegExp")
	@DisplayName(value = "Regular Expression about ID")
	public void testIdRegExp() {
		String valueRegExp = String.valueOf(UtilsTesting.ID);
		Assertions.assertTrue(UtilsTesting.matcherFind(UtilsRegExp.INDEX_REGEX, valueRegExp));
		// less than 1 character
		valueRegExp = "";
		Assertions.assertFalse(UtilsTesting.matcherFind(UtilsRegExp.INDEX_REGEX, valueRegExp));
		// more than 8 characters
		valueRegExp = "123456789";
		Assertions.assertFalse(UtilsTesting.matcherFind(UtilsRegExp.INDEX_REGEX, valueRegExp));
		// with a consonant
		valueRegExp = "235j";
		Assertions.assertFalse(UtilsTesting.matcherFind(UtilsRegExp.INDEX_REGEX, valueRegExp));
	}

	@Test
	@Tag(value = "RegExp")
	@DisplayName(value = "Regular Expression about Email")
	public void testEmailRegExp() {
		String valueRegExp = UtilsTesting.EMAIL;
		Assertions.assertTrue(UtilsTesting.matcherFind(UtilsRegExp.EMAIL_REGEX, valueRegExp));
		// without extension
		valueRegExp = "algo@domain";
		Assertions.assertFalse(UtilsTesting.matcherFind(UtilsRegExp.EMAIL_REGEX, valueRegExp));
		// without domain
		valueRegExp = "algo.ext";
		Assertions.assertFalse(UtilsTesting.matcherFind(UtilsRegExp.EMAIL_REGEX, valueRegExp));
		// with characters not allowed
		valueRegExp = "algoña@domain.ext";
		Assertions.assertFalse(UtilsTesting.matcherFind(UtilsRegExp.EMAIL_REGEX, valueRegExp));
	}

	@Test
	@Tag(value = "RegExp")
	@DisplayName(value = "Regular Expression about Phone Mobile")
	public void testPhoneMobileRegExp() {
		String valueRegExp = UtilsTesting.PHONE_MOBILE;
		Assertions.assertTrue(UtilsTesting.matcherFind(UtilsRegExp.PHONE_MOBILE_REGEX, valueRegExp));
		Assertions.assertTrue(UtilsTesting.matcherFind(UtilsRegExp.PHONE_MOBILE_REGEX, "+34" + valueRegExp));
		// do not start with 6, 7 or 9
		valueRegExp = "555333111";
		Assertions.assertFalse(UtilsTesting.matcherFind(UtilsRegExp.PHONE_MOBILE_REGEX, valueRegExp));
		// with 8 digits
		valueRegExp = "66633311";
		Assertions.assertFalse(UtilsTesting.matcherFind(UtilsRegExp.PHONE_MOBILE_REGEX, valueRegExp));
		// with 10 digits
		valueRegExp = "6663331119";
		Assertions.assertFalse(UtilsTesting.matcherFind(UtilsRegExp.PHONE_MOBILE_REGEX, valueRegExp));
		// don't start with +34
		valueRegExp = "+35666999333";
		Assertions.assertFalse(UtilsTesting.matcherFind(UtilsRegExp.PHONE_MOBILE_REGEX, valueRegExp));
	}

	@Test
	@Tag(value = "RegExp")
	@DisplayName(value = "Regular Expression about Phone Home")
	public void testPhoneHomeRegExp() {
		String valueRegExp = UtilsTesting.PHONE_HOME;
		Assertions.assertTrue(UtilsTesting.matcherFind(UtilsRegExp.PHONE_HOME_REGEX, valueRegExp));
		// do not start with 9
		valueRegExp = "855278768";
		Assertions.assertFalse(UtilsTesting.matcherFind(UtilsRegExp.PHONE_HOME_REGEX, valueRegExp));
		// with 8 digits
		valueRegExp = "95527876";
		Assertions.assertFalse(UtilsTesting.matcherFind(UtilsRegExp.PHONE_HOME_REGEX, valueRegExp));
		// with 10 digits
		valueRegExp = "9552787680";
		Assertions.assertFalse(UtilsTesting.matcherFind(UtilsRegExp.PHONE_HOME_REGEX, valueRegExp));
	}

	/* METHODS OF INSTANCE */
	@Test
	@Tag(value = "MethodsInstance")
	public void testHashCode() {
		int value = this.obj.hashCode();
		ContactTest.LOG.info("testHashCode : " + value);
		Assertions.assertTrue(Boolean.TRUE);
		value = new Contact.Builder().build().hashCode();
		ContactTest.LOG.info("testHashCode : " + value);
		Assertions.assertTrue(Boolean.TRUE);
	}

	@Test
	@Tag(value = "MethodsInstance")
	public void testEquals() {
		final Contact obj = new Contact.Builder().withId(this.obj.getId()).withEmail(this.obj.getEmail())
				.withPhoneMobile(this.obj.getPhoneMobile()).withPhoneHome(this.obj.getPhoneHome()).build();
		Assertions.assertTrue(this.obj.equals(this.obj));
		Assertions.assertTrue(this.obj.equals(obj));
		Assertions.assertFalse(this.obj.equals(1));
		Assertions.assertFalse(this.obj.equals(this.objAux));
	}

	@Test
	@Tag(value = "MethodsInstance")
	public void testToString() {
		ContactTest.LOG.info("testToString : \n" + this.obj);
		Assertions.assertTrue(Boolean.TRUE);
	}

	@Test
	@Tag(value = "MethodsInstance")
	@DisplayName(value = "Compare by Email")
	public void testCompateTo() {
		Assertions.assertTrue(this.obj.compareTo(this.objAux) == 0);
		// is greater compared
		Contact objBuilder = new Contact.Builder().withEmail("aalgo@domain.ext").build();
		Assertions.assertTrue(this.obj.compareTo(objBuilder) > 0);
		// the comparator is greater
		objBuilder = new Contact.Builder().withEmail("zalgo@domain.ext").build();
		Assertions.assertTrue(this.obj.compareTo(objBuilder) < 0);
	}

	@Test
	@Tag(value = "MethodsInstance")
	public void testBuilder() {
		final Contact.Builder objBuilder = this.obj.builder();
		ContactTest.LOG.info("testBuilder : " + objBuilder);
		Assertions.assertTrue(Boolean.TRUE);
	}

	@Test
	@Tag(value = "MethodsInstance")
	public void testJsonAdapter() {
		final String json = Contact.toJsonStr(this.obj);
		final Contact obj = Contact.toObjWebResponse(json);
		ContactTest.LOG.info("testJsonAdapter : \n" + obj);
		Assertions.assertTrue(Boolean.TRUE);
	}

	/* METHODS OF CLASSES */
	@Test
	@Tag(value = "MethodsClasses")
	public void testValueOf() {
		final Contact obj = Contact.valueOf(this.obj);
		// same attribute values
		Assertions.assertTrue(this.obj.equals(obj));
		// different object in memory
		Assertions.assertFalse(this.obj == obj);
	}

	@Test
	@Tag(value = "MethodsClasses")
	@DisplayName(value = "Comparator by Email both ASC and DESC")
	public void testComparatorEmail() {
		final List<Contact> list = new ArrayList<>();
		list.add(this.obj);
		final Contact.Builder objBuilder = this.obj.builder();
		objBuilder.withEmail("zalgo@domain.ext");
		list.add(objBuilder.build());
		// ASC
		Collections.sort(list, Contact.comparatorEmailASC);
		System.out.println(list);
		Assertions.assertTrue(Boolean.TRUE);
		// DESC
		Collections.sort(list, Contact.comparatorEmailDESC);
		System.out.println(list);
		Assertions.assertTrue(Boolean.TRUE);
	}

	@Test
	@Tag(value = "MethodsClasses")
	@DisplayName(value = "Comparator by Phone Mobile both ASC and DESC")
	public void testComparatorPhoneMobile() {
		final List<Contact> list = new ArrayList<>();
		list.add(this.obj);
		final Contact.Builder objBuilder = this.obj.builder();
		objBuilder.withPhoneMobile("666999333");
		list.add(objBuilder.build());
		// ASC
		Collections.sort(list, Contact.comparatorPhoneMobileASC);
		System.out.println(list);
		Assertions.assertTrue(Boolean.TRUE);
		// DESC
		Collections.sort(list, Contact.comparatorPhoneMobileDESC);
		System.out.println(list);
		Assertions.assertTrue(Boolean.TRUE);
	}

}
