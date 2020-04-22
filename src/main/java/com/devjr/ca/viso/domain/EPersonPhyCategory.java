package com.devjr.ca.viso.domain;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;

import com.devjr.ca.viso.zutils.UtilsDomain;

import javafx.util.StringConverter;

/**
 * Representa la Categoría de un Socio (Persona Física), según su edad.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 12/04/2020
 * @modify 12/04/2020
 */
public enum EPersonPhyCategory implements Comparable<EPersonPhyCategory> {

	PREBENJAMIN("Prebenjamin", 1, 0, 4), MINIBENJAMIN("Minibenjamin", 2, 5, 6), BENJAMIN("Benjamin", 3, 7, 8),
	ALEVIN("Alevin", 4, 9, 10), INFANTIL("Infantil", 5, 11, 12), CADETE("Cadete", 6, 13, 14),
	JUVENIL("Juvenil", 7, 15, 16), JUNIOR("Junior", 8, 17, 18), PROMESA("Promesa", 9, 19, 21),
	SENIOR("Senior", 10, 22, 34), VETERANO("Veterano", 11, 35, 100);

	/* CONSTANTS */
	public static final int I_SIZE_WORD = 50;

	/* VARIABLES */
	private final String name;
	private final Integer code;
	private final Integer minAge;
	private final Integer maxAge;

	/* CONSTRUCTORS */
	private EPersonPhyCategory(final String name, final Integer code, final Integer minAge, final Integer maxAge) {
		this.name = name;
		this.code = code;
		this.minAge = minAge;
		this.maxAge = maxAge;
	}

	/* GETTERS AND SETTERS */
	public final String getName() {
		return this.name;
	}

	public final int getCode() {
		return this.code;
	}

	public int getMinAge() {
		return this.minAge;
	}

	public int getMaxAge() {
		return this.maxAge;
	}

	/* MEHTHODS OF INSTANCE */
	public int compare(final EPersonPhyCategory category1, final EPersonPhyCategory category2) {
		return category1.getCode() - category2.getCode();
	}

	/* METHODS OF CLASSES */
	public static Comparator<EPersonPhyCategory> CodeComparatorASC = (final EPersonPhyCategory category1,
			final EPersonPhyCategory category2) -> category1.getCode() - category2.getCode();

	public static boolean equalsEnum(final EPersonPhyCategory category) {
		for (final EPersonPhyCategory ec : EPersonPhyCategory.values()) {
			if (category.equals(ec))
				return true;
		}
		return false;
	}

	public static EPersonPhyCategory getCategoryByBirthdate(final LocalDate localDateBirthdate) {
		final String birthdate = UtilsDomain.parseLocalDateToString(localDateBirthdate, UtilsDomain.S_FORMAT_DATE_FRONT);
		final String yearNow = new SimpleDateFormat("yyyy").format(new Date());
		final String yearBirth = birthdate.substring(birthdate.length() - 4);
		final int age = Integer.parseInt(yearNow) - Integer.parseInt(yearBirth);
		if ((age >= EPersonPhyCategory.PREBENJAMIN.getMinAge()) && (age <= EPersonPhyCategory.PREBENJAMIN.getMaxAge()))
			return EPersonPhyCategory.PREBENJAMIN;
		if ((age >= EPersonPhyCategory.MINIBENJAMIN.getMinAge())
				&& (age <= EPersonPhyCategory.MINIBENJAMIN.getMaxAge()))
			return EPersonPhyCategory.MINIBENJAMIN;
		if ((age >= EPersonPhyCategory.BENJAMIN.getMinAge()) && (age <= EPersonPhyCategory.BENJAMIN.getMaxAge()))
			return EPersonPhyCategory.BENJAMIN;
		if ((age >= EPersonPhyCategory.ALEVIN.getMinAge()) && (age <= EPersonPhyCategory.ALEVIN.getMaxAge()))
			return EPersonPhyCategory.ALEVIN;
		if ((age >= EPersonPhyCategory.INFANTIL.getMinAge()) && (age <= EPersonPhyCategory.INFANTIL.getMaxAge()))
			return EPersonPhyCategory.INFANTIL;
		if ((age >= EPersonPhyCategory.CADETE.getMinAge()) && (age <= EPersonPhyCategory.CADETE.getMaxAge()))
			return EPersonPhyCategory.CADETE;
		if ((age >= EPersonPhyCategory.JUVENIL.getMinAge()) && (age <= EPersonPhyCategory.JUVENIL.getMaxAge()))
			return EPersonPhyCategory.JUVENIL;
		if ((age >= EPersonPhyCategory.JUNIOR.getMinAge()) && (age <= EPersonPhyCategory.JUNIOR.getMaxAge()))
			return EPersonPhyCategory.JUNIOR;
		if ((age >= EPersonPhyCategory.PROMESA.getMinAge()) && (age <= EPersonPhyCategory.PROMESA.getMaxAge()))
			return EPersonPhyCategory.PROMESA;
		if ((age >= EPersonPhyCategory.SENIOR.getMinAge()) && (age <= EPersonPhyCategory.SENIOR.getMaxAge()))
			return EPersonPhyCategory.SENIOR;
		else
			return EPersonPhyCategory.VETERANO;
	}

	public static StringConverter<EPersonPhyCategory> createEnumStringConverter() {
		return new StringConverter<EPersonPhyCategory>() {
			@Override
			public String toString(final EPersonPhyCategory object) {
				return object.getName();
			}

			@Override
			public EPersonPhyCategory fromString(final String string) {
				return EPersonPhyCategory.valueOf(string.toUpperCase());
			}
		};
	}

}