package com.booking.dao;

import java.util.List;

import com.booking.entity.Customer;

public interface CustomerDAO {

	Customer getCustomerById(int customerId);

	List<Customer> getAllCustomers();

	void addCustomer(Customer customer);

	void updateCustomer(Customer customer);

	void deleteCustomer(int customerId);

	boolean CustomerExists(String customerName, String customerGender);

}
