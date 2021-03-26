package com.devjr.ca.viso.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Representa al DAO respecto a la Direccion de una Persona Física/Jurídica o
 * Carrera.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 03/05/2020
 * @modify 03/05/2020
 */
@Entity
@Table(name = "address", schema = "db_ca_viso")
public class AddressEntity {

	/* VARIABLES */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_address", unique = true, updatable = false, nullable = false)
	private Integer id;

	@Column(name = "street", nullable = false, length = 80)
	private String street;

	@Column(name = "number", nullable = false, length = 10)
	private String number;

	@Column(name = "town", nullable = true, length = 60)
	private String town;

	@Column(name = "city", nullable = true, length = 40)
	private String city;

	@Column(name = "country", nullable = true, length = 40)
	private String country;

	@Column(name = "postal_code", nullable = false, length = 5)
	private Integer postalCode;

	@Column(name = "additional_info", nullable = true, length = 1000)
	private String additionalInfo;

	/* CONSTRUCTORS */
	public AddressEntity() {
		super();
	}

	@JsonCreator
	public AddressEntity(final Integer id, final String street, final String number, final String town,
			final String city, final String country, final Integer postalCode, final String additionalInfo) {
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

	/* GETTERS AND SETTERS */
	public Integer getId() {
		return this.id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(final String street) {
		this.street = street;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(final String number) {
		this.number = number;
	}

	public String getTown() {
		return this.town;
	}

	public void setTown(final String town) {
		this.town = town;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(final String country) {
		this.country = country;
	}

	public Integer getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(final Integer postalCode) {
		this.postalCode = postalCode;
	}

	public String getAdditionalInfo() {
		return this.additionalInfo;
	}

	public void setAdditionalInfo(final String additionalInfo) {
		this.additionalInfo = additionalInfo;
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
		if (!(obj instanceof AddressEntity)) {
			return false;
		}
		final AddressEntity other = (AddressEntity) obj;
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

}
