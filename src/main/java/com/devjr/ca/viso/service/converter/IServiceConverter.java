package com.devjr.ca.viso.service.converter;

import org.springframework.lang.Nullable;

/**
 * [Service : Converter] Interface Service Converter from Domain to Entity and
 * viceversa.
 *
 * @author Jacinto R^2
 * @version 1.0
 * @since 11/04/2021
 * @modify 11/04/2021
 */
public interface IServiceConverter<T, R> {

	@Nullable
	R convertToEntity(T domain);

	@Nullable
	T convertToDomain(R entity);

}
