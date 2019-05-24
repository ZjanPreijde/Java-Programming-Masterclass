package com.masterclass;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-08, 16:53
*/

public class Carpet {
    private double cost;

    public Carpet( double cost ) {
        this.cost = Math.max(0, cost);
    }

    public double getCost() {
        return cost;
    }
}
