package com.devjr.ca.viso;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilsTesting {

	/* GENERIC */
	public static final Integer ID = 1;
	public static final Integer ID_AUX = 2;

	/* PERSON */

	/* ADDRESS */
	public static final String STREET = "Corredera";
	public static final String NUMBER = "155A";
	public static final String TOWN = "El Viso del Alcor";
	public static final String CITY = "Sevilla";
	public static final String COUNTRY = "España";
	public static final Integer POSTAL_CODE = 41520;
	public static final String ADDITIONAL_INFO = "Vivo en el piso";

	/* CONTACT */
	public static final String EMAIL = "algo@domain.ext";
	public static final String PHONE_MOBILE = "610972145";
	public static final String PHONE_HOME = "955278768";

	/* SOCIAL MEDIA */

	public static boolean matcherFind(final String regExp, final String value) {
		final Pattern pattern = Pattern.compile(regExp);
		final Matcher matcher = pattern.matcher(value);
		return matcher.find();
	}

	public static boolean matcherMatches(final String regExp, final String value) {
		final Pattern pattern = Pattern.compile(regExp);
		final Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}

}
