package com.niit.mongodbquery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Product List Not Found..")
public class NoProductsFoundException extends Exception{
}
