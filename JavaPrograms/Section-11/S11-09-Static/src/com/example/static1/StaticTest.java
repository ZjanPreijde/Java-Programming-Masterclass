package com.example.static1;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-21, 10:48
*/

public class StaticTest {
    // Go for it buddy!!
    private static int numInstances = 0;
    private String name;

    public StaticTest( String name ) {
        this.name = name;
        this.numInstances++;
    }

    public static int getNumInstances() {
        return numInstances;
    }

    public String getName() {
        return name;
    }
    public String toString() {
        // Static method available to instance
        return this.name + "\nTotal number of instances : " + getNumInstances();
    }
    public String toString2() {
        // Static variable available to instance
        return this.name + "\nTotal number of instances : " + numInstances;
    }
}
