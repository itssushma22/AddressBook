package com.restapi.addressbook.exception;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.validation.FieldError;


@RestControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {

			
	    @ExceptionHandler(Exception.class)
	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    public ResponseEntity<Object> handleAllUncaughtException(Exception exception, WebRequest webRequest) {
	     
	    	 String errorMessage = "Unknown error occurred";
		
	    	 return  handleExceptionInternal(exception, errorMessage, 
	    	          new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, webRequest);
	    }
	    
	    @Override
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
				HttpHeaders headers, HttpStatus status, WebRequest request) {
			
			Map<String, String> errors = new HashMap<>();
			ex.getBindingResult().getAllErrors().forEach((error) ->{
				
				String fieldName = ((FieldError) error).getField();
				String message = error.getDefaultMessage();
				errors.put(fieldName, message);
			});
			
			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		}
	    
	    @ExceptionHandler(ResourceAlreadyExistsException.class)
	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    public  ResponseEntity<Object> handleResourceAlreadyExistsException(
	        ResourceAlreadyExistsException exception, WebRequest webRequest) {

	    	 return  handleExceptionInternal(exception, exception.getMessage(), 
	    	          new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, webRequest);
        
	    }
	    
	    
	    @ExceptionHandler(DataIntegrityViolationException.class)
	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    public  ResponseEntity<Object> handleResourceSqlException(
	    		SQLException exception, WebRequest webRequest) {

	    	 return  handleExceptionInternal(exception, exception.getMessage(), 
	    	          new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, webRequest);
        
	    }
	    
}
