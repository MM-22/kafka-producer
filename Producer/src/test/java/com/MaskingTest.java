package com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.model.Address;
import com.model.Customer;
import com.model.CustomerStatus;
import com.utils.Utils;

@SpringBootTest
public class MaskingTest {
	
	@Autowired
	private Utils utils;
	
	@Test
	public void maskCustomerDetailsWithStars() {
		
		Address address = new Address();
		address.setAddressLine1("1-25/2 SHEKALLA");
		address.setAddressLine2("GOLLAPELLI");
		address.setStreet("TELANGANA");
		address.setPostalCode("50553");

		Customer customer3 = new Customer("C00000****", "Mahesh", "Manchala", "****7-1982", "INDIA", "IN",
				"9493971459");

		customer3.setEmail("****shmanchala92@gmail.com");
		customer3.setCustomerStatus(CustomerStatus.RESTORED);
		customer3.setAddress(address);

		Customer customer = new Customer("C000000002", "Mahesh", "Manchala", "05-07-1982", "INDIA", "IN", "9493971459");
		customer.setEmail("maheshmanchala92@gmail.com");
		customer.setCustomerStatus(CustomerStatus.RESTORED);
		customer.setAddress(address);

		Customer customer2 = utils.maskCustomerDetailsWithStars(customer);

		assertEquals(customer3.getCustomerNumber(), customer2.getCustomerNumber());
		assertEquals(customer3.getEmail(), customer2.getEmail());
		assertEquals(customer3.getBirthdate(), customer2.getBirthdate());
		assertEquals(customer3.getCustomerStatus(), customer2.getCustomerStatus());
		assertEquals(customer3.getCountry(), customer2.getCountry());
		assertEquals(customer3.getCountryCode(), customer2.getCountryCode());
		assertEquals(customer3.getFirstName(), customer2.getFirstName());
		assertEquals(customer3.getLastName(), customer2.getLastName());
		assertEquals(customer3.getAddress(), customer2.getAddress());
		assertEquals(customer3.getAddress().getAddressLine1(), customer2.getAddress().getAddressLine1());
		assertEquals(customer3.getAddress().getAddressLine2(), customer2.getAddress().getAddressLine2());
		assertEquals(customer3.getAddress().getPostalCode(), customer2.getAddress().getPostalCode());
		assertEquals(customer3.getAddress().getStreet(), customer2.getAddress().getStreet());
	}
	
	@Test
	public void maskCustomerDetailsWithStarsNullTest() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			utils.maskCustomerDetailsWithStars(null);
		  });
	}
}