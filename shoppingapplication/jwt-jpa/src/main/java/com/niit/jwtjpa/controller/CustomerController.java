package com.niit.jwtjpa.controller;

import com.niit.jwtjpa.exception.CustomerAlreadyExistsException;
import com.niit.jwtjpa.exception.CustomerNotFoundException;
import com.niit.jwtjpa.model.Customer;
import com.niit.jwtjpa.service.SecurityTokenGenerator;
import com.niit.jwtjpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class CustomerController {

    private CustomerService customerService;

    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public CustomerController(CustomerService customerService, SecurityTokenGenerator securityTokenGenerator)
    {
        this.customerService=customerService;
        this.securityTokenGenerator=securityTokenGenerator;
    }

    @PostMapping("/register")
    public ResponseEntity saveCustomer(@RequestBody Customer customer) throws CustomerAlreadyExistsException {
        try
        {
            return new ResponseEntity(customerService.saveCustomer(customer), HttpStatus.CREATED);
        }
        catch (CustomerAlreadyExistsException ue)
        {
            throw new CustomerAlreadyExistsException();
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("Try After Sometime..",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/customers")
//    public ResponseEntity<?> getAllUsers()
//    {
//        return new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
//    }


//    @DeleteMapping("api/v1/user/users")
//    public ResponseEntity<?> getDelete(){}
//
//    @PutMapping("api/v1/user/users")
//    public ResponseEntity<?> updateUser(){}
//
//    @GetMapping("api/v1/user/users/{userId}")
//    public ResponseEntity<?>getUserByUserId()
//    {}


    @PostMapping("/login")
    public ResponseEntity<?> findByCustomerEmailIdAndCustomerPassword(@RequestBody Customer customer) throws CustomerNotFoundException
    {
        Map<String,String> map = null;
        try
        {
            Customer customer1 = customerService.findByCustomerEmailIdAndCustomerPassword(customer.getCustomerEmailId(),customer.getCustomerPassword());
            if(customer1.getCustomerEmailId().equals(customer.getCustomerEmailId()))
            {
                map = securityTokenGenerator.generateToken(customer);
            }
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
        catch (CustomerNotFoundException ue)
        {
            throw new CustomerNotFoundException();
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("Try Again Later..",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
