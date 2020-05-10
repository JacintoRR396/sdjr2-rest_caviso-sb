package com.devjr.ca.viso.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devjr.ca.viso.converter.PersonCompleteRequestConverter;
import com.devjr.ca.viso.converter.PersonCompleteResponseConverter;
import com.devjr.ca.viso.domain.PersonComplete;
import com.devjr.ca.viso.entity.PersonCompleteEntity;
import com.devjr.ca.viso.repository.IPersonCompleteRepo;
import com.devjr.ca.viso.zutils.UtilsLanguage;

/**
 * Representa el Servicio respecto a una Persona.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 18/04/2020
 * @modify 10/05/2020
 */
@Service
public class PersonCompleteServiceImpl implements IPersonCompleteService {

	private static final Logger LOG = LoggerFactory.getLogger(PersonCompleteServiceImpl.class);

	@Autowired
	private IPersonCompleteRepo repo;

	@Autowired
	private PersonCompleteRequestConverter converterRequest;

	@Autowired
	private PersonCompleteResponseConverter converterResponse;

	@Override
	public List<PersonComplete> findAll() {
		final List<PersonCompleteEntity> listDAO = this.repo.findAll();
		final List<PersonComplete> list = listDAO.stream().map(ce -> this.converterResponse.convert(ce))
				.collect(Collectors.toList());
		if (list.isEmpty()) {
			PersonCompleteServiceImpl.LOG.info(UtilsLanguage.MSG_ERROR_GET_ALL_BBDD);
		}
		return list;
	}

	@Override
	public PersonComplete findById(final Integer id) {
		final Optional<PersonCompleteEntity> opt = this.repo.findById(id);
		if (opt.isPresent()) {
			return this.converterResponse.convert(opt.get());
		}
		PersonCompleteServiceImpl.LOG.info(UtilsLanguage.MSG_ERROR_GET_ONE_BBDD);
		return null;
	}

	@Override
	public PersonComplete save(final PersonComplete value) {
		final PersonCompleteEntity entity = this.converterRequest.convert(value);
		return this.converterResponse.convert(this.repo.save(entity));
	}

	@Override
	public void deleteById(final Integer id) {
		try {
			this.repo.deleteById(id);
		} catch (final EmptyResultDataAccessException e) {
			PersonCompleteServiceImpl.LOG.info(UtilsLanguage.MSG_ERROR_DELETE_BBDD);
		}
	}

}
