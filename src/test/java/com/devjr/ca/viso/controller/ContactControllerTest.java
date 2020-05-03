package com.devjr.ca.viso.controller;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.devjr.ca.viso.CaVisoApiRestApplication;
import com.devjr.ca.viso.UtilsTesting;
import com.devjr.ca.viso.domain.Contact;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CaVisoApiRestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContactControllerTest {

	private static final Logger LOG = LoggerFactory.getLogger(ContactControllerTest.class);

	@Autowired
	ContactController controller;

	private Contact obj;
	private List<Contact> list;

	@BeforeEach
	public void setUp() {
		final MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		this.obj = new Contact(UtilsTesting.ID, UtilsTesting.EMAIL, UtilsTesting.PHONE_MOBILE, UtilsTesting.PHONE_HOME);
		this.list = new ArrayList<>();
		this.list.add(this.obj);
		this.list.add(this.obj);
		this.list.add(this.obj);
	}

	@Test
	public void testGetAll() throws Exception {
		final ResponseEntity<List<Contact>> httpResponse = this.controller.getAll();

		Assert.assertEquals(httpResponse.getStatusCode(), CoreMatchers.is(HttpStatus.OK));

	}

	@Test
	public void testGetAllOrderByEmail() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGetAllByPhoneMovil() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGetAllByPhoneHome() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGet() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testInsert() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testUpdateAll() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testUpdate() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testDelete() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

}
