package com.devjr.ca.viso;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilsTesting {

	/* GENERIC */
	public static final Integer ID = 1;
	public static final Integer ID_AUX = 2;

	/* ADDRESS */

	/* CONTACT */
	public static final String EMAIL = "algo@domain.ext";
	public static final String PHONE_MOBILE = "610972145";
	public static final String PHONE_HOME = "955278768";

	/* SOCIAL MEDIA */

	public static boolean matcherFind(final String regExp, final String value) {
		final Pattern pattern = Pattern.compile(regExp);
		final Matcher matcher = pattern.matcher(value);
		if (matcher.find()) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

}
