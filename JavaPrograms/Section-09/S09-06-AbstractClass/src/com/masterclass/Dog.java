package com.masterclass;/*
    Another great class by Zjan Preijde
    Creation : 2019-05-10, 15:36
*/

public class Dog extends Animal {
    public Dog( String name ) {
        super( name );
    }

    @Override
    public void eat() {
        System.out.println(this.getName() + " is eating");
    }

    @Override
    public void breathe() {
        System.out.println("Breathe in, breathe out, repeat");
    }
}
