package com.masterclass;/*
    Another great class by Zjan Preijde
    Creation : 2019-05-13, 18:00
*/

public abstract class Player<T> {
    private String name;

    public Player( String name ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
