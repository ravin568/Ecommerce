package com.ecommerce.ecommerce.Exception;

public class EcommerceException extends RuntimeException{

    public EcommerceException(String massage){
        super(massage);
    }
    public EcommerceException(String massage,Throwable cause){
        super(massage,cause);
    }
}
