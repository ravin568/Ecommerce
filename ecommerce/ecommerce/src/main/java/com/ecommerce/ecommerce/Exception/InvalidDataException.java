package com.ecommerce.ecommerce.Exception;

public class InvalidDataException extends RuntimeException{
    public InvalidDataException(String massage){
        super(massage);
    }
}
