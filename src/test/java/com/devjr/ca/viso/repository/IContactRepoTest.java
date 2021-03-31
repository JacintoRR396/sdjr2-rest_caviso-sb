package com.devjr.ca.viso.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.devjr.ca.viso.entity.ContactEntity;

@DataJpaTest
class IContactRepoTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private IContactRepo repo;

	@Test
	void testFindAll() throws Exception {
		final List<ContactEntity> list = this.repo.findAll();
		Assertions.assertFalse(list.isEmpty());
	}
	/*
	 * @Test public void findAllOrderByEmail_thenReturnContacts() { // given final
	 * ContactEntity contact1 = new ContactEntity(1, "algo@examplo.con",
	 * "610972145", "955278768"); final ContactEntity contact2 = new
	 * ContactEntity(2, "zalgo@examplo.con", "610972145", "955278768");
	 * this.entityManager.persist(contact1); this.entityManager.persist(contact2);
	 * this.entityManager.flush();
	 *
	 * // when final List<ContactEntity> found = this.repo.findAllOrderByEmail();
	 *
	 * // then Assertions.assertFalse(found.isEmpty()); }
	 */

}
