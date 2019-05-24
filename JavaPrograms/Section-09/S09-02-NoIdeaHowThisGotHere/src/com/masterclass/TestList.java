package com.masterclass;
/*
    Another great class by Zjan Preijde
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class TestList {
    public static void main( String[] args ) {
        // Go for it buddy!!
        vectorTest();
    }

    private static void vectorTest() {
        System.out.println( "Testing List class without content type Class" );
        System.out.println( "Lists can hold different data types : " );

        List test = new ArrayList();
        List test2 = new LinkedList();

        test2.add("printInLine");
        test2.add(true);

        test.add( 1 );
        test.add( "One" );
        test.add( '1' );
        test.add( 10001L );
        test.add( 10.01d );
        test.add( 3.1415f );
        test.add( test2 );

        System.out.println( "Lists can hold different data types : " );
        System.out.println( test );
        for ( int i = 0; i < test.size(); i++ ) {
            System.out.println( "-> " + test.get( i ) );
        }

//        List<String> test3 = new ArrayList <>(  );
//        test3.add( 3 ); // -> Error
//        ArrayList test3 = new ArrayList <>(  );
//        test3.add( 3 ); // -> OK


    }
}
