package com.devjr.ca.viso.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorJsonMethArgNotValidList {

	/* VARIABLES */
	@JsonProperty("field")
	private String field;
	@JsonProperty("type")
	private String type;
	@JsonProperty("code")
	private String code;
	@JsonProperty("message")
	private String message;

	/* CONSTRUCTORS */
	@JsonCreator
	public ErrorJsonMethArgNotValidList(@JsonProperty("field") final String field,
			@JsonProperty("type") final String type, @JsonProperty("code") final String code,
			@JsonProperty("message") final String message) {
		super();
		this.field = field;
		this.type = type;
		this.code = code;
		this.message = message;
	}

	/* GETTERS AND SETTERS */
	public String getField() {
		return this.field;
	}

	public void setField(final String field) {
		this.field = field;
	}

	public String getType() {
		return this.type;
	}

	public void setType(final String type) {
		this.type = type;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(final String code) {
		this.code = code;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

}
