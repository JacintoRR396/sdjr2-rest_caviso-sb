package com.devjr.ca.viso.zutils;

public class UtilsLanguage {

	/* COMMON */
	public static final String MSG_BASE_OK = "[OK] » ";
	public static final String MSG_BASE_INFO = "[INFO] » ";
	public static final String MSG_BASE_ERROR = "[ERROR] » ";

	/* OK */
	public static final String MSG_OK_ADD_UPDATE_BBDD = "Se ha añaido/actualizado la entidad en la BDs.";
	public static final String MSG_OK_DELETE_BBDD = "Se ha elimiando la entidad en la BDs.";

	/* INFO */
	public static final String MSG_INFO_GET_ALL_BBDD = "NO existen las entidades en la BDs.";
	public static final String MSG_INFO_GET_ONE_BBDD = "NO exite la entidad de la BDs.";
	public static final String MSG_INFO_ADD_UPDATE_BBDD = "NO se ha añaido/actualizado la entidad en la BDs.";
	public static final String MSG_INFO_DELETE_BBDD = "NO se ha elimiando la entidad en la BDs.";

	/* ERRORS */
	public static final String MSG_ERROR_GET_ALL_BBDD = "NO se han podido obtener las entidades de la BDs.";
	public static final String MSG_ERROR_GET_ONE_BBDD = "NO se ha podido obtener la entidad de la BDs.";
	public static final String MSG_ERROR_ADD_UPDATE_BBDD = "NO se ha podido añaidir/actualizar la entidad en la BDs.";
	public static final String MSG_ERROR_DELETE_BBDD = "NO se ha podido elimiar la entidad en la BDs.";

	public static final String MSG_ERROR_CONVERT_TO_ENTITY = "NO se ha podido convertir el Dominio a la Entidad DAO.";
	public static final String MSG_ERROR_CONVERT_TO_DOMAIN = "NO se ha podido convertir LA Entidad DAO al Dominio.";

	private UtilsLanguage() {
		throw new IllegalStateException("Utility class");
	}

}
