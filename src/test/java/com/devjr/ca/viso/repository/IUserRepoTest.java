package com.devjr.ca.viso.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.devjr.ca.viso.repository.entity.UserEntity;

/**
 * [REPO] Test the JPA Repository for Users .
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 26/03/2021
 * @modify 26/03/2021
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class IUserRepoTest {

	private static final Logger LOG = LoggerFactory.getLogger(IUserRepoTest.class);

	@Autowired
	private IUserRepo repo;

	@BeforeAll
	protected static void setUpBeforeClass() throws Exception {
		IUserRepoTest.LOG.debug("\n\tStartup All : initializing variables");
	}

	@Test
	@Rollback(false)
	void testCreateUser() {
		// TODO
		this.repo.save(new UserEntity());
		Assertions.assertTrue(this.repo.count() > 0);
	}

	@Test
	void testFindAll() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

}
