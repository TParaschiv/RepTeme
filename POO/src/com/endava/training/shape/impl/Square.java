package com.endava.training.shape.impl;
import com.endava.training.shape.Shape2D;
import com.endava.training.shape.Point;
/**
 * Created by tparaschiv on 7/8/2016.
 */
public class Square implements Shape2D {

    private Point center;
    private double length;

    public Square(Point center, double length) {
        this.center = center;
        this.length = length;
    }

    @Override
    public double computeArea() {
        return this.length * this.length;
    }

    @Override
    public double computePerimeter() {
        return 4 * this.length;
    }

    @Override
    public String toString() {
        return "Square :";
    }
}
