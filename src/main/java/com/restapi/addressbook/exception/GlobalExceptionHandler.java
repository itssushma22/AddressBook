package com.restapi.addressbook.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import lombok.AllArgsConstructor;
import lombok.Getter;

@RestControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {

	
	private static final Logger logger  = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
		
	    @ExceptionHandler(Exception.class)
	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    public ResponseEntity<String> handleAllUncaughtException(Exception exception) {
	    	logger.error("Unknown error occurred", exception);
	    	 
	    	 HttpStatus statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
	    	
	    	 ErrorMessage errorMessage = createErrorMessage(statusCode , "Unknown error occurred");
		
	    	 return new ResponseEntity<>(errorMessage.message, statusCode);
	    }
	    
//	    @ExceptionHandler(MethodNotAllowed.class)
//	    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
//	    public ResponseEntity<String> handleMethodNotAllowtException(Exception exception) {
//	    	logger.error("method not allowed", exception);
//	    	 
//		   	 HttpStatus statusCode = HttpStatus.METHOD_NOT_ALLOWED;
//		   	
//		   	 ErrorMessage errorMessage = createErrorMessage(statusCode , "Error in method type, please enter vaild method type");
//			
//		   	 return new ResponseEntity<>(errorMessage.message, statusCode);
//	    
//	    }
//	    
//	    @ExceptionHandler(InvalidInputException.class)
//	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//	    public ResponseEntity<String> handleMethodNotAllowtException(InvalidInputException exception) {
//	    	logger.error("Invalid input exception", exception);
//	    	
//		   	 HttpStatus statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
//		   	
//		   	 ErrorMessage errorMessage = createErrorMessage(statusCode , "Error in input type, please enter vaild input");
//			
//		   	 return new ResponseEntity<>(errorMessage.message, statusCode);
//		   	    
//	    }
	    
	    private ErrorMessage createErrorMessage(HttpStatus code, String message) {
	        return new ErrorMessage(code.value(), message);
	    }
	    
	  
	    @Getter
	    @AllArgsConstructor
	    static class ErrorMessage {
	    	  
	    	private String message;
	    	private int code;
	    	
	        public ErrorMessage(int value, String message) {
				this.code = value;
				this.message= message;
			}
		
	    }   
	    

}
