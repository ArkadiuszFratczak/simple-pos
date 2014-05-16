package com.cybercom.simple.pos;

import com.cybercom.simple.pos.dao.ProductDao;
import com.cybercom.simple.pos.dao.ProductNotFoundException;
import com.cybercom.simple.pos.io.BarCodeScanner;
import com.cybercom.simple.pos.io.Display;
import com.cybercom.simple.pos.io.Printer;
import com.cybercom.simple.pos.model.Product;
import com.cybercom.simple.pos.model.Receipt;
import com.cybercom.simple.pos.model.SimpleReceipt;

/**
 *
 * @author Arkadiusz.Fratczak
 */
public class PoSImpl implements PoS {
    
    private ProductDao productDao;
    private Printer printer;
    private Display display;
    
    private Receipt receipt;

    public PoSImpl(ProductDao productDao) {
        this.productDao = productDao;
        this.receipt = new SimpleReceipt();
    }

    @Override
    public void registerPrinter(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void registerDisplay(Display display) {
        this.display = display;
    }
    
    @Override
    public void registerScanner(BarCodeScanner scanner) {
        scanner.registerPoS(this);
    }
    
    @Override
    public void provideProductCode(String productCode) {
        if (productCode.isEmpty()) {
            display.display("Invalid bar-code");
        } else if (productCode.equalsIgnoreCase(PoS.EXIT_CODE)) {
            display.display("Total sum: " + receipt.getTotalSum());
            printer.print(receipt);
            clearReceipt();
        } else {
            try {
                Product product = productDao.getProduct(productCode);
                receipt.addProduct(product);
                display.display(product.toString());
            } catch (ProductNotFoundException ex) {
                display.display("Product not found");
            }
        }
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    private void clearReceipt() {
        this.receipt = new SimpleReceipt();
    }

}
