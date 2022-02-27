package com.niit.mongodbquery.model;

import lombok.Data;

@Data
public class Product {
    private int productCode;
    private String productName;
    private String productDescription;
    private String productStock;
}
