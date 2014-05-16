package com.cybercom.simple.pos.io;

import com.cybercom.simple.pos.model.Product;
import com.cybercom.simple.pos.model.Receipt;

/**
 *
 * @author Arkadiusz.Fratczak
 */
public class PrinterStub implements Printer {

    public void print(Receipt receipt) {
        StringBuilder receiptPrint = new StringBuilder("Printer: List of purchased products\n");
        for (Product product : receipt.getPurchasedProducts()) {
            receiptPrint.append("Printer: ").append(product).append("\n");
        }
        receiptPrint.append("Printer: Total sum: ").append(receipt.getTotalSum());
        System.out.println(receiptPrint);
    }
    
}
