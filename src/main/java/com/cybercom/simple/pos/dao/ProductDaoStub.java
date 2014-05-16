package com.cybercom.simple.pos.dao;

import com.cybercom.simple.pos.model.Product;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Arkadiusz.Fratczak
 */
public class ProductDaoStub implements ProductDao {
    
    private final Map<String, Product> products;

    public ProductDaoStub() {
        products = new HashMap<String, Product>();
        products.put("000001", new Product("Apple 1 pc", 1.10f));
        products.put("000002", new Product("Banana 300g", 2.49f));
        products.put("000003", new Product("Cheese 500g", 8.99f));
        products.put("000004", new Product("Rice 4x100g", 1.99f));
        products.put("000005", new Product("Milk 1l", 3.19f));
        products.put("000006", new Product("Fries 1kg", 4.99f));
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
    
}
