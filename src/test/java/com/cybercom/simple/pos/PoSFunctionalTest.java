package com.cybercom.simple.pos;

import com.cybercom.simple.pos.dao.ProductDao;
import com.cybercom.simple.pos.dao.ProductDaoStub;
import com.cybercom.simple.pos.io.BarCodeScanner;
import com.cybercom.simple.pos.io.BarCodeScannerStub;
import com.cybercom.simple.pos.io.Display;
import com.cybercom.simple.pos.io.LcdDisplayStub;
import com.cybercom.simple.pos.io.Printer;
import com.cybercom.simple.pos.io.PrinterStub;
import com.cybercom.simple.pos.model.Product;
import com.cybercom.simple.pos.model.SimpleProduct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Arkadiusz.Fratczak
 */
public class PoSFunctionalTest {
    
    private Display display;
    private Printer printer;
    private BarCodeScanner scanner;
    private PoSImpl pos;
    
    @Before
    public void setUp() {
        display = new LcdDisplayStub();
        printer = new PrinterStub();
        scanner = new BarCodeScannerStub();
        pos = new PoSImpl(new ProductDaoStub(), display, printer);
        
        pos.registerScanner(scanner);
    }
    
    /*
    * Test how to work PoS with connected stubs of input/output devices.
    * Stubs print info to standard output
    */
    @Test
    public void testOfPoS_scannedProductListHardcodedInScannerStub() {
        System.out.println("---testOfPoS_scannedProductListHardcodedInScannerStub---");
        scanner.scan();
        scanner.scan();
        scanner.scan();
        scanner.scan();
        scanner.scan();
        scanner.scan();
        scanner.scan();
        scanner.scan();
        scanner.scan();
        scanner.scan();            
    }
    
    @Test
    public void testOfPoS_providedScannedProductList() {
        System.out.println("---testOfPoS_providedScannedProductList---");
        
        // Product datastore
        Map<String, Product> products = new HashMap<String, Product>();
        products.put("1", new SimpleProduct("PR1", 1.0f));
        products.put("2", new SimpleProduct("PR2", 2.0f));
        products.put("3", new SimpleProduct("PR3", 3.0f));
        products.put("4", new SimpleProduct("PR4", 4.0f));
        ProductDao dao = new ProductDaoStub(products);
        
        // Scanned product codes
        List<String> codes = new ArrayList<String>();
        codes.add("1");
        codes.add("2");
        codes.add(""); // invalid product code
        codes.add("3");
        codes.add("4");
        codes.add("999999"); // not existing product
        codes.add(PoS.EXIT_CODE); // exit code
        BarCodeScanner providedScanner = new BarCodeScannerStub(codes);
        
        // update pos
        pos.setProductDao(dao);
        pos.registerScanner(providedScanner);
        
        // run scan procedure
        for (int i=0; i<codes.size(); i++) {
            providedScanner.scan();
        }
    }
}
