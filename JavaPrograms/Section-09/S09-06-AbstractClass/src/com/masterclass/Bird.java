package com.masterclass;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-10, 15:48
*/

public abstract class Bird extends Animal implements CanFly{
    public Bird( String name ) {
        super( name );
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is pecking");
    }

    @Override
    public void breathe() {
        System.out.println("Breathe in, breathe out, repeat");
    }

    @Override
    public void fly() {
        System.out.println("Flying away and back");
    };
}
