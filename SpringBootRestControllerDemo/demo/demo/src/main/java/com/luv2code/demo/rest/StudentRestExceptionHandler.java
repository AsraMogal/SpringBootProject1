package com.luv2code.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

	
	//Add an excption handler using @ExceptionHandler
	//ResponseEntity<> shows the type of the response ->StudentErrorResponse
	//it takes the exception that is thrown as input method parameter --> StudentNotFoundException
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handlerException(StudentNotFoundException exec)
	{
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exec.getLocalizedMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	//Add exception handler to catch any exception

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handlerException(Exception exec)
	{
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exec.getLocalizedMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
}
