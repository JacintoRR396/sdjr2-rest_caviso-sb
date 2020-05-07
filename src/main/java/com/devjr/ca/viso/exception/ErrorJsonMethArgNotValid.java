package com.devjr.ca.viso.exception;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorJsonMethArgNotValid {

	/* VARIABLES */
	@JsonProperty("status_code")
	private final int statusCode;
	@JsonProperty("path")
	private final String path;
	@JsonIgnore
	@JsonProperty("message")
	private final String message;
	@JsonProperty("errors")
	private final List<ErrorJsonMethArgNotValidList> errors;

	/* CONSTRUCTORS */
	@JsonCreator
	public ErrorJsonMethArgNotValid(@JsonProperty("status_code") final int statusCode,
			@JsonProperty("path") final String path, @JsonProperty("message") final String message,
			@JsonProperty("errors") final List<ErrorJsonMethArgNotValidList> errors) {
		super();
		this.statusCode = statusCode;
		this.path = path;
		this.message = message;
		this.errors = errors;
	}

	/* GETTERS AND SETTERS */
	public int getStatusCode() {
		return this.statusCode;
	}

	public String getPath() {
		return this.path;
	}

	@JsonIgnore
	public String getMessage() {
		return this.message;
	}

	public List<ErrorJsonMethArgNotValidList> getErrors() {
		return this.errors;
	}

}
