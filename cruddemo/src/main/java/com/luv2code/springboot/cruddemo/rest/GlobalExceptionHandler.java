package com.luv2code.springboot.cruddemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handelException(EmployeeNotFoundException exc)
	{
		EmployeeErrorResponse crr= new EmployeeErrorResponse();
		
		crr.setStatus(HttpStatus.NOT_FOUND.value());
		crr.setMessage(exc.getMessage());
		crr.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(crr,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handelException(Exception exc)
	{
		EmployeeErrorResponse crr= new EmployeeErrorResponse();
		
		crr.setStatus(HttpStatus.BAD_REQUEST.value());
		crr.setMessage(exc.getMessage());
		crr.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(crr,HttpStatus.BAD_REQUEST);
	}
	
	
}
