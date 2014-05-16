package com.cybercom.simple.pos.dao;

import com.cybercom.simple.pos.model.Product;

/**
 *
 * @author Arkadiusz.Fratczak
 */
public interface ProductDao {
    
    /**
     * Gets product associated with specific product code
     * @param productCode code scanned by bar codes scanner
     * @return product binded to specific product code
     * @throws ProductNotFoundException in case product was not found
     */
    public Product getProduct(String productCode) throws ProductNotFoundException;
}
