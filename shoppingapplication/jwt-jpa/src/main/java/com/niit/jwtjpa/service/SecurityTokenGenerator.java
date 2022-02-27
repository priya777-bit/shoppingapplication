package com.niit.jwtjpa.service;

import com.niit.jwtjpa.model.Customer;

import java.util.Map;

public interface SecurityTokenGenerator {

    Map<String,String> generateToken(Customer customer);
}
