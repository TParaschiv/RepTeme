package com.endava.training.shape.impl;
import com.endava.training.Main;
import com.endava.training.shape.Shape2D;
import com.endava.training.shape.Point;
import java.util.List;
import java.util.ArrayList;
/**
 * Created by tparaschiv on 7/8/2016.
 */
public class Triangle implements Shape2D {

    public List<Point> corners;

    public Triangle(Point c1, Point c2, Point c3) {
        corners = new ArrayList<Point>();
        corners.add(c1);
        corners.add(c2);
        corners.add(c3);
    }

    private double euclidDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
    }

    @Override
    public double computeArea() {
        Point A = corners.get(0);
        Point B = corners.get(1);
        Point C = corners.get(2);
        return Math.abs((A.getX() * (B.getY() - C.getY()) + B.getX() * (C.getY() - A.getY())
                + C.getX() * (A.getY() - B.getY())) / 2);
    }

    @Override
    public double computePerimeter() {
        return euclidDistance(corners.get(0), corners.get(1)) + euclidDistance(corners.get(1), corners.get(2))
                + euclidDistance(corners.get(2), corners.get(0));
    }

    @Override
    public String toString() {
        return "Triangle :";
    }
}
