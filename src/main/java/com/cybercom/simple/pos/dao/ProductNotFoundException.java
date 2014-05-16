package com.cybercom.simple.pos.dao;

/**
 *
 * @author Arkadiusz.Fratczak
 */
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {
    }
    
    public ProductNotFoundException(String message) {
        super(message);
    }
    
}
