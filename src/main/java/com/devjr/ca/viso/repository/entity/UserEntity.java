package com.devjr.ca.viso.repository.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

import com.devjr.ca.viso.repository.attrconv.AttributeConverterBoolean;
import com.devjr.ca.viso.repository.attrconv.AttributeConverterEUserRol;
import com.devjr.ca.viso.repository.attrconv.AttributeConverterLocalDateTime;
import com.devjr.ca.viso.service.domain.EUserRol;

/**
 * [REPO : Entity] Create and map the data table with respect to the User.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 08/06/2020
 * @modify 26/03/2021
 */
@Entity
@Table(name = "user", schema = "db_ca_viso", indexes = {
		@Index(name = "id_user_PK_UNIQUE", columnList = "id_user", unique = true),
		@Index(name = "username_UNIQUE", columnList = "username", unique = true),
		@Index(name = "index_rol", columnList = "rol"), @Index(name = "index_active", columnList = "active") })
public class UserEntity {

	/* VARIABLES */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user", unique = true, nullable = false, updatable = false)
	private Integer id;

	@Column(name = "username", unique = true, nullable = false, length = 50)
	private String username;

	@Column(name = "password", nullable = false, length = 30)
	private String password;

	@Column(name = "alias", nullable = true, length = 50)
	private String alias;

	@Column(name = "rol", nullable = false, length = 10)
	// @Enumerated(value = EnumType.STRING)
	@Convert(converter = AttributeConverterEUserRol.class)
	private EUserRol rol;

	@Column(name = "active", nullable = false)
	@Convert(converter = AttributeConverterBoolean.class)
	private Boolean active;

	@Column(name = "last_access", nullable = false)
	@Convert(converter = AttributeConverterLocalDateTime.class)
	private LocalDateTime lastAccess;

	/* CONSTRUCTORS */
	public UserEntity() {
		super();
	}

	public UserEntity(final Integer id, final String username, final String password, final LocalDateTime lastAccess) {
		this(id, username, password, StringUtils.EMPTY, EUserRol.USER, Boolean.TRUE, lastAccess);
	}

	public UserEntity(final Integer id, final String username, final String password, final String alias,
			final EUserRol rol, final Boolean active, final LocalDateTime lastAccess) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.alias = alias;
		this.rol = rol;
		this.active = active;
		this.lastAccess = lastAccess;
	}

	/* GETTERS AND SETTERS */
	public Integer getId() {
		return this.id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getAlias() {
		return this.alias;
	}

	public void setAlias(final String alias) {
		this.alias = alias;
	}

	public EUserRol getRol() {
		return this.rol;
	}

	public void setRol(final EUserRol rol) {
		this.rol = rol;
	}

	public Boolean isActive() {
		return this.active;
	}

	public void setActive(final Boolean active) {
		this.active = active;
	}

	public LocalDateTime getLastAccess() {
		return this.lastAccess;
	}

	public void setLastAccess(final LocalDateTime lastAccess) {
		this.lastAccess = lastAccess;
	}

	/* METHODS OF INSTANCE */
	@Override
	public String toString() {
		final StringBuilder res = new StringBuilder(
				"\nThe Objet '" + this.getClass().getSimpleName() + "' contains the attributes: \n");
		res.append(" - Id » " + this.id + ".\n");
		res.append(" - Username » " + this.username + ".\n");
		res.append(" - Password » " + this.password + ".\n");
		res.append(" - Alias » " + this.alias + ".\n");
		res.append(" - Rol » " + this.rol + ".\n");
		res.append(" - Active » " + this.active + ".\n");
		res.append(" - Last Access » " + this.lastAccess + ".\n");
		return res.toString();
	}

}
