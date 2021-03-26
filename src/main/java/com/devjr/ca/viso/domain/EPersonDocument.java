package com.devjr.ca.viso.domain;

import java.util.Arrays;
import java.util.Optional;

/**
 * Representa el Documento de Identidad de una Persona Jurídica o Física
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 12/04/2020
 * @modify 22/03/2021
 */
public enum EPersonDocument {

	EMPTY, DNI, NIE, CIF;

	/* METHODS OF CLASSES */
	public static boolean equalsEnum(final EPersonDocument ePersonDocument) {
		final Optional<EPersonDocument> opt = Arrays.stream(EPersonDocument.values())
				.filter(epd -> epd.equals(ePersonDocument)).findFirst();
		return opt.isPresent();
	}

}