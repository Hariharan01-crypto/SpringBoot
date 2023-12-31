package com.example.restapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class UserExceptionHandler {

@ControllerAdvice
public class StudentRestExceptionHandler {

	// add exception handling code here
	
	// Add an exception handler using @ExceptionHandler
	
	@ExceptionHandler
	public ResponseEntity<UserErrorResponse> handleException(UserNotFoundException exc) {
		
		// create a StudentErrorResponse
		
		UserErrorResponse error = new UserErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		// return ResponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	// add another exception handler ... to catch any exception (catch all)
	
	@ExceptionHandler
	public ResponseEntity<UserErrorResponse> handleException(Exception exc) {
		
		// create a StudentErrorResponse
		UserErrorResponse error = new UserErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		// return ResponseEntity		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
}

}
