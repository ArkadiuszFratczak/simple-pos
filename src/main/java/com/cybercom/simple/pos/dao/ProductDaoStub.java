package com.cybercom.simple.pos.dao;

import com.cybercom.simple.pos.model.Product;
import com.cybercom.simple.pos.model.SimpleProduct;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Arkadiusz.Fratczak
 */
public class ProductDaoStub implements ProductDao {
    
    private Map<String, Product> products;

    public ProductDaoStub() {
        products = new HashMap<String, Product>();
        products.put("000001", new SimpleProduct("Apple 1 pc", 1.10f));
        products.put("000002", new SimpleProduct("Banana 300g", 2.49f));
        products.put("000003", new SimpleProduct("Cheese 500g", 8.99f));
        products.put("000004", new SimpleProduct("Rice 4x100g", 1.99f));
        products.put("000005", new SimpleProduct("Milk 1l", 3.19f));
        products.put("000006", new SimpleProduct("Fries 1kg", 4.99f));
    }

    public ProductDaoStub(Map<String, Product> products) {
        this.products = products;
    }
    

    @Override
    public Product getProduct(String productCode) throws ProductNotFoundException {
        Product product = products.get(productCode);
        if (product == null) {
            throw new ProductNotFoundException("Product " + productCode + " not found!");
        } else {
            return product;
        }
    }

    public void setProducts(Map<String, Product> products) {
        this.products = products;
    }
    
}
