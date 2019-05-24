package com.example.collections;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-24, 19:52
*/

public class DogMain {
    public static void main( String[] args ) {
        Labrador rover = new Labrador( "Rover" );
        Dog rover2 = new Dog("Rover");

        System.out.println(rover2.equals( rover ));
        System.out.println(rover.equals( rover2 ));

    }
}
