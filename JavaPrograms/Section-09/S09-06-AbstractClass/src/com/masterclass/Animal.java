package com.masterclass;/*
    Another great class by Zjan Preijde
    Creation : 2019-05-10, 15:30
*/

public abstract class Animal {
    private String name;

    public Animal( String name ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void eat();
    public abstract void breathe();
}
