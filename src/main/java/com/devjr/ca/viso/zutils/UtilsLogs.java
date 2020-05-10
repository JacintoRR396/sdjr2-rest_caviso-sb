package com.devjr.ca.viso.zutils;

public class UtilsLogs {

	public static String info(final String nameClass, final String nameMethod, final String msg) {
		return UtilsLanguage.MSG_BASE_INFO + nameClass + " : " + nameMethod + "() » " + msg;
	}

	public static String error(final String nameClass, final String nameMethod, final String msg) {
		return UtilsLanguage.MSG_BASE_ERROR + nameClass + " : " + nameMethod + "() » " + msg;
	}

	private UtilsLogs() {
		throw new IllegalStateException("Utility class");
	}

}
