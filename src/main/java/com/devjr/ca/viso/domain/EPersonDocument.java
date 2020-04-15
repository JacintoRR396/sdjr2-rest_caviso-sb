package com.devjr.ca.viso.domain;

/**
 * Representa el Documento de Identidad de un Socio (Persona Física)
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 12/04/2020
 * @modify 12/04/2020
 */
public enum EPersonDocument {

	DNI, NIE, CIF;

	/* METHODS OF CLASSES */
	public static boolean equalsEnum(final EPersonDocument category) {
		for (final EPersonDocument ec : EPersonDocument.values()) {
			if (category.equals(ec))
				return true;
		}
		return false;
	}

}