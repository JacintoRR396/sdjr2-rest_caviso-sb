package com.devjr.ca.viso.service.domain;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

/**
 * [Service : Domain] Logic respect to the User.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 11/04/2021
 * @modify 11/04/2021
 */
public class User implements Comparable<User> {

	/* VARIABLES */
	private Integer id;
	private String username;
	private String password;
	private Optional<String> alias;
	private EUserRol rol;
	private Boolean active;
	private LocalDateTime lastAccess;

	/* CONSTRUCTORS */
	public User() {
		super();
	}

	public User(final Integer id, final String username, final String password, final LocalDateTime lastAccess) {
		this(id, username, password, Optional.ofNullable(StringUtils.EMPTY), EUserRol.USER, Boolean.TRUE, lastAccess);
	}

	public User(final Integer id, final String username, final String password, final Optional<String> alias,
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

	public User(final Builder builder) {
		super();
		this.id = builder.id;
		this.username = builder.username;
		this.password = builder.password;
		this.alias = builder.alias;
		this.rol = builder.rol;
		this.active = builder.active;
		this.lastAccess = builder.lastAccess;
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

	public Optional<String> getAlias() {
		return this.alias;
	}

	public void setAlias(final Optional<String> alias) {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.id != null) ? this.id.hashCode() : 0);
		result = (prime * result) + ((this.username != null) ? this.username.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		final User other = (User) obj;
		return this.id.equals(other.id) && this.username.equals(other.username);
	}

	@Override
	public String toString() {
		final StringBuilder res = new StringBuilder(
				"\nThe Objet '" + this.getClass().getSimpleName() + "' contains the attributes: \n");
		res.append(" - Id » " + this.id + ".\n");
		res.append(" - Username » " + this.username + ".\n");
		res.append(" - Password » " + this.password + ".\n");
		res.append(" - Alias » " + (this.alias != null ? this.alias.get() : null) + ".\n");
		res.append(" - Rol » " + this.rol + ".\n");
		res.append(" - Active » " + this.active + ".\n");
		res.append(" - Last Access » " + this.lastAccess + ".\n");
		return res.toString();
	}

	@Override
	public int compareTo(final User user) {
		return this.getUsername().compareTo(user.getUsername());
	}

	public Builder builder() {
		return new Builder(this);
	}

	/* METHODS OF CLASSES */
	public static User valueOf(final User obj) {
		return new User(obj.getId(), obj.getUsername(), obj.getPassword(), obj.getAlias(), obj.getRol(), obj.isActive(),
				obj.getLastAccess());
	}

	public static final Comparator<User> comparatorRolASC = (final User obj1, final User obj2) -> obj2.getRol()
			.compareTo(obj1.getRol());
	public static final Comparator<User> comparatorRolDESC = (final User obj1, final User obj2) -> obj1.getRol()
			.compareTo(obj2.getRol());

	/* INTERNAL CLASS */
	public static class Builder {

		private Integer id;
		private String username;
		private String password;
		private Optional<String> alias;
		private EUserRol rol;
		private Boolean active;
		private LocalDateTime lastAccess;

		public Builder() {
			super();
		}

		public Builder(final User object) {
			super();
			this.id = object.id;
			this.username = object.username;
			this.password = object.password;
			this.alias = object.alias;
			this.rol = object.rol;
			this.active = object.active;
			this.lastAccess = object.lastAccess;
		}

		public Builder withId(final Integer id) {
			this.id = id;
			return this;
		}

		public Builder withUsername(final String username) {
			this.username = username;
			return this;
		}

		public Builder withPassword(final String password) {
			this.password = password;
			return this;
		}

		public Builder withAlias(final Optional<String> alias) {
			this.alias = alias;
			return this;
		}

		public Builder withRol(final EUserRol rol) {
			this.rol = rol;
			return this;
		}

		public Builder withActive(final Boolean active) {
			this.active = active;
			return this;
		}

		public Builder withLastAccess(final LocalDateTime lastAccess) {
			this.lastAccess = lastAccess;
			return this;
		}

		public User build() {
			return new User(this);
		}

	}

}
