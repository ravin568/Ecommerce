package com.ecommerce.ecommerce.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(EcommerceException.class)
    public ResponseEntity<String> handleEcommerceException(EcommerceException ex){
        logger.error("Ecommerce error: {}",ex.getMessage(),ex);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<String> hadleGenericException(InvalidDataException e){
        logger.error("Invalid data exception: {}",e.getMessage(),e);
        return new ResponseEntity<>("An Unexpected error occured",HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
