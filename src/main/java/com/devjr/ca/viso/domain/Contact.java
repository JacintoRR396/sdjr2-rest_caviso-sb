package com.devjr.ca.viso.domain;

import javax.validation.constraints.Pattern;

import com.devjr.ca.viso.zutils.UtilsRegExp;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Contact {

	/* VARIABLES */
	private Integer id;
	@Pattern(regexp = UtilsRegExp.EMAIL_REGEX)
	private String email;
	@Pattern(regexp = UtilsRegExp.PHONE_MOVIL_REGEX)
	private String tlfMovil;
	@Pattern(regexp = UtilsRegExp.PHONE_HOME_REGEX)
	private String tlfHome;

	/* CONSTRUCTORS */
	@JsonCreator
	public Contact(@JsonProperty("id") final Integer id, @JsonProperty("email") final String email,
			@JsonProperty("tlfMovil") final String tlfMovil, @JsonProperty("tlfHome") final String tlfHome) {
		super();
		this.id = id;
		this.email = email;
		this.tlfMovil = tlfMovil;
		this.tlfHome = tlfHome;
	}

	public Contact(final Integer id, final String email) {
		this(id, email, null, null);
	}

	/* GETTERS AND SETTERS */
	public Integer getId() {
		return this.id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getTlfMovil() {
		return this.tlfMovil;
	}

	public void setTlfMovil(final String tlfMovil) {
		this.tlfMovil = tlfMovil;
	}

	public String getTlfHome() {
		return this.tlfHome;
	}

	public void setTlfHome(final String tlfHome) {
		this.tlfHome = tlfHome;
	}

	/* METHODS OF INSTANCE */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.id == null) ? 0 : this.id.hashCode());
		result = (prime * result) + ((this.email == null) ? 0 : this.email.hashCode());
		result = (prime * result) + ((this.tlfMovil == null) ? 0 : this.tlfMovil.hashCode());
		result = (prime * result) + ((this.tlfHome == null) ? 0 : this.tlfHome.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Contact))
			return false;
		final Contact other = (Contact) obj;
		return this.id.equals(other.id) && this.email.equals(other.email) && this.tlfMovil.equals(other.tlfMovil)
				&& this.tlfHome.equals(other.tlfHome);
	}

	@Override
	public String toString() {
		return "Contact [id=" + this.id + ", email=" + this.email + ", tlfMovil=" + this.tlfMovil + ", tlfHome="
				+ this.tlfHome + "]";
	}

}
