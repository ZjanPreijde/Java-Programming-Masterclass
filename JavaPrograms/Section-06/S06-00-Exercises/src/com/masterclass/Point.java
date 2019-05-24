package com.masterclass;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-08, 16:37
*/

public class Point {
    private int x, y;

    public Point() {
        this(0, 0);
    }

    public Point( int x, int y ) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX( int x ) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY( int y ) {
        this.y = y;
    }

    public double distance() {
        return distance(0, 0) ;
    }
    public double distance( Point point ) {
        return distance( point.getX(), point.getY() );
    }
    public double distance( int x, int y ) {
        double distance = Math.sqrt(
                (x - this.x) * (x - this.x) + (y - this.y) * (y - this.y)
        ) ;
        return distance;
    }
}
