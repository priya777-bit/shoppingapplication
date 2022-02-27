package com.niit.jwtjpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CREATED,reason = "Customer Already Exists...")
public class CustomerAlreadyExistsException extends Exception{
}
