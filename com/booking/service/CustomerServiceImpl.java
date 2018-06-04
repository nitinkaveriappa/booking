package com.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.dao.CustomerDAO;
import com.booking.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDAO customerDAO;
	@Override
	public Customer getCustomerById(int customerId) {
		Customer obj = customerDAO.getCustomerById(customerId);
		return obj;
	}	
	@Override
	public List<Customer> getAllCustomers(){
		return customerDAO.getAllCustomers();
	}
	@Override
	public synchronized boolean addCustomer(Customer customer){
       if (customerDAO.CustomerExists(customer.getCustomerName(), customer.getCustomerGender())) {
    	   return false;
       } else {
    	   customerDAO.addCustomer(customer);
    	   return true;
       }
	}
	@Override
	public void updateCustomer(Customer customer) {
		customerDAO.updateCustomer(customer);
	}
	@Override
	public void deleteCustomer(int customerId) {
		customerDAO.deleteCustomer(customerId);
	}
}