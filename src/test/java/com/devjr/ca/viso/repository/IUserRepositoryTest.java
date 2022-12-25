package com.devjr.ca.viso.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.devjr.ca.viso.UtilsTesting;
import com.devjr.ca.viso.repository.entity.UserEntity;
import com.devjr.ca.viso.service.domain.EUserRol;

/**
 * [REPO] Test the JPA Repository for Users.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 26/03/2021
 * @modify 31/03/2021
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class IUserRepositoryTest {

	private static final Logger LOG = LoggerFactory.getLogger(IUserRepositoryTest.class);

	@Autowired
	TestEntityManager entityManager;

	@Autowired
	private IUserRepository repo;

	@BeforeAll
	protected static void setUpBeforeClass() throws Exception {
		IUserRepositoryTest.LOG.debug("\n\tStartup All : initializing variables");
	}

	@Test
	void testFindByUsername_exists() {
		final UserEntity user = this.repo.findByUsername(UtilsTesting.USER_USERNAME);
		Assertions.assertNotNull(user);
		Assertions.assertEquals(UtilsTesting.USER_USERNAME, user.getUsername());
		IUserRepositoryTest.LOG.info("\n\t[OK] : SI existe el Username '" + UtilsTesting.USER_USERNAME + "'.");
	}

	@Test
	void testFindByUsername_notExists() {
		final UserEntity user = this.repo.findByUsername(UtilsTesting.USER_USERNAME_AUX);
		Assertions.assertNull(user);
		IUserRepositoryTest.LOG.info("\n\t[OK] : NO existe el Username '" + UtilsTesting.USER_USERNAME_AUX + "'.");
	}

	@Test
	void testFindByUsernameIgnoreCase_exists() {
		final UserEntity user = this.repo.findByUsername(UtilsTesting.USER_USERNAME.toUpperCase());
		Assertions.assertNotNull(user);
		Assertions.assertEquals(UtilsTesting.USER_USERNAME, user.getUsername());
		IUserRepositoryTest.LOG.info("\n\t[OK] : SI existe el Username '" + UtilsTesting.USER_USERNAME + "'.");
	}

	@Test
	void testFindByUsernameIgnoreCase_notExists() {
		final UserEntity user = this.repo.findByUsername(UtilsTesting.USER_USERNAME_AUX.toUpperCase());
		Assertions.assertNull(user);
		IUserRepositoryTest.LOG.info("\n\t[OK] : NO existe el Username '" + UtilsTesting.USER_USERNAME_AUX + "'.");
	}

	@Test
	void testFindByRol_exists() {
		final List<UserEntity> list = this.repo.findByRol(EUserRol.MEMBER);
		Assertions.assertNotNull(list);
		list.stream().forEach(u -> Assertions.assertEquals(EUserRol.MEMBER, u.getRol()));
		IUserRepositoryTest.LOG.info("\n\t[OK] : SI existen usuarios con el Rol '" + EUserRol.MEMBER + "'.");
	}

	@Test
	void testFindByActive_true() {
		final List<UserEntity> list = this.repo.findByActive(Boolean.TRUE);
		Assertions.assertNotNull(list);
		list.stream().forEach(u -> Assertions.assertTrue(u.isActive()));
		IUserRepositoryTest.LOG.info("\n\t[OK] : SI existen usuarios Activos.");
	}

	@Test
	void testFindByActive_false() {
		final List<UserEntity> list = this.repo.findByActive(Boolean.FALSE);
		Assertions.assertNotNull(list);
		list.stream().forEach(u -> Assertions.assertFalse(u.isActive()));
		IUserRepositoryTest.LOG.info("\n\t[OK] : NO existen usuarios Activos.");
	}

	@Test
	void testFindByLastAccess_exists() {
		final List<UserEntity> list = this.repo.findByLastAccess(UtilsTesting.USER_LAST_ACCESS);
		Assertions.assertNotNull(list);
		list.stream().forEach(u -> Assertions.assertEquals(UtilsTesting.USER_LAST_ACCESS, u.getLastAccess()));
		IUserRepositoryTest.LOG
				.info("\n\t[OK] : SI existe usuario con último acceso '" + UtilsTesting.USER_LAST_ACCESS + "'.");
	}

	@Test
	void testFindByLastAccess_notExists() {
		final LocalDateTime ldt = UtilsTesting.USER_LAST_ACCESS.plusDays(1);
		final List<UserEntity> list = this.repo.findByLastAccess(ldt);
		Assertions.assertNotNull(list);
		Assertions.assertTrue(list.isEmpty());
		IUserRepositoryTest.LOG.info("\n\t[OK] : SI existe usuario con último acceso '" + ldt + "'.");
	}

	@Test
	void testFindByLastAccessLessThan_exists() {
		final LocalDateTime ldt = UtilsTesting.USER_LAST_ACCESS.plusDays(1);
		final List<UserEntity> list = this.repo.findByLastAccessLessThan(ldt);
		Assertions.assertNotNull(list);
		list.stream().forEach(u -> Assertions.assertTrue(ldt.isAfter(u.getLastAccess())));
		IUserRepositoryTest.LOG.info("\n\t[OK] : SI existen usuarios con último acceso mayor que '" + ldt + "'.");
	}

	@Test
	void testFindByLastAccessGreaterThan_exists() {
		final LocalDateTime ldt = UtilsTesting.USER_LAST_ACCESS.plusDays(1);
		final List<UserEntity> list = this.repo.findByLastAccessGreaterThan(ldt);
		Assertions.assertNotNull(list);
		list.stream().forEach(u -> Assertions.assertTrue(ldt.isBefore(u.getLastAccess())));
		IUserRepositoryTest.LOG.info("\n\t[OK] : SI existen usuarios con último acceso menor que '" + ldt + "'.");
	}

	@Test
	void testFindByUsernameAndPasswordAndActiveTRUE_exists() {
		final UserEntity user = this.repo.findByUsernameAndPasswordAndActiveTRUE(UtilsTesting.USER_USERNAME,
				UtilsTesting.USER_PASSWORD);
		Assertions.assertNotNull(user);
		IUserRepositoryTest.LOG.info("\n\t[OK] : SI existe usuario activo con Username '" + UtilsTesting.USER_USERNAME
				+ "' y Password '" + UtilsTesting.USER_PASSWORD + "'.");
	}

	@Test
	void testFindByUsernameAndPasswordAndActiveTRUE_notExists() {
		final UserEntity user = this.repo.findByUsernameAndPasswordAndActiveTRUE(UtilsTesting.USER_USERNAME,
				UtilsTesting.USER_USERNAME_AUX);
		Assertions.assertNull(user);
		IUserRepositoryTest.LOG.info("\n\t[OK] : NO existe usuario activo con Username '" + "egm" + "' y Password '"
				+ UtilsTesting.USER_PASSWORD + "'.");
	}

}
