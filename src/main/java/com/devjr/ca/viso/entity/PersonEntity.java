package com.devjr.ca.viso.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.devjr.ca.viso.domain.EPersonDocument;

@Entity
@Table(name = "person", schema = "db_ca_viso")
public class PersonEntity {

	/* VARIABLES */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_person", unique = true, updatable = false, nullable = false)
	private Integer id;

	@Column(name = "document_type", nullable = false, length = 3)
	@Enumerated(value = EnumType.STRING)
	private EPersonDocument documentType;

	@Column(name = "document_number", unique = true, nullable = false, length = 12)
	private String documentNumber;

	@Column(name = "name", nullable = false, length = 30)
	private String name;

	@Column(name = "surname", nullable = false, length = 50)
	private String surname;

	@Column(name = "birthdate", nullable = false)
	private LocalDate birthdate;

	@Column(name = "path_image", nullable = true, length = 250)
	private String pathImage;

	@Column(name = "description", nullable = true)
	private String description;

	@OneToOne(targetEntity = ContactEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_contact", nullable = false)
	private ContactEntity contact;

	/* GETTERS AND SETTERS */
	public Integer getId() {
		return this.id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public EPersonDocument getDocumentType() {
		return this.documentType;
	}

	public void setDocumentType(final EPersonDocument documentType) {
		this.documentType = documentType;
	}

	public String getDocumentNumber() {
		return this.documentNumber;
	}

	public void setDocumentNumber(final String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
	}

	public LocalDate getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(final LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public String getPathImage() {
		return this.pathImage;
	}

	public void setPathImage(final String pathImage) {
		this.pathImage = pathImage;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public ContactEntity getContact() {
		return this.contact;
	}

	public void setContact(final ContactEntity contact) {
		this.contact = contact;
	}

}
