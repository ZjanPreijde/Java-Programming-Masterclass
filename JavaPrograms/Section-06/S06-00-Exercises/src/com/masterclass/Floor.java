package com.masterclass;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-08, 16:50
*/

public class Floor {
    double width, length;

    public Floor( double width, double length ) {
        this.width  = Math.max(0, width);
        this.length = Math.max(0, length);
    }
    public double getArea() {
        return width * length;
    }
}
