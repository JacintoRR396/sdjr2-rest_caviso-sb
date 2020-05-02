package com.devjr.ca.viso.zutils;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonAdapter {

	private static final Logger LOG = LoggerFactory.getLogger(JsonAdapter.class);
	private static final ObjectMapper OBJ_MAPPER = new ObjectMapper();

	private JsonAdapter() {

	}

	public static <T> T readValue(final String jsonData, final Class<T> clazz) {
		try {
			if ((jsonData != null) && !jsonData.isEmpty()) {
				return JsonAdapter.OBJ_MAPPER.readValue(jsonData, clazz);
			} else {
				return null;
			}
		} catch (NullPointerException | IOException e) {
			JsonAdapter.LOG.error(e.getMessage());
			return null;
		}
	}

	public static <T> String writeValueAsString(final T modelObject) {
		try {
			if (modelObject != null) {
				return JsonAdapter.OBJ_MAPPER.writeValueAsString(modelObject);
			} else {
				return null;
			}
		} catch (NullPointerException | IOException e) {
			JsonAdapter.LOG.error(e.getMessage());
			return null;
		}
	}

}