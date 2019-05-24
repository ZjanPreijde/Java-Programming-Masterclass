package com.masterclass;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-08, 16:30
*/

public class Wall {
    private double width, height;

    public Wall() {
        this(0, 0);
    }

    public Wall( double width, double height ) {
        this.width  = Math.max(width, 0 );
        this.height = Math.max(height, 0);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth( double width ) {
        this.width = Math.max(width, 0);
    }

    public void setHeight( double height ) {
        this.height = Math.max(height, 0);
    }
    public double getArea() {
        return width * height;
    }
}
