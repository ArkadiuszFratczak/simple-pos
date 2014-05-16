package com.cybercom.simple.pos;

import com.cybercom.simple.pos.io.Display;
import com.cybercom.simple.pos.io.Printer;

/**
 *
 * @author Arkadiusz.Fratczak
 */
public interface PoS {
    
    /*
    * Defines exit code
    */
    String EXIT_CODE = "exit";
    
    /**
     * Connects to printer
     * @param printer 
     */
    public void registerPrinter(Printer printer);
    
    /**
     * Connects to display
     * @param display 
     */
    public void registerDisplay(Display display);
    
    /**
     * Provides scanned product code to PoS
     * @param productCode 
     */
    public void provideProductCode(String productCode);
    
}
