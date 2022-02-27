package com.niit.jwtjpa.service;

import com.niit.jwtjpa.exception.CustomerAlreadyExistsException;
import com.niit.jwtjpa.exception.CustomerNotFoundException;
import com.niit.jwtjpa.model.Customer;
import com.niit.jwtjpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository userRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository userRepository)
    {
        this.userRepository=userRepository;
    }
    @Override
    public Customer saveCustomer(Customer customer) throws CustomerAlreadyExistsException {
        if(userRepository.findById(customer.getCustomerEmailId()).isPresent())
        {
            throw new CustomerAlreadyExistsException();
        }
        return userRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return userRepository.findAll();
    }

    @Override
    public Customer findByCustomerEmailIdAndCustomerPassword(String customerEmailId, String customerPassword) throws CustomerNotFoundException {
        Customer user = userRepository.findByCustomerEmailIdAndCustomerPassword(customerEmailId,customerPassword);
        if(user==null)
        {
            throw new CustomerNotFoundException();
        }
        return user;
    }
}
