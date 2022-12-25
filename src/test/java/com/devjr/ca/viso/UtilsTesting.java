package com.devjr.ca.viso;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.devjr.ca.viso.service.domain.EUserRol;

public class UtilsTesting {

	/* GENERIC */
	public static final Integer ID = 1;
	public static final Integer ID_AUX = 2;

	public static final String FORMAT_LD = "yyyy-MM-dd";
	public static final DateTimeFormatter DT_FORMATTER_LD = DateTimeFormatter.ofPattern(UtilsTesting.FORMAT_LD);
	public static final String FORMAT_LT = "HH:mm:ss";
	public static final DateTimeFormatter DT_FORMATTER_LT = DateTimeFormatter.ofPattern(UtilsTesting.FORMAT_LT);
	public static final String FORMAT_LDT = "yyyy-MM-dd HH:mm:ss";
	public static final DateTimeFormatter DT_FORMATTER_LDT = DateTimeFormatter.ofPattern(UtilsTesting.FORMAT_LDT);

	/* PERSON */

	/* USER */
	public static final String USER_USERNAME = "jroldaro";
	public static final String USER_USERNAME_AUX = "jroldaroAux";
	public static final String USER_PASSWORD = "1234";
	public static final String USER_ALIAS = "balbino";
	public static final Optional<String> USER_ALIAS_OPT = Optional.of("balbino");
	public static final EUserRol USER_ROL = EUserRol.MEMBER;
	public static final String USER_ROL_USER = "Usuario";
	public static final String USER_ROL_MEMBER = "Miembro";
	public static final String USER_ROL_ADMIN = "Admin";
	public static final Boolean USER_ACTIVE = Boolean.TRUE;
	public static final LocalDateTime USER_LAST_ACCESS = LocalDateTime.of(2021, 03, 23, 12, 26, 01);

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

	private UtilsTesting() {
		throw new IllegalStateException("Utility class");
	}

}
