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
        return name + ", " + price;
    }
    
}
