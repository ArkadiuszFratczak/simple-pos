package com.cybercom.simple.pos.io;

import com.cybercom.simple.pos.model.Receipt;

/**
 *
 * @author Arkadiusz.Fratczak
 */
public class PrinterStub implements Printer {

    public void print(Receipt receipt) {
        System.out.println("Printer: " + receipt);
    }
    
}
