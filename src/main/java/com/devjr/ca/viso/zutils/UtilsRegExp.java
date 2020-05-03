package com.devjr.ca.viso.zutils;

public class UtilsRegExp {

	// *** COMMON ***
	public static final String INDEX_REGEX = "^(\\d{1,8})";
	public static final String NAME_GENERIC_REGEX = "^[A-Z]{1}[a-zñA-Záéíóú\\s/]{2,99}";

	// *** PERSON ***
	public static final String DNI_REGEX = "^(\\d{8})([A-Z])$";
	public static final String NIE_REGEX = "^[XYZ]\\d{7,8}[A-Z]$";
	public static final String CIF_REGEX = "^([ABCDEFGHJKLMNPQRSUVW])(\\d{7})([0-9A-J])$";
	public static final String DOC_NUMBER_REGEX = "^((\\\\d{8})([A-Z])|[XYZ]\\\\d{7,8}[A-Z]|([ABCDEFGHJKLMNPQRSUVW])(\\d{7})([0-9A-J]))$";
	public static final String NAME_REGEX = "^[A-Z]{1}[a-zñA-Záéíóú\\s\\.]{2,99}";
	public static final String DATE_REGEX = "^(0?[1-9]|[12][0-9]|3[01])\\/(0?[1-9]|1[012])\\/\\d{2,4}$";
	public static final String BALANCE_REGEX = "^[0-9]{1,5}[\\.|,]?[0-9]{0,2}$";
	public static final String PATH_IMAGE_REGEX = "^[a-zA-Z0-9\\.\\/\\_\\-]{3,245}(.jpg|.jpeg|.png|.gif)$";
	public static final String DESCRIPTION_REGEX = "^[A-Z]{1}[a-zA-Záéíóú\\s\\.\\_\\-,;()¿?!¡=]{3,5000}";

	// *** ADDRESS ***
	public static final String STREET_REGEX = UtilsRegExp.NAME_GENERIC_REGEX;
	public static final String NUMBER_REGEX = "^[0-9]{1,5}[A-Z]?$";
	public static final String TOWN_REGEX = UtilsRegExp.NAME_GENERIC_REGEX;
	public static final String CITY_REGEX = UtilsRegExp.NAME_GENERIC_REGEX;
	public static final String COUNTRY_REGEX = UtilsRegExp.NAME_GENERIC_REGEX;
	public static final String POSTAL_CODE_REGEX = "^(5[0-2]|[0-4][0-9])[0-9]{3}$";
	public static final String ADDITIONAL_INFO_REGEX = "^[A-Z]{1}[a-zA-Záéíóú\\s\\.\\_\\-,;()¿?!¡=]{3,2500}";

	// *** CONCTACT ***
	public static final String EMAIL_REGEX = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	public static final String PHONE_MOBILE_REGEX = "^(\\+34|0034|34)?[\\s|\\-|\\.]?[6|7|9][\\s|\\-|\\.]?([0-9][\\s|\\-|\\.]?){8}$";
	public static final String PHONE_HOME_REGEX = "^[9][0-9]{1}[\\s|\\-|\\.]?([0-9][\\s|\\-|\\.]?){7}$";

	// *** SOCIAL MEDIA ***
	public static final String FACEBOOK_REGEX = "^(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\?=.-]*)*\\/?$";
	public static final String TWITTER_REGEX = "^(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\?=.-]*)*\\/?$";
	public static final String INSTAGRAM_REGEX = "^(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\?=.-]*)*\\/?$";

	// *** LEGAL PERSON ***
	public static final String BANK_ACCOUNT_REGEX = "[0-9]{4}[\\s|\\-|\\.]?[0-9]{4}[\\s|\\-|\\.]?[0-9]{2}[\\s|\\-|\\.]?[0-9]{10}$";

	// *** PHYSICAL PERSON ***
	public static final String NUM_MEMBER_REGEX = "^[0-9]{1,5}$";
	public static final String USERNAME_REGEX = "[0-9a-zñA-Záéíóú\\s\\.\\_\\-,!¡$]{3,99}";
	public static final String PASS_REGEX = "[0-9a-zñA-Záéíóú\\s\\.\\_\\-,!¡$]{3,99}";
	public static final String NUM_RACES_REGEX = "^[0-9]{1,5}$";

	private UtilsRegExp() {
		throw new IllegalStateException("Utility class");
	}

}
