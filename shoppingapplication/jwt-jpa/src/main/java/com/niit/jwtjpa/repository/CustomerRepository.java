package com.niit.jwtjpa.repository;

import com.niit.jwtjpa.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {

    public Customer findByCustomerEmailIdAndCustomerPassword(String customerEmailId, String customerPassword);

}
