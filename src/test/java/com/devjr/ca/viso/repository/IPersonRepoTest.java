package com.devjr.ca.viso.repository;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
class IPersonRepoTest{

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private IPersonRepo personRepo;

    @Test
    void test(){
        fail("Not yet implemented");
    }

}
