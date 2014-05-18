package com.cybercom.simple.pos;

import com.cybercom.simple.pos.dao.ProductDaoStub;
import com.cybercom.simple.pos.io.BarCodeScanner;
import com.cybercom.simple.pos.io.BarCodeScannerStub;
import com.cybercom.simple.pos.io.Display;
import com.cybercom.simple.pos.io.LcdDisplayStub;
import com.cybercom.simple.pos.io.Printer;
import com.cybercom.simple.pos.io.PrinterStub;
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
    private PoS pos;
    
    @Before
    public void setUp() {
        display = new LcdDisplayStub();
        printer = new PrinterStub();
        scanner = new BarCodeScannerStub();
        pos = new PoSImpl(new ProductDaoStub(), display, printer);
        
        pos.registerScanner(scanner);
    }
    
    @Test
    public void testPoS() {
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
}
