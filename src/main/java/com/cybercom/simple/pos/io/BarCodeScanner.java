package com.cybercom.simple.pos.io;

import com.cybercom.simple.pos.PoS;

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
    
    /**
     * Connect to point of sale machine
     * @param pointOfSaleMachine
     */
    void registerPoS(PoS pointOfSaleMachine);
    
}
