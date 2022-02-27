package com.niit.mongodbquery.controller;

import com.niit.mongodbquery.exception.*;
import com.niit.mongodbquery.model.Customer;
import com.niit.mongodbquery.model.Product;
import com.niit.mongodbquery.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
public class ProductController {
    ProductService productService;

    @Autowired
    ProductController(ProductService productService)
    {
        this.productService=productService;
    }

    @PostMapping("/productregister")
    public ResponseEntity<?> registerNewCustomer(@RequestBody Customer customer) throws CustomerAlreadyExistsException
    {
        try
        {
            return new ResponseEntity<>(productService.registerNewCustomer(customer) , HttpStatus.CREATED);
        }
        catch (CustomerAlreadyExistsException pe)
        {
            throw new CustomerAlreadyExistsException();
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("Customer Id May Be Exists..",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/product/{customerId}")
    public ResponseEntity<?> saveCustomerProduct(@RequestBody Product product,@PathVariable int customerId) throws CustomerNotFoundException, ProductAlreadyExistsException
    {
        try
        {
            return new ResponseEntity<>(productService.saveCustomerProduct(product,customerId),HttpStatus.OK);
        }
        catch (CustomerNotFoundException pe)
        {
            throw new CustomerNotFoundException();
        }
        catch (ProductAlreadyExistsException pe){
            throw new ProductAlreadyExistsException();
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("Customer & Product Doesnt Exists..",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{customerId}")
    public ResponseEntity<?> getAllProductsOfACustomer(@PathVariable int customerId) throws CustomerNotFoundException, NoProductsFoundException
    {
        try
        {
            return new ResponseEntity<>(productService.getAllProductsOfACustomer(customerId),HttpStatus.OK);
        }
        catch (CustomerNotFoundException pe)
        {
            throw new CustomerNotFoundException();
        }
        catch (NoProductsFoundException ne)
        {
            throw new NoProductsFoundException();
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("Product & Customer Doesnt Exists..",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/product/{productCode}/{customerId}")
    public ResponseEntity<?> deleteProductOfACustomer(@PathVariable int productCode,@PathVariable int customerId) throws ProductNotFoundException,CustomerNotFoundException
    {
        try
        {
            return new ResponseEntity<>(productService.deleteProductOfACustomer(productCode,customerId),HttpStatus.OK);
        }
        catch (ProductNotFoundException pe)
        {
            throw new ProductNotFoundException();
        }
        catch (CustomerNotFoundException ce)
        {
            throw new CustomerNotFoundException();
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("Product & Customer Doesnt Exists..",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/product/{productStatus}")
//    public ResponseEntity<?> getAllProductStatus(@PathVariable String productStatus) throws ProductNotFoundException
//    {
//        try
//        {
//            return new ResponseEntity<>(productService.getAllProductStatus(productStatus),HttpStatus.OK);
//        }
//        catch (ProductNotFoundException pe)
//        {
//            throw new ProductNotFoundException();
//        }
//        catch (Exception e)
//        {
//            return new ResponseEntity<>("Try Again Some Time..",HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/product")
//    public ResponseEntity<?> getAllProductsDetails()
//    {
//        try
//        {
//            return new ResponseEntity<>(productService.getAllProductDetails(),HttpStatus.OK);
//        }
//        catch (Exception e)
//        {
//            return new ResponseEntity<>("Try Another Time..",HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
