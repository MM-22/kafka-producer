package com.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Customer;
import com.model.SuccessResponse;
import com.producer.ProducerKafka;
import com.utils.Utils;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final Logger LOG = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	private ProducerKafka producerKafka;
	
	@Autowired
	private Utils utils;

	@Override
	public SuccessResponse saveCustomer(Customer customer) {
		
		LOG.info("save customer service started");
		String logMessage = String.format("customer details after masking = %s", utils.maskCustomerDetailsWithStars(customer));
		LOG.info(logMessage);
		
		producerKafka.sendMessage(customer);
		LOG.info("save customer service completed");
		
		return new SuccessResponse("success","customer details saved success");
	}
}