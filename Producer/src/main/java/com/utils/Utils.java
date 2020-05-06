package com.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.model.Customer;

@Component
public class Utils {

	private final Logger LOG = LoggerFactory.getLogger(Utils.class);

	public String maskData(String ss, int i, boolean last) {
		if (last) {
			return ss.subSequence(0, i) + "****";
		} else {
			return "****" + ss.subSequence(i, ss.length());
		}
	}

	public Customer maskCustomerDetailsWithStars(Customer customer) {
		LOG.info("maskCustomerDetails method started");

		Customer customer2 = new Customer();
		String customerNumber = customer.getCustomerNumber();
		customer2.setCustomerNumber(maskData(customerNumber, 6, true));
		
		String logMessage1 = String.format("Encripted customerNumber = %s", customer2.getCustomerNumber());
		LOG.info(logMessage1);

		String dob = customer.getBirthdate();
		customer2.setBirthdate(	maskData(dob, 4, false));
		
		String logMessage2 = String.format("Encripted birthdate = %s", customer2.getBirthdate());
		LOG.info(logMessage2);

		String email = customer.getEmail();
		customer2.setEmail(maskData(email, 4, false));
		
		String logMessage3 = String.format("Encripted email = %s", customer2.getEmail());
		LOG.info(logMessage3);
		
		customer2.setAddress(customer.getAddress());
		customer2.setCountry(customer.getCountry());
		customer2.setCountryCode(customer.getCountryCode());
		customer2.setCustomerStatus(customer.getCustomerStatus());
		customer2.setFirstName(customer.getFirstName());
		customer2.setLastName(customer.getLastName());
		customer2.setMobileNumber(customer.getMobileNumber());

		LOG.info("maskCustomerDetails method completed");
		return customer2;
	}
}