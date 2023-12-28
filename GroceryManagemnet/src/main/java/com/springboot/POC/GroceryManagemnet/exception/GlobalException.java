package com.springboot.POC.GroceryManagemnet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Object> exceptionhandler(RuntimeException e){

	return new ResponseEntity<Object> ("The given ID is not found",HttpStatus.BAD_REQUEST);
}
	

}