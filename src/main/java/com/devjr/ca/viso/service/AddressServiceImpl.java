package com.devjr.ca.viso.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devjr.ca.viso.converter.AddressRequestConverter;
import com.devjr.ca.viso.converter.AddressResponseConverter;
import com.devjr.ca.viso.domain.Address;
import com.devjr.ca.viso.entity.AddressEntity;
import com.devjr.ca.viso.repository.IAddressRepo;
import com.devjr.ca.viso.zutils.UtilsLanguage;

/**
 * Representa el Servicio respecto a la Dirección de una Persona Física/Jurídica
 * o Carrera.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 03/05/2020
 * @modify 03/05/2020
 */
@Service
public class AddressServiceImpl implements IAddressService {

	private static final Logger LOG = LoggerFactory.getLogger(AddressServiceImpl.class);

	@Autowired
	private IAddressRepo repo;

	@Autowired
	private AddressRequestConverter converterRequest;

	@Autowired
	private AddressResponseConverter converterResponse;

	/*********** GET ***********/
	@Override
	public List<Address> findAll() {
		final List<AddressEntity> listDAO = this.repo.findAll();
		final List<Address> list = listDAO.stream().map(ce -> this.converterResponse.convert(ce))
				.collect(Collectors.toList());
		if (list.isEmpty()) {
			AddressServiceImpl.LOG.info(UtilsLanguage.MSG_ERROR_GET_ALL_BBDD);
		}
		return list;
	}

	@Override
	public Address findById(final Integer id) {
		final Optional<AddressEntity> opt = this.repo.findById(id);
		if (opt.isPresent()) {
			return this.converterResponse.convert(opt.get());
		}
		AddressServiceImpl.LOG.info(UtilsLanguage.MSG_ERROR_GET_ONE_BBDD);
		return null;
	}

	/*********** POST - PUT - PATCH ***********/
	@Override
	public Address save(final Address value) {
		final AddressEntity entity = this.converterRequest.convert(value);
		final Address res = this.converterResponse.convert(this.repo.save(entity));
		AddressServiceImpl.LOG.info(UtilsLanguage.MSG_OK_ADD_UPDATE_BBDD);
		return res;
	}

	/*********** DELETE ***********/
	@Override
	public void deleteById(final Integer id) {
		try {
			this.repo.deleteById(id);
			AddressServiceImpl.LOG.info(UtilsLanguage.MSG_OK_DELETE_BBDD);
		} catch (final EmptyResultDataAccessException e) {
			AddressServiceImpl.LOG.info(UtilsLanguage.MSG_ERROR_DELETE_BBDD);
		}
	}

}
