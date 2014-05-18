package com.cybercom.simple.pos;

import com.cybercom.simple.pos.dao.ProductDao;
import com.cybercom.simple.pos.dao.ProductNotFoundException;
import com.cybercom.simple.pos.io.Display;
import com.cybercom.simple.pos.io.Printer;
import com.cybercom.simple.pos.model.Product;
import com.cybercom.simple.pos.model.Receipt;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;


/**
 *
 * @author Arkadiusz.Fratczak
 */
public class PoSImplTest {
    
    @Mock private ProductDao productDao;
    @Mock private Display display;
    @Mock private Printer printer;
    
    private PoSImpl testedPos;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        testedPos = new PoSImpl(productDao, display, printer);
    }

    /**
     * Test of provideProductCode method, provided product code is invalid
     */
    @Test
    public void testProvideProductCode_productCodeIsEmpty() {
        //given
        String productCode = "";
        
        //when
        testedPos.provideProductCode(productCode);
        
        //then
        verify(display).display(eq(PoS.INVALID_BAR_CODE));
        verifyZeroInteractions(printer);
    }
    
    /**
     * Test of provideProductCode method, provided exit product code
     */
    @Test
    public void testProvideProductCode_exitProductCode() {
        //given
        String productCode = PoS.EXIT_CODE;
        
        //when
        testedPos.provideProductCode(productCode);
        
        //then
        verify(display).display(anyString());
        verify(printer).print(any(Receipt.class));
    }
    
    /**
     * Test of provideProductCode method, given product not found
     */
    @Test
    public void testProvideProductCode_productNotFound() {
        //given
        String productCode = "000001";
        when(productDao.getProduct(anyString())).thenThrow(new ProductNotFoundException());
        
        //when
        testedPos.provideProductCode(productCode);
        
        //then
        verify(display).display(eq(PoS.PRODUCT_NOT_FOUND));
        verifyZeroInteractions(printer);
    }
    
    /**
     * Test of provideProductCode method, given product is found
     */
    @Test
    public void testProvideProductCode_productFound() {
        //given
        String productCode = "000001";
        Product product = mock(Product.class);
        when(productDao.getProduct(eq(productCode))).thenReturn(product);
        
        //when
        testedPos.provideProductCode(productCode);
        
        //then
        verify(display).display(anyString());
        verifyZeroInteractions(printer);
    }
    
}
