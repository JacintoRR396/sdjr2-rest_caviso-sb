package com.devjr.ca.viso.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devjr.ca.viso.entity.ContactEntity;
import com.devjr.ca.viso.repository.IContactRepo;
import com.devjr.ca.viso.zutils.UtilsLanguage;

@Service
public class ContactServiceImpl implements IContactService {

	private static final Logger LOG = LoggerFactory.getLogger(ContactServiceImpl.class);

	@Autowired
	private IContactRepo repo;

	@Override
	public List<ContactEntity> findAll() {
		final List<ContactEntity> list = this.repo.findAll();
		if ((list == null) || list.isEmpty()) {
			ContactServiceImpl.LOG.info(UtilsLanguage.MSG_ERROR_GET_ALL_BBDD);
		}
		return list;
	}

	@Override
	public ContactEntity findById(final Integer id) {
		final Optional<ContactEntity> opt = this.repo.findById(id);
		if (opt.isPresent())
			return opt.get();
		ContactServiceImpl.LOG.info(UtilsLanguage.MSG_ERROR_GET_ONE_BBDD);
		return null;
	}

	@Override
	public ContactEntity save(final ContactEntity value) {
		final ContactEntity entity = this.repo.save(value);
		if (entity != null)
			return entity;
		ContactServiceImpl.LOG.info(UtilsLanguage.MSG_ERROR_ADD_UPDATE_BBDD);
		return null;
	}

	@Override
	public void deleteById(final Integer id) {
		try {
			this.repo.deleteById(id);
		} catch (final EmptyResultDataAccessException e) {
			ContactServiceImpl.LOG.info(UtilsLanguage.MSG_ERROR_DELETE_BBDD);
		}
	}

}
