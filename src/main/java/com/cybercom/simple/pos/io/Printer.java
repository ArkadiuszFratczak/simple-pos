package com.cybercom.simple.pos.io;

import com.cybercom.simple.pos.model.Receipt;

/**
 *
 * @author Arkadiusz.Fratczak
 */
public interface Printer {
    
    /**
     * Prints given receipt
     * @param receipt 
     */
    void print(Receipt receipt);
}
