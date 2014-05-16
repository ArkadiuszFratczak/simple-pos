package com.cybercom.simple.pos.io;

/**
 *
 * @author Arkadiusz.Fratczak
 */
public interface BarCodeScanner {
    
    String EXIT_CODE = "exit";
    
    /**
     * Scans bar code
     * @return scanned code
     */
    String scan();
}
