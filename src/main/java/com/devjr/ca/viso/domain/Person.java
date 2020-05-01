package com.devjr.ca.viso.domain;

import java.time.LocalDate;
import java.util.Comparator;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

import com.devjr.ca.viso.entity.ContactEntity;
import com.devjr.ca.viso.zutils.UtilsDomain;
import com.devjr.ca.viso.zutils.UtilsRegExp;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Representa el Dominio respecto a una Persona Genérica.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 20/04/2020
 * @modify 23/04/2020
 */
//@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Person implements Comparable<Person> {

	/* VARIABLES */
	@Pattern(regexp = UtilsRegExp.INDEX_REGEX)
	private final Integer id;

	// TODO create validattion of the enum
	// @ValueOfEnum(enumClass = EPersonDocument.class)
	private final EPersonDocument documentType;

	@Pattern(regexp = UtilsRegExp.DOC_NUMBER_REGEX)
	private final String documentNumber;

	@Pattern(regexp = UtilsRegExp.NAME_REGEX)
	@Max(30)
	private final String name;

	@Pattern(regexp = UtilsRegExp.NAME_REGEX)
	@Max(50)
	private final String surname;

	@Pattern(regexp = UtilsRegExp.DATE_REGEX)
	private final LocalDate birthdate;

	@Pattern(regexp = UtilsRegExp.BALANCE_REGEX)
	private final Float balance;

	@Pattern(regexp = UtilsRegExp.PATH_IMAGE_REGEX)
	private final String pathImage;

	@Pattern(regexp = UtilsRegExp.DESCRIPTION_REGEX)
	private final String description;

	@Pattern(regexp = UtilsRegExp.INDEX_REGEX)
	@OneToOne(targetEntity = ContactEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_contact", nullable = false)
	private final Contact contact;

	/* CONSTRUCTORS */
	@JsonCreator
	public Person(@JsonProperty("id") final Integer id, @JsonProperty("documentType") final String documentType,
			@JsonProperty("documentNumber") final String documentNumber, @JsonProperty("name") final String name,
			@JsonProperty("surname") final String surname, @JsonProperty("birthdate") final String birthdate,
			@JsonProperty("balance") final Float balance, @JsonProperty("pathImage") final String pathImage,
			@JsonProperty("description") final String description, @JsonProperty("contact") final Contact contact) {
		super();
		this.id = id;
		this.documentType = EPersonDocument.valueOf(documentType);
		this.documentNumber = documentNumber;
		this.name = name;
		this.surname = surname;
		this.birthdate = UtilsDomain.parseStringToLocalDate(birthdate, UtilsDomain.S_FORMAT_DATE_FRONT);
		this.balance = balance;
		this.pathImage = pathImage;
		this.description = description;
		this.contact = contact;
	}

	public Person(final Builder builder) {
		this(builder.id, builder.documentType.name(), builder.documentNumber, builder.name, builder.surname,
				builder.birthdate.toString(), builder.balance, builder.pathImage, builder.description, builder.contact);
	}

	/* GETTERS AND SETTERS */
	public Integer getId() {
		return this.id;
	}

	public EPersonDocument getDocumentType() {
		return this.documentType;
	}

	public String getDocumentNumber() {
		return this.documentNumber;
	}

	public String getName() {
		return this.name;
	}

	public String getSurname() {
		return this.surname;
	}

	public LocalDate getBirthdate() {
		return this.birthdate;
	}

	public Float getBalance() {
		return this.balance;
	}

	public String getPathImage() {
		return this.pathImage;
	}

	public String getDescription() {
		return this.description;
	}

	public Contact getContact() {
		return this.contact;
	}

	/* METHODS OF INSTANCE */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.id == null) ? 0 : this.id.hashCode());
		result = (prime * result) + ((this.documentType == null) ? 0 : this.documentType.hashCode());
		result = (prime * result) + ((this.documentNumber == null) ? 0 : this.documentNumber.hashCode());
		result = (prime * result) + ((this.name == null) ? 0 : this.name.hashCode());
		result = (prime * result) + ((this.surname == null) ? 0 : this.surname.hashCode());
		result = (prime * result) + ((this.birthdate == null) ? 0 : this.birthdate.hashCode());
		result = (prime * result) + ((this.balance == null) ? 0 : this.balance.hashCode());
		result = (prime * result) + ((this.pathImage == null) ? 0 : this.pathImage.hashCode());
		result = (prime * result) + ((this.description == null) ? 0 : this.description.hashCode());
		result = (prime * result) + ((this.contact == null) ? 0 : this.contact.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Person))
			return false;
		final Person other = (Person) obj;
		return this.id.equals(other.id) && this.documentType.equals(other.documentType)
				&& this.documentNumber.equals(other.documentNumber) && this.name.equals(other.name)
				&& this.surname.equals(other.surname) && this.birthdate.equals(other.birthdate)
				&& this.balance.equals(other.balance) && this.pathImage.equals(other.pathImage)
				&& this.description.equals(other.description) && this.contact.equals(other.contact);
	}

	@Override
	public String toString() {
		final StringBuilder res = new StringBuilder(
				"The Objet '" + this.getClass().getSimpleName() + "' contains the attributes: \n");
		res.append(" - Id » " + this.id + ".\n");
		res.append(" - Document Type » " + this.documentType.name() + ".\n");
		res.append(" - Document Number » " + this.documentNumber + ".\n");
		res.append(" - Name » " + this.name + ".\n");
		res.append(" - Surname » " + this.surname + ".\n");
		res.append(" - Birhtdate » " + this.birthdate + ".\n");
		res.append(" - Balance » " + this.balance + ".\n");
		res.append(" - Description » " + this.description + ".\n");
		res.append(" - Contact » ");
		res.append((this.contact != null) ? this.contact.toString() : "null");
		res.append(".\n");
		return res.toString();
	}

	@Override
	public int compareTo(final Person obj) {
		return this.getDocumentNumber().compareTo(obj.getDocumentNumber());
	}

	public Builder builder() {
		return new Builder(this);
	}

	/* METHODS OF CLASSES */
	public static Person valueOf(final Person obj) {
		return new Person(obj.getId(), obj.getDocumentType().name(), obj.getDocumentNumber(), obj.getName(),
				obj.getSurname(), obj.getBirthdate().toString(), obj.getBalance(), obj.getPathImage(),
				obj.getDescription(), obj.getContact());
	}

	public static final Comparator<Person> surnameComparatorASC = (final Person obj1, final Person obj2) -> obj1
			.getSurname().toUpperCase().compareTo(obj2.getSurname().toUpperCase());

	public static final Comparator<Person> balanceComparatorASC = (final Person obj1, final Person obj2) -> obj1
			.getBalance().compareTo(obj2.getBalance());

	/* INTERNAL CLASS */
	public static class Builder {

		private Integer id;
		private EPersonDocument documentType;
		private String documentNumber;
		private String name;
		private String surname;
		private LocalDate birthdate;
		private Float balance;
		private String pathImage;
		private String description;
		private Contact contact;

		public Builder() {
			super();
		}

		public Builder(final Person object) {
			super();
			this.id = object.id;
			this.documentType = object.documentType;
			this.documentNumber = object.documentNumber;
			this.name = object.name;
			this.surname = object.surname;
			this.birthdate = object.birthdate;
			this.balance = object.balance;
			this.pathImage = object.pathImage;
			this.description = object.description;
			this.contact = object.contact;
		}

		public Builder withId(final Integer id) {
			this.id = id;
			return this;
		}

		public Builder withDocumentType(final EPersonDocument documentType) {
			this.documentType = documentType;
			return this;
		}

		public Builder withDocumentNumber(final String documentNumber) {
			this.documentNumber = documentNumber;
			return this;
		}

		public Builder withName(final String name) {
			this.name = name;
			return this;
		}

		public Builder withSurname(final String surname) {
			this.surname = surname;
			return this;
		}

		public Builder withBirthdate(final LocalDate birthdate) {
			this.birthdate = birthdate;
			return this;
		}

		public Builder withBalance(final Float balance) {
			this.balance = balance;
			return this;
		}

		public Builder withPathImage(final String pathImage) {
			this.pathImage = pathImage;
			return this;
		}

		public Builder withDescription(final String description) {
			this.description = description;
			return this;
		}

		public Builder withContact(final Contact contact) {
			this.contact = contact;
			return this;
		}

		public Person build() {
			return new Person(this);
		}

	}

}
