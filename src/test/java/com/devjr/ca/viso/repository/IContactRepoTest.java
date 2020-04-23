package com.devjr.ca.viso.repository;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.devjr.ca.viso.entity.ContactEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
class IContactRepoTest{

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private IContactRepo repo;

    @Test
    public void findAllOrderByEmail_thenReturnContacts(){
        // given
        ContactEntity contact1 = new ContactEntity(1, "algo@examplo.con", "610972145", "955278768");
        ContactEntity contact2 = new ContactEntity(2, "zalgo@examplo.con", "610972145", "955278768");
        this.entityManager.persist(contact1);
        this.entityManager.persist(contact2);
        this.entityManager.flush();

        // when
        List<ContactEntity> found = this.repo.findAllOrderByEmail();

        // then
        assertFalse(found.isEmpty());
    }

}
