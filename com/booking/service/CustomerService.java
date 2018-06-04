package com.booking.service;

import java.util.List;

import com.booking.entity.Customer;

public interface CustomerService {

	Customer getCustomerById(int customerId);

	List<Customer> getAllCustomers();

	boolean addCustomer(Customer customer);

	void updateCustomer(Customer customer);

	void deleteCustomer(int customerId);

}
