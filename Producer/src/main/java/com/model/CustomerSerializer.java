package com.model;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomerSerializer implements Serializer<Customer> {

	private final Logger LOG = LoggerFactory.getLogger(CustomerSerializer.class);
	
	@Override
	public void configure(Map<String, ?> map, boolean b) {
		// configure
		LOG.info("inside configure()");
	}

	@Override
	public byte[] serialize(String arg0, Customer customer) {
		LOG.info("serialize() method started");
		byte[] retVal = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			retVal = objectMapper.writeValueAsString(customer).getBytes();
		} catch (Exception e) {
			String logMessage = String.format("serialize() method Exception occured = %s", e.getMessage());
			LOG.info(logMessage);
		}
		LOG.info("serialize() method completed");
		return retVal;
	}

	@Override
	public void close() {
		LOG.info("inside close() method");
	}

}
