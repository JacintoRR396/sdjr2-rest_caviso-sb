package com.devjr.ca.viso.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devjr.ca.viso.entity.PersonEntity;
import com.devjr.ca.viso.repository.IPersonRepo;
import com.devjr.ca.viso.zutils.UtilsLanguage;

@Service
public class PersonServiceImpl implements IPersonService {

	private static Logger LOG = LoggerFactory.getLogger(PersonServiceImpl.class);

	@Autowired
	private IPersonRepo repo;

	@Override
	public List<PersonEntity> findAll() {
		final List<PersonEntity> list = this.repo.findAll();
		if ((list == null) || list.isEmpty()) {
			PersonServiceImpl.LOG.info(UtilsLanguage.MSG_ERROR_GET_ALL_BBDD);
		}
		return list;
	}

	@Override
	public PersonEntity findById(final Integer id) {
		final Optional<PersonEntity> opt = this.repo.findById(id);
		if (opt.isPresent())
			return opt.get();
		PersonServiceImpl.LOG.info(UtilsLanguage.MSG_ERROR_GET_ONE_BBDD);
		return null;
	}

	@Override
	public void save(final PersonEntity value) {
		final PersonEntity entity = this.repo.save(value);
		if (entity == null) {
			PersonServiceImpl.LOG.info(UtilsLanguage.MSG_ERROR_ADD_UPDATE_BBDD);
		}
	}

	@Override
	public void deleteById(final Integer id) {
		this.repo.deleteById(id);
	}

}
