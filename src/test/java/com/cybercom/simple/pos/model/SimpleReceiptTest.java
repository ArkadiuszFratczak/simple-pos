package com.cybercom.simple.pos.model;

import com.cybercom.simple.pos.dao.ProductNotFoundException;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Arkadiusz.Fratczak
 */
public class SimpleReceiptTest {
    
    private SimpleReceipt receipt;
    
    @Before
    public void setUp() {
        receipt = new SimpleReceipt();
    }

    /**
     * Test of addProduct method, of class SimpleReceipt.
     */
    @Test
    public void testAddProduct() {
        //given        
        Product product = mock(Product.class);
        
        //when
        receipt.addProduct(product);
        
        //then
        assertEquals("List should have 1 element", 1, receipt.getPurchasedProducts().size());        
    }

    /**
     * Test of removeProduct method, of class SimpleReceipt.
     */
    @Test
    public void testRemoveProduct() {
        //given        
        Product pr1 = mock(Product.class);
        when(pr1.getName()).thenReturn("PR1");
        Product pr2 = mock(Product.class);
        when(pr2.getName()).thenReturn("PR2");
        
        receipt.addProduct(pr1);
        receipt.addProduct(pr2);
        
        //when
        receipt.removeProduct(0);
        
        //then
        List<Product> list = receipt.getPurchasedProducts();
        assertEquals("List should have one element", 1, list.size());
        assertEquals("List should have one product with name PR2", "PR2", list.get(0).getName());
    }
    
    /**
     * Test of removeProduct method, of class SimpleReceipt.
     */
    @Test(expected = ProductNotFoundException.class)
    public void testRemoveProduct_wrongNumberOfProduct() {
        //given        
        Product pr1 = mock(Product.class);
        when(pr1.getName()).thenReturn("PR1");
        Product pr2 = mock(Product.class);
        when(pr2.getName()).thenReturn("PR2");
        
        receipt.addProduct(pr1);
        receipt.addProduct(pr2);
        
        //when
        receipt.removeProduct(3);
        
        //then
        //ProductNotFoundException should be thrown
    }

    /**
     * Test of getTotalSum method, of class SimpleReceipt.
     */
    @Test
    public void testGetTotalSum() {
        //given        
        Product pr1 = mock(Product.class);
        when(pr1.getPrice()).thenReturn(1.0f);
        Product pr2 = mock(Product.class);
        when(pr2.getPrice()).thenReturn(2.0f);
        
        receipt.addProduct(pr1);
        receipt.addProduct(pr2);
        
        //when
        float result = receipt.getTotalSum();
        
        //then
        assertEquals("Total sum should be 3.0", 3.0f, result, 0.001f);
    }

    /**
     * Test of getPurchasedProducts method, of class SimpleReceipt.
     */
    @Test
    public void testGetPurchasedProducts() {
        //given        
        Product pr1 = mock(Product.class);
        when(pr1.getName()).thenReturn("PR1");
        Product pr2 = mock(Product.class);
        when(pr2.getName()).thenReturn("PR2");
        
        receipt.addProduct(pr1);
        receipt.addProduct(pr2);
        
        //when
        List<Product> result;
        result = receipt.getPurchasedProducts();
        
        //then
        assertEquals("List should have two elements", 2, result.size());
    }
    
}
