package com.cybercom.simple.pos.io;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Arkadiusz.Fratczak
 */
public class BarCodeScannerStub implements BarCodeScanner {
    
    private List<String> scannedCodes;
    private int scanNr;

    public BarCodeScannerStub() {
        scannedCodes = Arrays.asList("000001", "100000", "000002", "",  "000003", "", 
            "000004", "200000", "000006", BarCodeScanner.EXIT_CODE);
    }    

    @Override
    public String scan() {
        return scannedCodes.get(scanNr++ % scannedCodes.size());
    }

    public void setScannedCodes(List<String> scannedCodes) {
        this.scannedCodes = scannedCodes;
        scanNr = 0;
    }
    
}
