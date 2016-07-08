package com.endava.training.shape.impl;
import com.endava.training.shape.Shape2D;
import com.endava.training.shape.Point;
import static java.lang.Math.PI;
/**
 * Created by tparaschiv on 7/8/2016.
 */
public class Circle implements Shape2D {

    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double computeArea() {
        return PI * radius * radius;
    }

    @Override
    public double computePerimeter() {
        return 2 * PI * radius;
    }

    @Override
    public String toString() {
        return "Circle :";
    }
}
