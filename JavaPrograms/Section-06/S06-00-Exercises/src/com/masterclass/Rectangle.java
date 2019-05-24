package com.masterclass;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-08, 19:16
*/

public class Rectangle {
    private double width, length;
    public Rectangle( double width, double length ) {
        this.width  = Math.max(0, width);
        this.length = Math.max(0, length);
    }
    public double getWidth() {
        return width;
    }
    public double getLength() {
        return length;
    }
    public double getArea() {
        return getLength() * getWidth();
    }
}
