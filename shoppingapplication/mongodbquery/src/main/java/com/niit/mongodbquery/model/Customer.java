package com.niit.mongodbquery.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class Customer {
    @Id
    private int customerId;
    private String customerName;
    private String shippingAddress;
    private String customerEmailId;
    private String customerPassword;
    private List<Product> productList;
}
