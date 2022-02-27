package com.niit.jwtjpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Customer Data Does Not Exists..")
public class CustomerNotFoundException extends Exception {
}
