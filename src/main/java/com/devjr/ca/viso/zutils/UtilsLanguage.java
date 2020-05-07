package com.devjr.ca.viso.zutils;

public class UtilsLanguage {

	/* COMMON */
	public static final String MSG_BASE = "[INFO] » ";

	/* OK */
	public static final String MSG_OK_ADD_UPDATE_BBDD = UtilsLanguage.MSG_BASE
			+ "Se ha añaido/actualizado la entidad en la BDs.";
	public static final String MSG_OK_DELETE_BBDD = UtilsLanguage.MSG_BASE + "se ha elimiando la entidad en la BDs.";

	/* ERRORS */
	public static final String MSG_ERROR_GET_ALL_BBDD = UtilsLanguage.MSG_BASE
			+ "NO se han obtenido las entidades de la BDs.";
	public static final String MSG_ERROR_GET_ONE_BBDD = UtilsLanguage.MSG_BASE
			+ "NO se ha obtenido la entidad de la BDs.";
	public static final String MSG_ERROR_ADD_UPDATE_BBDD = UtilsLanguage.MSG_BASE
			+ "NO se ha añaido/actualizado la entidad en la BDs.";
	public static final String MSG_ERROR_DELETE_BBDD = UtilsLanguage.MSG_BASE
			+ "NO se ha elimiando la entidad en la BDs.";

	public static final String MSG_ERROR_CONVERT_TO_ENTITY = UtilsLanguage.MSG_BASE
			+ "NO se ha podido convertir el Dominio a la Entidad DAO.";
	public static final String MSG_ERROR_CONVERT_TO_DOMAIN = UtilsLanguage.MSG_BASE
			+ "NO se ha podido convertir LA Entidad DAO al Dominio.";

	private UtilsLanguage() {
		throw new IllegalStateException("Utility class");
	}

}
