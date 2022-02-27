package com.niit.jwtjpa.service;

import com.niit.jwtjpa.model.Customer;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtSecurityTokenGeneratorImpl implements SecurityTokenGenerator{
    @Override
    public Map<String, String> generateToken(Customer customer) {
        String jwtToken=Jwts.builder().setSubject(customer.getCustomerEmailId()).setIssuedAt(new Date()).
                signWith(SignatureAlgorithm.HS256,"secretKey").compact();
        Map<String,String> map = new HashMap<>();
        map.put("Token",jwtToken);
        map.put("message","User Successfully Logged In..");
        return map;
    }
}
