package com.cybercom.simple.pos.io;

import com.cybercom.simple.pos.PoS;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Arkadiusz.Fratczak
 */
public class BarCodeScannerStub implements BarCodeScanner {
    
    private PoS pointOfSale;
    private List<String> scannedCodes;
    private int scanNr;

    public BarCodeScannerStub() {
        scannedCodes = Arrays.asList("000001", "100000", "000002", "",  "000003", "", 
            "000004", "200000", "000006", PoS.EXIT_CODE);
    }    

    @Override
    public void scan() {
        String productCode = scannedCodes.get(scanNr++ % scannedCodes.size());
        pointOfSale.provideProductCode(productCode);
    }
    
    @Override
    public void registerPoS(PoS pointOfSaleMachine) {
        this.pointOfSale = pointOfSaleMachine;
    }

    public void setScannedCodes(List<String> scannedCodes) {
        this.scannedCodes = scannedCodes;
        scanNr = 0;
    }    
    
}
