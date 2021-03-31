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
 * [REPO] Test the JPA Repository for Users .
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
	}

	@Test
	void testFindByUsername_notExists() {
		final UserEntity user = this.repo.findByUsername("Pepe");
		Assertions.assertNull(user);
	}

	@Test
	void testFindByUsernameIgnoreCase_exists() {
		final UserEntity user = this.repo.findByUsername(UtilsTesting.USER_USERNAME.toUpperCase());
		Assertions.assertNotNull(user);
		Assertions.assertEquals(UtilsTesting.USER_USERNAME, user.getUsername());
	}

	@Test
	void testFindByUsernameIgnoreCase_notExists() {
		final UserEntity user = this.repo.findByUsername("Pepe".toUpperCase());
		Assertions.assertNull(user);
	}

	@Test
	void testFindByRol_exists() {
		final List<UserEntity> list = this.repo.findByRol(EUserRol.MEMBER);
		Assertions.assertNotNull(list);
		list.stream().forEach(u -> Assertions.assertEquals(EUserRol.MEMBER, u.getRol()));
	}

	@Test
	void testFindByActive_true() {
		final List<UserEntity> list = this.repo.findByActive(Boolean.TRUE);
		Assertions.assertNotNull(list);
		list.stream().forEach(u -> Assertions.assertTrue(u.isActive()));
	}

	@Test
	void testFindByActive_false() {
		final List<UserEntity> list = this.repo.findByActive(Boolean.FALSE);
		Assertions.assertNotNull(list);
		list.stream().forEach(u -> Assertions.assertFalse(u.isActive()));
	}

	@Test
	void testFindByLastAccess_exists() {
		final List<UserEntity> list = this.repo.findByLastAccess(UtilsTesting.USER_LAST_ACCESS);
		Assertions.assertNotNull(list);
		list.stream().forEach(u -> Assertions.assertEquals(UtilsTesting.USER_LAST_ACCESS, u.getLastAccess()));
	}

	@Test
	void testFindByLastAccess_notExists() {
		final List<UserEntity> list = this.repo.findByLastAccess(UtilsTesting.USER_LAST_ACCESS.plusDays(1));
		Assertions.assertNotNull(list);
		Assertions.assertTrue(list.isEmpty());
	}

	@Test
	void testFindByLastAccessLessThan_exists() {
		final LocalDateTime ldt = UtilsTesting.USER_LAST_ACCESS.plusDays(1);
		final List<UserEntity> list = this.repo.findByLastAccessLessThan(ldt);
		Assertions.assertNotNull(list);
		list.stream().forEach(u -> Assertions.assertTrue(ldt.isAfter(u.getLastAccess())));
	}

	@Test
	void testFindByLastAccessGreaterThan_exists() {
		final LocalDateTime ldt = UtilsTesting.USER_LAST_ACCESS.plusDays(1);
		final List<UserEntity> list = this.repo.findByLastAccessGreaterThan(ldt);
		Assertions.assertNotNull(list);
		list.stream().forEach(u -> Assertions.assertTrue(ldt.isBefore(u.getLastAccess())));
	}

	@Test
	void testFindByUsernameAndPasswordAndActiveTRUE_exists() {
		final UserEntity user = this.repo.findByUsernameAndPasswordAndActiveTRUE(UtilsTesting.USER_USERNAME,
				UtilsTesting.USER_PASSWORD);
		Assertions.assertNotNull(user);
	}

	@Test
	void testFindByUsernameAndPasswordAndActiveTRUE_notExists() {
		final UserEntity user = this.repo.findByUsernameAndPasswordAndActiveTRUE(UtilsTesting.USER_USERNAME,
				UtilsTesting.USER_USERNAME_AUX);
		Assertions.assertNull(user);
	}

}
