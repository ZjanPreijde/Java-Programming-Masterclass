package com.example.final1;

public class Main {

    public static void main(String[] args) {
	    SomeClass sc1 = new SomeClass( "One" );
        SomeClass sc2 = new SomeClass( "Two" );
        SomeClass sc3 = new SomeClass( "Three" );
        SomeClass sc4 = new SomeClass( "Four" );

        System.out.println(sc1.instanceNumber);
//        sc1.instanceNumber = 5; // impossible, instanceNumber is final

        System.out.println("-----------");
        System.out.println(Math.PI);
//        class MyMath extends Math { } // impossible, class Math is final
//        Math m = new Math(); // impossible, class has empty private constructor

        System.out.println("-----------");
        Password pw = new Password(100000);
        pw.storePassword();
        System.out.println("Let Me in : " + pw.letMeIn(100000));
        System.out.println("Let Me in : " + pw.letMeIn(100001));

        ExtendedPassword xpw = new ExtendedPassword( 1000000 );
        xpw.storePassword();

        System.out.println("-----------");

        System.out.println("Main method called");
        SIBTest sib = new SIBTest();
        sib.someMethod();
        System.out.println("Owner = " + SIBTest.owner);
    }
}
