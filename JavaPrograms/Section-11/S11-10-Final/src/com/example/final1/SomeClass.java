package com.example.final1;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-21, 11:52
*/

public class SomeClass {
    public final int instanceNumber ;
    private static int classCounter = 0;
    private final String name;

    public SomeClass(String name) {
        this.name = name;
        classCounter++;
        instanceNumber = classCounter;
        System.out.println(name + " created, instance is " + instanceNumber);
    }
}
