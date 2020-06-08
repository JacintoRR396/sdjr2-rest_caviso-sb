package com.devjr.ca.viso.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devjr.ca.viso.converter.PersonRequestConverter;
import com.devjr.ca.viso.converter.PersonResponseConverter;
import com.devjr.ca.viso.domain.Person;
import com.devjr.ca.viso.entity.PersonEntity;
import com.devjr.ca.viso.repository.IPersonRepo;
import com.devjr.ca.viso.zutils.UtilsLanguage;

/**
 * Representa el Servicio respecto a una Persona Genérica.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 18/04/2020
 * @modify 10/05/2020
 */
@Service
public class PersonServiceImpl implements IPersonService {

	private static final Logger LOG = LoggerFactory.getLogger(PersonServiceImpl.class);

	@Autowired
	private IPersonRepo repo;

	@Autowired
	private PersonRequestConverter converterRequest;

	@Autowired
	private PersonResponseConverter converterResponse;

	@Override
	public List<Person> findAll() {
		final List<PersonEntity> listDAO = this.repo.findAll();
		final List<Person> list = listDAO.stream().map(ce -> this.converterResponse.convert(ce))
				.collect(Collectors.toList());
		if (list.isEmpty()) {
			PersonServiceImpl.LOG.info(UtilsLanguage.MSG_ERROR_GET_ALL_BBDD);
		}
		return list;
	}

	@Override
	public Person findById(final Integer id) {
		final Optional<PersonEntity> opt = this.repo.findById(id);
		if (opt.isPresent()) {
			return this.converterResponse.convert(opt.get());
		}
		PersonServiceImpl.LOG.info(UtilsLanguage.MSG_ERROR_GET_ONE_BBDD);
		return null;
	}

	@Override
	public Person save(final Person value) {
		final PersonEntity entity = this.converterRequest.convert(value);
		return this.converterResponse.convert(this.repo.save(entity));
	}

	@Override
	public void deleteById(final Integer id) {
		try {
			this.repo.deleteById(id);
		} catch (final EmptyResultDataAccessException e) {
			PersonServiceImpl.LOG.info(UtilsLanguage.MSG_ERROR_DELETE_BBDD);
		}
	}

}
