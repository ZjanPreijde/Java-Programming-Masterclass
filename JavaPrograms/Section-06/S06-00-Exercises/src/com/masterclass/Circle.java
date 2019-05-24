package com.masterclass;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-08, 19:02
*/

public class Circle {
    private double radius;
    public Circle(double radius) {
        this.radius = Math.max( 0, radius );
    }
    public double getRadius() {
        return radius;
    }
    public double getArea() {
        return Math.pow( radius, 2) * Math.PI;
    }
}
