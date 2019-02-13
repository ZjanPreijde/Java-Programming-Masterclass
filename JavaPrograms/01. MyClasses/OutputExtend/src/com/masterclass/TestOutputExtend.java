package com.masterclass;
/*
    Another great class by Zjan Preijde
*/
// TODO, test new olt(), printResult() and stringFormat() methods
//       print header using ArrayExtend.arrayTableBeautify()

import java.util.ArrayList;
import java.util.LinkedList;

import static com.masterclass.OutputExtend.*;

public class TestOutputExtend {

    public static void main( String[] args ) {
        printHeader( "  OutputExtend Class - TDD  " );
//        oln( "============================", "\t" );
//        oln( "|  OutputExtend Class TDD  |", "\t" );
//        oln( "----------------------------", "\t", "\n\n" );
        oln( "", "", "\n");
        // TDD OK
        testOutputExtend01();
        // TDD OK
        testOutputExtend02();
    }

    private static void testOutputExtend01() {
        printString( "* String printing shorthand functions" );
        printHeader( "Test function oln(" + '\u21B5' + ")" );

        oln( "Hi there" );
        oln( "Hi there", true );
        oln( "Hi there", "\t" );
        oln( "Hi there", "\t\t", ", how is life?" );


        printHeader( "Test function o(" + '\u2192' + ")" );

        o( "Hiiiii" );
        oln( "" );
        o( "Hiiiii", true );
        oln( "" );
        o( '\u203B' + "Hiiiii", false );
        oln( "" );
        o( "Hiiiii", "" + '\u2E16' );
        oln( "" );
        o( "Hiiiii", '\u260E' + " ", " " + '\u260E' + "\n" );

        o( "This " );
        o( "text " );
        o( "is " );
        o( "written " );
        o( "one " );
        o( "word " );
        o( "at " );
        o( "the " );
        o( "time", "", ".\n" + ("    " + '\u2668').repeat( 10 ) + "\n" );
    }

    private static void testOutputExtend02() {
        oln( "* Array/ArrayList/LinkedList printing functions", "\n" );

        printHeader( "Test function printAInt( int[] )" );
        int[] myInts1 = new int[] { 1, 2, 3, 4, 5 } ;

        printAInt( myInts1 );
        oln( "" );
        printAInt( myInts1, "", "-", true );
        oln( "");
        printAInt( myInts1, ">", "<", false);
        oln( "");

        printHeader( "Test function printAString( String[] )" );
        String[] myStrings1 = new String[]
                { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };

        printAString( myStrings1 );
        oln( "" );
        printAString( myStrings1, "", "-", true);
        oln( "" );
        printAString( myStrings1, ">", "<");
        oln( "" );

        /*     printALInteger()     */
        printHeader( "Test function printALInteger(ArrayList <Integer )" );
        ArrayList<Integer> myIntegers = new ArrayList<>();
        myIntegers.add( 10 ); myIntegers.add( 20 ); myIntegers.add( 30 ); myIntegers.add( 40 ); myIntegers.add( 50 );

        printALInteger( myIntegers );
        oln( "" );
        printALInteger( myIntegers, "", "-", true);
        oln( "" );
        printALInteger( myIntegers, "" + '\u22C6' + " " );
        oln( "" );
        printALInteger( myIntegers, ">", "<");
        oln( "" );

        /*     printALString()     */
        printHeader( "Test function printALString( ArrayList<String> )" );
        ArrayList<String> myStrings2 = new ArrayList<>();
        myStrings2.add( "January" ); myStrings2.add( "February" ); myStrings2.add( "March" );
        myStrings2.add( "April" );   myStrings2.add( "May" );      myStrings2.add( "June" );

        printALString( myStrings2 );
        oln( "" );
        printALString( myStrings2, "", "-", true );
        oln( "" );
        printALString( myStrings2, "" + " " + '\u22C6' + " " );
        oln( "" );
        printALString( myStrings2, ">", "<", false );
        oln( "" );


        /*     printLLString()     */
        printHeader( "Test function printLLString( LinkedList<String> )" );
        LinkedList<String> myStrings3 = new LinkedList<>();
        myStrings3.add( "July" );    myStrings3.add( "August" );   myStrings3.add( "September" );
        myStrings3.add( "October" ); myStrings3.add( "November" ); myStrings3.add( "December" );

        printLLString( myStrings3 );
        oln( "" );
        printLLString( myStrings3, "", "-", true );
        oln( "" );
        printLLString( myStrings3, "" + '\u22C6' + " " );
        oln( "" );
        printLLString( myStrings3, ">", "<", false );
        oln( "" );
    }
}
