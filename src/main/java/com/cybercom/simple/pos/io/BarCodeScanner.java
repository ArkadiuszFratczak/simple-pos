package com.cybercom.simple.pos.io;

/**
 *
 * @author Arkadiusz.Fratczak
 */
public interface BarCodeScanner {
    
    /**
     * Scans bar code
     * @return scanned code
     */
    String scan();
}
