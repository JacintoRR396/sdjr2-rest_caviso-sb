package com.devjr.ca.viso.domain;

import java.util.Comparator;

import javax.validation.constraints.Pattern;

import com.devjr.ca.viso.zutils.JsonAdapter;
import com.devjr.ca.viso.zutils.UtilsRegExp;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Representa el Dominio respecto a los Medios de Contacto de una Persona
 * Física/Jurídica o Carrera.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 18/04/2020
 * @modify 18/04/2020
 */
//@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Contact implements Comparable<Contact> {

	/* VARIABLES */
	@Pattern(regexp = UtilsRegExp.INDEX_REGEX)
	private final Integer id;
	@Pattern(regexp = UtilsRegExp.EMAIL_REGEX)
	private final String email;
	@Pattern(regexp = UtilsRegExp.PHONE_MOBILE_REGEX)
	private final String phoneMobile;
	@Pattern(regexp = UtilsRegExp.PHONE_HOME_REGEX)
	private final String phoneHome;

	/* CONSTRUCTORS */
	@JsonCreator
	public Contact(@JsonProperty("id") final Integer id, @JsonProperty("email") final String email,
			@JsonProperty("phoneMobile") final String phoneMobile, @JsonProperty("phoneHome") final String phoneHome) {
		super();
		this.id = id;
		this.email = email;
		this.phoneMobile = phoneMobile;
		this.phoneHome = phoneHome;
	}

	public Contact(final Builder builder) {
		this(builder.id, builder.email, builder.phoneMobile, builder.phoneHome);
	}

	/* GETTERS */
	public Integer getId() {
		return this.id;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPhoneMobile() {
		return this.phoneMobile;
	}

	public String getPhoneHome() {
		return this.phoneHome;
	}

	/* METHODS OF INSTANCE */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.id != null) ? this.id.hashCode() : 0);
		result = (prime * result) + ((this.email != null) ? this.email.hashCode() : 0);
		result = (prime * result) + ((this.phoneMobile != null) ? this.phoneMobile.hashCode() : 0);
		result = (prime * result) + ((this.phoneHome != null) ? this.phoneHome.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Contact)) {
			return false;
		}
		final Contact other = (Contact) obj;
		return this.id.equals(other.id) && this.email.equals(other.email) && this.phoneMobile.equals(other.phoneMobile)
				&& this.phoneHome.equals(other.phoneHome);
	}

	@Override
	public String toString() {
		final StringBuilder res = new StringBuilder(
				"The Objet '" + this.getClass().getSimpleName() + "' contains the attributes: \n");
		res.append(" - Id » " + this.id + ".\n");
		res.append(" - Email » " + this.email + ".\n");
		res.append(" - Phone Mobile » " + this.phoneMobile + ".\n");
		res.append(" - Phone Home » " + this.phoneHome + ".\n");
		return res.toString();
	}

	@Override
	public int compareTo(final Contact obj) {
		return this.getEmail().compareTo(obj.getEmail());
	}

	public Builder builder() {
		return new Builder(this);
	}

	public static Contact toObjWebResponse(final String jsonData) {
		return JsonAdapter.readValue(jsonData, Contact.class);
	}

	public static String toJsonStr(final Contact objWebResp) {
		return JsonAdapter.writeValueAsString(objWebResp);
	}

	/* METHODS OF CLASSES */
	public static Contact valueOf(final Contact obj) {
		return new Contact(obj.getId(), obj.getEmail(), obj.getPhoneMobile(), obj.getPhoneHome());
	}

	public static final Comparator<Contact> comparatorEmailASC = (final Contact obj1, final Contact obj2) -> obj1
			.getEmail().toUpperCase().compareTo(obj2.getEmail().toUpperCase());
	public static final Comparator<Contact> comparatorEmailDESC = (final Contact obj1, final Contact obj2) -> obj2
			.getEmail().toUpperCase().compareTo(obj1.getEmail().toUpperCase());
	public static final Comparator<Contact> comparatorPhoneMobileASC = (final Contact obj1, final Contact obj2) -> obj1
			.getPhoneMobile().toUpperCase().compareTo(obj2.getPhoneMobile().toUpperCase());
	public static final Comparator<Contact> comparatorPhoneMobileDESC = (final Contact obj1, final Contact obj2) -> obj2
			.getPhoneMobile().toUpperCase().compareTo(obj1.getPhoneMobile().toUpperCase());

	/* INTERNAL CLASS */
	public static class Builder {

		private Integer id;
		private String email;
		private String phoneMobile;
		private String phoneHome;

		public Builder() {
			super();
		}

		public Builder(final Contact object) {
			super();
			this.id = object.id;
			this.email = object.email;
			this.phoneMobile = object.phoneMobile;
			this.phoneHome = object.phoneHome;
		}

		public Builder withId(final Integer id) {
			this.id = id;
			return this;
		}

		public Builder withEmail(final String email) {
			this.email = email;
			return this;
		}

		public Builder withPhoneMobile(final String phoneMobile) {
			this.phoneMobile = phoneMobile;
			return this;
		}

		public Builder withPhoneHome(final String phoneHome) {
			this.phoneHome = phoneHome;
			return this;
		}

		public Contact build() {
			return new Contact(this);
		}

	}

}
