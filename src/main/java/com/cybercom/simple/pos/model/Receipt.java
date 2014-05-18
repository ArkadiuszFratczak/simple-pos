package com.cybercom.simple.pos.model;

import java.util.List;

/**
 *
 * @author Arkadiusz.Fratczak
 */
public interface Receipt {

    /**
     * Adds specified product to receipt
     * @param product 
     */
    void addProduct(Product product);

    /**
     * Gets purchased products
     * @return list with purchased products
     */
    List<Product> getPurchasedProducts();

    /**
     * Get total charge
     * @return charge for all products
     */
    float getTotalSum();

    /**
     * Removes product with given position from receipt
     * @param position number of product on receipt 
     */
    void removeProduct(int position);
    
}
