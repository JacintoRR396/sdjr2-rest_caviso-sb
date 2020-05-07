package com.devjr.ca.viso.exception;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class CustomRestExceptionHandler {

	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorJsonMethArgNotValid> methodArgumentNotValidException(final HttpServletRequest request,
			final MethodArgumentNotValidException e) {

		// get spring errors
		final BindingResult result = e.getBindingResult();
		final List<FieldError> fieldErrors = result.getFieldErrors();

		// convert errors to standard json
		final List<ErrorJsonMethArgNotValidList> errors = new ArrayList<>();
		fieldErrors.forEach(fe -> {
			final ErrorJsonMethArgNotValidList error = new ErrorJsonMethArgNotValidList(fe.getField(), fe.getCodes()[2],
					fe.getCode(), fe.getDefaultMessage());
			errors.add(error);
		});

		// return error info object with standard json
		final ErrorJsonMethArgNotValid errorJsonMethArgNotValid = new ErrorJsonMethArgNotValid(
				HttpStatus.BAD_REQUEST.value(), request.getRequestURI(), e.getMessage(), errors);

		return new ResponseEntity<>(errorJsonMethArgNotValid, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ErrorJsonMethArgNotValid> handleEntityNotFound(final EntityNotFoundException ex) {
		final ErrorJsonMethArgNotValid errorJsonMethArgNotValid = new ErrorJsonMethArgNotValid(
				HttpStatus.NOT_FOUND.value(), null, ex.getMessage(), null);

		return new ResponseEntity<>(errorJsonMethArgNotValid, HttpStatus.NOT_FOUND);
	}

}
