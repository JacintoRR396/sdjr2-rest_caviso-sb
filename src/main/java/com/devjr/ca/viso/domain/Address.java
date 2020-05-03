package com.devjr.ca.viso.domain;

import java.util.Comparator;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.devjr.ca.viso.zutils.JsonAdapter;
import com.devjr.ca.viso.zutils.UtilsRegExp;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Representa el Dominio respecto a la Dirección de una Persona Física/Jurídica
 * o Carrera.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 03/05/2020
 * @modify 03/05/2020
 */
//@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Address implements Comparable<Address> {

	/* VARIABLES */
	@NotNull
	@Digits(integer = 8, fraction = 0)
	private final Integer id;

	@NotNull
	@Pattern(regexp = UtilsRegExp.STREET_REGEX)
	private final String street;

	@NotNull
	@Pattern(regexp = UtilsRegExp.NUMBER_REGEX)
	private final String number;

	@Pattern(regexp = UtilsRegExp.TOWN_REGEX)
	private final String town;

	@Pattern(regexp = UtilsRegExp.CITY_REGEX)
	private final String city;

	@Pattern(regexp = UtilsRegExp.COUNTRY_REGEX)
	private final String country;

	@NotNull
	@Digits(integer = 5, fraction = 0)
	private final Integer postalCode;

	@Pattern(regexp = UtilsRegExp.ADDITIONAL_INFO_REGEX)
	private final String additionalInfo;

	/* CONSTRUCTORS */
	@JsonCreator
	public Address(@JsonProperty("id") final Integer id, @JsonProperty("street") final String street,
			@JsonProperty("number") final String number, @JsonProperty("town") final String town,
			@JsonProperty("city") final String city, @JsonProperty("country") final String country,
			@JsonProperty("postalCode") final Integer postalCode,
			@JsonProperty("additionalInfo") final String additionalInfo) {
		super();
		this.id = id;
		this.street = street;
		this.number = number;
		this.town = town;
		this.city = city;
		this.country = country;
		this.postalCode = postalCode;
		this.additionalInfo = additionalInfo;
	}

	public Address(final Builder builder) {
		this(builder.id, builder.street, builder.number, builder.town, builder.city, builder.country,
				builder.postalCode, builder.additionalInfo);
	}

	/* GETTERS */
	public Integer getId() {
		return this.id;
	}

	public String getStreet() {
		return this.street;
	}

	public String getNumber() {
		return this.number;
	}

	public String getTown() {
		return this.town;
	}

	public String getCity() {
		return this.city;
	}

	public String getCountry() {
		return this.country;
	}

	public Integer getPostalCode() {
		return this.postalCode;
	}

	public String getAdditionalInfo() {
		return this.additionalInfo;
	}

	/* METHODS OF INSTANCE */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.id != null) ? this.id.hashCode() : 0);
		result = (prime * result) + ((this.street != null) ? this.street.hashCode() : 0);
		result = (prime * result) + ((this.number != null) ? this.number.hashCode() : 0);
		result = (prime * result) + ((this.town != null) ? this.town.hashCode() : 0);
		result = (prime * result) + ((this.city != null) ? this.city.hashCode() : 0);
		result = (prime * result) + ((this.country != null) ? this.country.hashCode() : 0);
		result = (prime * result) + ((this.postalCode != null) ? this.postalCode.hashCode() : 0);
		result = (prime * result) + ((this.additionalInfo != null) ? this.additionalInfo.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Address)) {
			return false;
		}
		final Address other = (Address) obj;
		return this.id.equals(other.id) && this.street.equals(other.street) && this.number.equals(other.number)
				&& this.town.equals(other.town) && this.city.equals(other.city) && this.country.equals(other.country)
				&& this.postalCode.equals(other.postalCode) && this.additionalInfo.equals(other.additionalInfo);
	}

	@Override
	public String toString() {
		final StringBuilder res = new StringBuilder(
				"The Objet '" + this.getClass().getSimpleName() + "' contains the attributes: \n");
		res.append(" - Id » " + this.id + ".\n");
		res.append(" - Street » " + this.street + ".\n");
		res.append(" - Number » " + this.number + ".\n");
		res.append(" - Town » " + this.town + ".\n");
		res.append(" - City » " + this.city + ".\n");
		res.append(" - Country » " + this.country + ".\n");
		res.append(" - Postal Code » " + this.postalCode + ".\n");
		res.append(" - Additional Info » " + this.additionalInfo + ".\n");
		return res.toString();
	}

	@Override
	public int compareTo(final Address obj) {
		// By PostalCode, Street and Number
		int res = this.getPostalCode().compareTo(obj.getPostalCode());
		if (res == 0) {
			res = this.getStreet().compareTo(obj.getStreet());
			if (res == 0) {
				res = this.getNumber().compareTo(obj.getNumber());
			}
		}
		return res;
	}

	public Builder builder() {
		return new Builder(this);
	}

	public static Address toObjWebResponse(final String jsonData) {
		return JsonAdapter.readValue(jsonData, Address.class);
	}

	public static String toJsonStr(final Address objWebResp) {
		return JsonAdapter.writeValueAsString(objWebResp);
	}

	/* METHODS OF CLASSES */
	public static Address valueOf(final Address obj) {
		return new Address(obj.getId(), obj.getStreet(), obj.getNumber(), obj.getTown(), obj.getCity(),
				obj.getCountry(), obj.getPostalCode(), obj.getAdditionalInfo());
	}

	public static final Comparator<Address> comparatorTownASC = (final Address obj1, final Address obj2) -> obj1
			.getTown().toUpperCase().compareTo(obj2.getTown().toUpperCase());
	public static final Comparator<Address> comparatorTownDESC = (final Address obj1, final Address obj2) -> obj2
			.getTown().toUpperCase().compareTo(obj1.getTown().toUpperCase());

	public static final Comparator<Address> comparatorCityASC = (final Address obj1, final Address obj2) -> obj1
			.getCity().toUpperCase().compareTo(obj2.getCity().toUpperCase());
	public static final Comparator<Address> comparatorCityDESC = (final Address obj1, final Address obj2) -> obj2
			.getCity().toUpperCase().compareTo(obj1.getCity().toUpperCase());

	public static final Comparator<Address> comparatorPostalCodeASC = (final Address obj1, final Address obj2) -> obj1
			.getPostalCode().compareTo(obj2.getPostalCode());
	public static final Comparator<Address> comparatorPostalCodeDESC = (final Address obj1, final Address obj2) -> obj2
			.getPostalCode().compareTo(obj1.getPostalCode());

	/* INTERNAL CLASS */
	public static class Builder {

		private Integer id;
		private String street;
		private String number;
		private String town;
		private String city;
		private String country;
		private Integer postalCode;
		private String additionalInfo;

		public Builder() {
			super();
		}

		public Builder(final Address object) {
			super();
			this.id = object.id;
			this.street = object.street;
			this.number = object.number;
			this.town = object.town;
			this.city = object.city;
			this.country = object.country;
			this.postalCode = object.postalCode;
			this.additionalInfo = object.additionalInfo;
		}

		public Builder withId(final Integer id) {
			this.id = id;
			return this;
		}

		public Builder withStreet(final String street) {
			this.street = street;
			return this;
		}

		public Builder withNumber(final String number) {
			this.number = number;
			return this;
		}

		public Builder withTown(final String town) {
			this.town = town;
			return this;
		}

		public Builder withCity(final String city) {
			this.city = city;
			return this;
		}

		public Builder withCountry(final String country) {
			this.country = country;
			return this;
		}

		public Builder withPostalCode(final Integer postalCode) {
			this.postalCode = postalCode;
			return this;
		}

		public Builder withAdditionalInfo(final String additionalInfo) {
			this.additionalInfo = additionalInfo;
			return this;
		}

		public Address build() {
			return new Address(this);
		}

	}

}
