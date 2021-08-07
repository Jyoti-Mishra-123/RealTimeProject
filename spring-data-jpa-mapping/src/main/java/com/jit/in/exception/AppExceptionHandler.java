package com.jit.in.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class AppExceptionHandler {
	
	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<ApiError> handleNoDataFoundException(){
		
		ApiError error=new ApiError(400,"No Customer Data Found",LocalDate.now());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		
	}

}
