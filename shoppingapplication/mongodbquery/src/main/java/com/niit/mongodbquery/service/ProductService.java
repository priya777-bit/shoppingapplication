package com.niit.mongodbquery.service;

import com.niit.mongodbquery.exception.*;
import com.niit.mongodbquery.model.Customer;
import com.niit.mongodbquery.model.Product;

import java.util.List;

public interface ProductService {
    Customer registerNewCustomer(Customer customer) throws CustomerAlreadyExistsException;
    Customer saveCustomerProduct(Product product, int customerId) throws CustomerNotFoundException, ProductAlreadyExistsException;
    Customer deleteProductOfACustomer(int productCode,int customerId) throws ProductNotFoundException, CustomerNotFoundException;
    List<Product> getAllProductsOfACustomer(int customerId) throws CustomerNotFoundException, NoProductsFoundException;


//    Product updatePriceOfProduct(Product product,int productPrice) throws ProductNotFoundException;
////    Product getProductByProductCode(int productCode) throws ProductNotFoundException;
//    List<Product> getAllProductStatus(String productStatus) throws ProductNotFoundException;
}
