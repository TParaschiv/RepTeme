package com.endava.training;
import com.endava.training.examples.ExtendSimple;
import com.endava.training.examples.Simple;
import com.endava.training.shape.Point;
import com.endava.training.shape.Shape2D;
import com.endava.training.shape.impl.Circle;
import com.endava.training.shape.impl.Square;
import com.endava.training.shape.impl.Triangle;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tparaschiv on 7/8/2016.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("\n------------ Ex 1 ------------\n");
        System.out.println("Hello OOP");

        List<Shape2D> shapes = new ArrayList<Shape2D>();
        shapes.add(new Circle(new Point(0, 0), 5));
        shapes.add(new Square(new Point(0, 0), 10));
        shapes.add(new Triangle(new Point(1, 0), new Point(5, 0), new Point(3, 5)));

        System.out.println("\n------------ Ex 2 ------------\n");
        for (Shape2D shape : shapes) {
            System.out.println(shape + " Area: " + shape.computeArea());
            System.out.println(shape + " Perimeter: " + shape.computePerimeter());
        }

        System.out.println("\n------------ Ex 3 ------------\n");
        Simple simple = new ExtendSimple();
        simple = new ExtendSimple(1);
        simple = new ExtendSimple(1, 2);

        System.out.println("\n------------ Ex 4 ------------\n");
        A a = new B();
        a.f();
        B b = new C();
        b.f();
        a = new C();
        a.f();
    }
}

/* ------------- Ex 4 and 5 -------------*/
class A {

    public void f() {
        System.out.println("Hello from A");
    }

    public void f (int i) {
        System.out.println("Hello from A - 1 args");
    }

    public void f (int i, int j) {
        System.out.println("Hello from A - 2 args");
    }
}

class B extends A {

    @Override
    public void f() {
        System.out.println("Hello from B");
    }

    @Override
    public void f (int i) {
        System.out.println("Hello from B - 1 args");
    }

    @Override
    public void f (int i, int j) {
        System.out.println("Hello from B - 2 args");
    }
}

class C extends B {

    @Override
    public void f() {
        System.out.println("Hello from C");
    }

    @Override
    public void f (int i) {
        System.out.println("Hello from C - 1 args");
    }

    @Override
    public void f (int i, int j) {
        System.out.println("Hello from C - 2 args");
    }
}