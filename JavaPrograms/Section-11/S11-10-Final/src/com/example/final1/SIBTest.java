package com.example.final1;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-21, 13:22
*/

public class SIBTest {
    public static final String owner;
    static {
        owner = "Zjan";
        System.out.println("SIBTest static initialization block called");
    }

    public SIBTest() {
        System.out.println("SIB Constructor called");
    }

    static {
        System.out.println("Second initialization block called");
    }

    public void someMethod() {
        System.out.println("someMethod() called");
    }
}
