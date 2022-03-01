package com.niit.mongodbquery.repository;

import com.niit.mongodbquery.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Customer,String> {

//    Customer findByCustomerId(int customerId) throws CustomerNotFoundException;
//
//    @Query("{'productDescription.productStatus':{$in:[?0]}}")
//    List<Product> FindAllByProductStatus(String productStatus);

}
