package com.endava.training.examples;

/**
 * Created by tparaschiv on 7/8/2016.
 */
public class ExtendSimple extends Simple {

    public ExtendSimple() {
        super(10);
        System.out.println("Hello from constructor with 0 args");
    }

    public ExtendSimple(int i) {
        super(i);
        System.out.println("Hello from constructor with 1 args");
    }

    public ExtendSimple(int i, int j) {
        super(i);
        System.out.println("Hello from constructor with 2 args");
    }
}
