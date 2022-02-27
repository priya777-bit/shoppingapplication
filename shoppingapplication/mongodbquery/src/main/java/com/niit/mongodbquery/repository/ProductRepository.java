package com.niit.mongodbquery.repository;

import com.niit.mongodbquery.exception.CustomerNotFoundException;
import com.niit.mongodbquery.exception.NoProductsFoundException;
import com.niit.mongodbquery.model.Customer;
import com.niit.mongodbquery.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Customer,Integer> {

    Customer findByCustomerId(int customerId) throws CustomerNotFoundException;
//
//    @Query("{'productDescription.productStatus':{$in:[?0]}}")
//    List<Product> FindAllByProductStatus(String productStatus);

    List<Product> findAllProductsByCustomerId(int customerId) throws CustomerNotFoundException;
    List<Product> findAllProducts(List<Product> productList) throws NoProductsFoundException;
}
