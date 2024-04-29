package com.test.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class MyExceptionHandler {
		
	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public Map<String,String> notValidInput(MethodArgumentNotValidException ex) {
	        Map<String,String> errorMap = new HashMap<String, String>();
	        ex.getBindingResult().getFieldErrors().forEach(error->{
	        	errorMap.put(error.getField(), error.getDefaultMessage());
	        });
	           return errorMap;
	    }
    
		@ExceptionHandler(HttpMessageNotReadableException.class)
		public String messageException(HttpMessageNotReadableException ex) {
			String msg = ex.getMessage();
			return msg;
		}
		
}
