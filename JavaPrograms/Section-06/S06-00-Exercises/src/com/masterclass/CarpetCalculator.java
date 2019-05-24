package com.masterclass;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-08, 16:55
*/

public class CarpetCalculator {
    private Floor floor;
    private Carpet carpet;

    public CarpetCalculator( Floor floor, Carpet carpet ) {
        this.floor = floor;
        this.carpet = carpet;
    }
    public double getTotalCost() {
        return floor.getArea() * carpet.getCost();
    }
}
