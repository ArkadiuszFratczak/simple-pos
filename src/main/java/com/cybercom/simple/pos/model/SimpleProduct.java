package com.cybercom.simple.pos.model;

import java.io.Serializable;

/**
 *
 * @author Arkadiusz.Fratczak
 */
public class SimpleProduct implements Serializable, Product {
    
    private String name;
    private float price;

    public SimpleProduct() {
    }

    public SimpleProduct(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }    

    @Override
    public String toString() {
        return "Product: " + name + ", price: " + price;
    }

    /**
     * Method is based on name of product
     * @return hashCode
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    /**
     * Method is based on name of product
     * @param obj object to check equality
     * @return true if this product is equal given product, or false if is not
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SimpleProduct other = (SimpleProduct) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }
    
    
    
}
