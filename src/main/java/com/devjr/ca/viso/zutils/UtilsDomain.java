package com.devjr.ca.viso.zutils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Representa diversos métodos de ayuda para el Dominio de Datos.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 12/04/2020
 * @modify 12/04/2020
 */
public class UtilsDomain {

	/* CONSTANTES */
	private static Logger LOG = LoggerFactory.getLogger(UtilsDomain.class);
	public static final String S_FORMAT_DATE_FRONT = "dd/MM/yyyy";
	public static final String S_FORMAT_DATE_BACK = "yyyy-MM-dd";

	/* METHODS OF CLASS */
	public static boolean isValidDateFromString(final String value, final Pattern pattern) {
		Boolean bRes = false;
		final Matcher oMatcher = pattern.matcher(value);
		bRes = oMatcher.matches();
		final LocalDate oLocalDate = UtilsDomain.parseStringToLocalDate(value, UtilsDomain.S_FORMAT_DATE_FRONT);
		if (bRes && (oLocalDate != null)) {
			bRes = true;
		} else {
			UtilsDomain.LOG.error("\t La Fecha es posterior al día de hoy o no cumple el patrón '"
					+ UtilsDomain.S_FORMAT_DATE_FRONT + "'.");
			bRes = false;
		}
		return bRes;
	}

	public static LocalDate parseStringToLocalDate(final String value, final String formatter) {
		final DateTimeFormatter oDTFormat = DateTimeFormatter.ofPattern(formatter);
		LocalDate oLocalDate = LocalDate.parse(value, oDTFormat);
		if (oLocalDate.compareTo(LocalDate.now()) > 0) {
			UtilsDomain.LOG.error("\t La Fecha '" + oLocalDate + "' es posterior a '" + LocalDate.now() + "'.");
			oLocalDate = null;
		}
		return oLocalDate;
	}

	public static String parseLocalDateToString(final LocalDate value, final String formatter) {
		String sDate = "";
		final DateTimeFormatter oDTFormat = DateTimeFormatter.ofPattern(formatter);
		try {
			sDate = oDTFormat.format(value);
		} catch (final NullPointerException ex) {
			UtilsDomain.LOG.error("\t NO se ha podido Formatear la Fecha '" + value + "' a Cadena.");
		}
		return sDate;
	}

	public static String capitalizeWord(final String sWord) {
		String sRes = "";
		sRes += Character.toUpperCase(sWord.charAt(0));
		for (int i = 1; i < sWord.length(); i++) {
			sRes += Character.toLowerCase(sWord.charAt(i));
		}
		return sRes;
	}

	private UtilsDomain() {
		throw new IllegalStateException("Utility class");
	}

}