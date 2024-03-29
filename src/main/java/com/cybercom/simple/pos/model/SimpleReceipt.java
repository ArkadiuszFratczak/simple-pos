package com.cybercom.simple.pos.model;

import com.cybercom.simple.pos.dao.ProductNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Arkadiusz.Fratczak
 */
public class SimpleReceipt implements Receipt {
    
    private final List<Product> purchasedProducts;
    private float totalSum;

    public SimpleReceipt() {
        this.purchasedProducts = new LinkedList<Product>();
    }
    
    @Override
    public void addProduct(Product product) {
        purchasedProducts.add(product);
        totalSum += product.getPrice();
    }
    
    @Override
    public void removeProduct(int position) throws ProductNotFoundException {
        try {
            purchasedProducts.remove(position);
        } catch (IndexOutOfBoundsException ex) {
            throw new ProductNotFoundException("Wrong number of product");
        }
    }

    @Override
    public float getTotalSum() {
        return totalSum;
    }
    
    @Override
    public List<Product> getPurchasedProducts() {
        return Collections.unmodifiableList(purchasedProducts);
    }

    @Override
    public String toString() {
        StringBuilder receiptString = new StringBuilder("List of purchased products: \n");
        for (Product product : purchasedProducts) {
            receiptString.append(product).append("\n");
        }
        receiptString.append("Total sum: ").append(totalSum);
        
        return receiptString.toString();
    }

}
