package com.cybercom.simple.pos.io;

import com.cybercom.simple.pos.PoS;

/**
 *
 * @author Arkadiusz.Fratczak
 */
public interface BarCodeScanner {    
    
    /**
     * Scans bar code
     */
    void scan();
    
    /**
     * Connect to point of sale machine
     * @param pointOfSaleMachine
     */
    void registerPoS(PoS pointOfSaleMachine);
    
}
