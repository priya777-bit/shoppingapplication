package com.niit.jwtjpa.service;

import com.niit.jwtjpa.exception.CustomerAlreadyExistsException;
import com.niit.jwtjpa.exception.CustomerNotFoundException;
import com.niit.jwtjpa.model.Customer;

import java.util.List;

public interface CustomerService {
    public Customer saveCustomer(Customer customer) throws CustomerAlreadyExistsException;
    public List<Customer> getAllCustomers();
    public Customer findByCustomerEmailIdAndCustomerPassword(String customerEmailId, String customerPassword) throws CustomerNotFoundException;
}
