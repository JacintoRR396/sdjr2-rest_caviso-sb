package com.devjr.ca.viso.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact", schema = "db_ca_viso")
public class ContactEntity {

	/* VARIABLES */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contact", unique = true, updatable = false, nullable = false)
	private Integer id;

	@Column(name = "email", unique = true, nullable = false, length = 100)
	private String email;

	@Column(name = "phone_mobile", unique = true, nullable = true, length = 15)
	private String phoneMobile;

	@Column(name = "phone_home", nullable = true, length = 12)
	private String phoneHome;

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

	public String getPhoneMobile() {
		return this.phoneMobile;
	}

	public void setPhoneMobile(final String phoneMobile) {
		this.phoneMobile = phoneMobile;
	}

	public String getPhoneHome() {
		return this.phoneHome;
	}

	public void setPhoneHome(final String phoneHome) {
		this.phoneHome = phoneHome;
	}

}
