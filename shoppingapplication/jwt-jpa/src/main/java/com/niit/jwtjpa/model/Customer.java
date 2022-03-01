package com.niit.jwtjpa.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Customer {
    @Id
    private String customerEmailId;
    private String customerPassword;
}
