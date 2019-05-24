package com.masterclass;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-08, 18:14
*/

public class Cylinder extends Circle {
    private double height;
    public Cylinder(double radius, double height) {
        super(radius);
        this.height = Math.max(0, height);
    }
    public double getHeight() {
        return height;
    }
    public double getVolume() {
        return getArea() * getHeight();
    }
}
