package com.devjr.ca.viso.service.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

/**
 * [SERVICE : Domain] Enumerated representing the roles of a User.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 08/06/2020
 * @modify 29/03/2021
 */
public enum EUserRol {

	USER("Usuario", 1), MEMBER("Miembro", 2), ADMIN("Admin", 3);

	/* VARIABLES */
	private final String name;
	private final Integer code;

	/* CONSTRUCTOR */
	private EUserRol(final String name, final int code) {
		this.name = name;
		this.code = code;
	}

	/* GETTERS AND SETTERS */
	public final String getName() {
		return this.name;
	}

	public final int getCode() {
		return this.code;
	}

	/* METHODS OF CLASSES */
	public static final Comparator<EUserRol> comparatorByCodeASC = (final EUserRol userRol1,
			final EUserRol userRol2) -> userRol1.getCode() - userRol2.getCode();
	public static final Comparator<EUserRol> comparatorByCodeDESC = (final EUserRol userRol1,
			final EUserRol userRol2) -> userRol2.getCode() - userRol1.getCode();

	public static Optional<EUserRol> converterFromString(final String str) {
		return Arrays.asList(EUserRol.values()).stream().filter(euser -> euser.getName().equals(str)).findFirst();
	}

	public static String converterToString(final EUserRol userlRol) {
		return userlRol.getName();
	}

}