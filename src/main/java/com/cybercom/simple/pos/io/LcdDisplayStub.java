package com.cybercom.simple.pos.io;

/**
 *
 * @author Arkadiusz.Fratczak
 */
public class LcdDisplayStub implements Display {

    public void display(String line) {
        System.out.println("LCD display: " + line);
    }
    
}
