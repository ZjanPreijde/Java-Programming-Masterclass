package com.masterclass;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-10, 15:56
*/

public class Pinguin extends Bird {
    public Pinguin( String name ) {
        super( name );
    }

    @Override
    public void fly() {
        System.out.println("I am not very good at that.");
    }
}
