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

    public PoSImpl(ProductDao productDao, Display display, Printer printer) {
        if (productDao == null) {
            throw new RuntimeException("ProductDao may not be null");
        }
        if (display == null) {
            throw new RuntimeException("Display may not be null");
        }
        if (printer == null) {
            throw new RuntimeException("Printer may not be null");
        }
        this.productDao = productDao;
        this.display = display;
        this.printer = printer;
        this.receipt = new SimpleReceipt();
    }

    @Override
    public void registerPrinter(Printer printer) {
        if (printer == null) {
            throw new RuntimeException("Printer should not be null");
        }
        this.printer = printer;
    }

    @Override
    public void registerDisplay(Display display) {
        if (display == null) {
            throw new RuntimeException("Display should not be null");
        }
        this.display = display;
    }
    
    @Override
    public void registerScanner(BarCodeScanner scanner) {
        if (scanner == null) {
            throw new RuntimeException("Scanner should not be null");
        }
        scanner.registerPoS(this);
    }
    
    @Override
    public void provideProductCode(String productCode) {
        if (productCode.isEmpty()) {
            display.display(PoS.INVALID_BAR_CODE);
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
                display.display(PoS.PRODUCT_NOT_FOUND);
            }
        }
    }

    public void setProductDao(ProductDao productDao) {
        if (productDao == null) {
            throw new RuntimeException("ProductDao may not be null");
        }
        this.productDao = productDao;
    }

    private void clearReceipt() {
        this.receipt = new SimpleReceipt();
    }

}
