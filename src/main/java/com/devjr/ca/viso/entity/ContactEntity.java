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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_contact", unique = true, updatable = false, nullable = false)
	private Integer id;

	@Column(name = "email", unique = true, nullable = false, length = 100)
	private String email;

	@Column(name = "tlf_movil", unique = true, nullable = true, length = 15)
	private String tlfMovil;

	@Column(name = "tlf_home", nullable = true, length = 12)
	private String tlfHome;

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

}
