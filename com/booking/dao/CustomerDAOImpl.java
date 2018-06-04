package com.booking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.booking.entity.Customer;

@Transactional
@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Customer getCustomerById(int CustomerId) {
		return entityManager.find(Customer.class, CustomerId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllCustomers() {
		String hql = "FROM Customer as cust ORDER BY cust.customerId";
		return (List<Customer>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addCustomer(Customer customer) {
		entityManager.persist(customer);
	}
	@Override
	public void updateCustomer(Customer customer) {
		Customer cust = getCustomerById(customer.getCustomerId());
		cust.setCustomerName(customer.getCustomerName());
		cust.setCustomerGender(customer.getCustomerGender());
		cust.setCustomerDOB(customer.getCustomerDOB());
		cust.setCustomerBio(customer.getCustomerBio());
		entityManager.flush();
	}
	@Override
	public void deleteCustomer(int customerId) {
		entityManager.remove(getCustomerById(customerId));
	}
	@Override
	public boolean CustomerExists(String customerName, String customerGender) {
		String hql = "FROM Customer as cust WHERE cust.customerName = ? and cust.customerGender = ?";
		int count = entityManager.createQuery(hql).setParameter(1, customerName)
		              .setParameter(2, customerGender).getResultList().size();
		return count > 0 ? true : false;
	}
}
