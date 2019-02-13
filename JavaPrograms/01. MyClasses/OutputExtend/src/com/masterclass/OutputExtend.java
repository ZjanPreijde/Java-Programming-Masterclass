package com.masterclass;
/*
    Another great class by Zjan Preijde
*/
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import static com.masterclass.ArrayExtend.*;

// TODO Done: System.out shorthands : default prefix to ""

// TODO:
//  menu           : bullitize choices, autonumber choices, autoprefix choices?
//  menu           : default printArray to false, newLine to true
//  oln(), o()     : remove empty prefix where used in code
//  oln(), o()     : rename to printLn(), print() in code, or keep shorthand?
//  stringFormat() : create StringExtend class and move there
//  phase out usage of olr(). Replace in code with printResult()
//  phase out usage of olt()? Replace in code with printTestResult()
//  remove the char overloaders? chars can be passed as "" + \ u xxxx
// - ArrayList<Integer> : switch newLine and prefix
// - ArrayList<String>  : switch newLine and prefix

// printString() is the only one method doing the actual System.out.print() / .println()

public class OutputExtend {

    /* Overloaders */
    public static void printString( String text) {
        printString( text, "");
    }
    public static void printString( String text, String prefix ) {
        printString( text, prefix, "");
    }
    public static void printString( String text, String prefix, String suffix, boolean inLine ) {
        // Only method that actually does output!
        if ( inLine ) {
            System.out.print( prefix + text + suffix );
        } else {
            System.out.println( prefix + text + suffix );
        }
    }

    /* Overloader */
    public static void printHeader( String header ) {
        printHeader( header, true, "=", "-", "", "");
    }
    public static void printHeader( String header, boolean boxIt
            , String top, String bottom, String prefix, String suffix ) {
        if ( boxIt ) {
            printAString( stringBoxIt( header, top, bottom, prefix, suffix ) );
        } else {
            printString( header );
        }
    }
    // If I ever build a StringExtend class,
    //    stringFormat() and stringBoxIt() can go there.

    //  http://www.santhoshreddymandadi.com/java/coloring-java-output-on-console.html
    //  https://en.wikipedia.org/wiki/ANSI_escape_code#Escape_sequences
    public static String stringFormat(
            String string
            , String format
    ) {
        // Only green, red, redbold for now
        String result = string;
        String    black  = "\033[30" // default
                , red    = "\033[31" // Bright Red   =91, normal = 31
                , green  = "\033[32" // Bright Green =92, normal = 32
                , yellow = "\033[33" // Bright Yellow=93, normal = 33
                , blue   = "\033[34" // Bright Blue  =94, normal = 34
                , bold   = ";1", italics = ";3", underLine = ";4", blink = ";5", strikeThrough = ";9"
                , reset  = "\033[0"
                , end    = "m";
        switch (format) {
            case "green":
                result = green + end + result;
                break;
            case "red":
                result = red + end + result;
                break;
            case "redbold":
                result = red + bold + end + result;
                break;
            default:
                break;
        }
        result += reset + end;
        return result;
    }

    public static String[] stringBoxIt( String string
            , String top, String bottom, String prefix, String suffix ){
        String[] result = new String[3];
        result[0] = top.repeat(string.length() + 4);
        result[1] = "| " + string + " |";
        result[2] = bottom.repeat(string.length() + 4);
        result    = arrayTableBeautify( result );
        result[0] = prefix + result[0];
        result[1] = prefix + result[1];
        result[2] = prefix + result[2] + suffix;
        return result;
    }

    public static void printString( String text, String prefix, String suffix ) {
        printString( text, prefix, suffix, false);
    }
    // Generic print result in color
    public static void printResult( String text, boolean success) {
        printResult( text, success, false);
    }
    public static void printResult( String text, boolean success, boolean debug) {
        String result = ( success
                ? stringFormat(text,"green")
                : stringFormat(text,"redbold")
        );
        if ( debug ) { old( result ); } else { printString( result ); }
    }

    public static void printTestResult( String text, boolean success) {
        text += ( success ? " Passed :-)" : " !!! FAILED !!! :-(" );
        printResult( text, success, true );
    }

    /*     System.out.println() short hand     */
    /*        with extra functionality         */
    /* Overloaders */
    public static void oln( String text ) {
        printString( text, "", "", false );
    }
    public static void oln( String text, boolean prefix ) {
        // Use default prefix for oln()
        printString( text, ( prefix ? "= " : "" ), "", false );
    }
    public static void oln( String text, String prefix ) {
        printString( text, prefix, "", false );
    }
    /* Print to console */
    public static void oln( String text, String prefix, String suffix ) {
        printString( text, prefix, suffix, false );
    }

    /*     System.out.println short hand     */
    /*        with extra functionality       */
    /* Overloaders */
    public static void o( String text ) {
        printString( text, "", "", true );
    }
    public static void o( String text, boolean prefix ) {
        // Use default prefix for o()
        printString( text, ( prefix ? "- " : "" ), "", true );
    }
    public static void o( String text, String prefix ) {
        printString( text, prefix, "" , true);
    }
    public static void o( String text, String prefix, String suffix ) {
        printString( text, prefix, suffix, true );
    }

    // Quicky for debugging
    public static void old( String text ) {
        old( text, false );
    }
    public static void old( String text, boolean inLine ) {
        printString( text, "Debug : ", "", inLine);
    }

    // Print TDD test result while debugging
    public static void olt( String text, boolean success ) {
        printTestResult( text, success );
    }

    // Generic print result in color
    public static void olr(String text, boolean success) {
        printResult( text, success, false);
    }
    public static void olr(String text, boolean success, boolean debug) {
        printResult( text, success, debug );
    }

    /* Print int[] */
    /* Overloaders */
    public static void printAInt( int[] array ) {
        printAInt( array, "" );
    }
    public static void printAInt( int[] array, String prefix ) {
        printAInt( array, prefix, "" );
    }
    public static void printAInt( int[] array, String prefix, String suffix ) {
        printAInt( array, prefix, "", false );
    }
    /* Print to console */
    public static void printAInt( int[] array, String prefix, String suffix, boolean inLine ) {
        for ( int i : array ) {
            printString( "" + i, prefix, suffix, inLine );
        }
        if ( inLine ) printString( "" ); // When done printing inline, go to next line
    }

    /* print String[] */
    /* Overloaders */
    public static void printAString( String[] array ) {
        printAString( array, "" );
    }
    public static void printAString( String[] array, String prefix ) {
        printAString( array, prefix, "" );
    }
    public static void printAString( String[] array, String prefix, String suffix ) {
        printAString( array, prefix, suffix, false );
    }
    /* Print to console */
    public static void printAString( String[] array, String prefix, String suffix, boolean inLine ) {
        for ( String s : array ) {
            printString( s, prefix, suffix, inLine );
        }
        if ( inLine ) printString( "" ); // When done printing inline, go to next line
    }

    // ArrayLists
    /* Print ArrayList<Integer> */
    /* Overloaders */
    public static void printALInteger( ArrayList<Integer> array ) {
        printALInteger( array, "" );
    }
    public static void printALInteger( ArrayList<Integer> array,  String prefix ) {
        printALInteger( array, prefix, "" );
    }
    public static void printALInteger( ArrayList<Integer> array,  String prefix, String suffix ) {
        printALInteger( array, prefix, suffix, false );
    }
    /* Print to console */
    public static void printALInteger( ArrayList<Integer> array, String prefix, String suffix, boolean inLine ) {
        array.forEach( element -> {
            printString( "" + element, prefix, suffix, inLine );
        } );
        if ( inLine ) oln( "", "" ); // When done printing inline, go to next line
    }

    /* Print ArrayList<String> */
    /* Overloaders */
    public static void printALString( ArrayList<String> array ) {
        printALString( array, "" );
    }
    public static void printALString( ArrayList<String> array, String prefix ) {
        printALString( array, prefix, "" );
    }
    public static void printALString( ArrayList<String> array, String prefix, String suffix) {
        printALString( array, prefix, suffix, false );
    }
    /* Print to console */
    public static void printALString( ArrayList<String> array, String prefix, String suffix, boolean inLine ) {
        array.forEach( element -> {
            printString( element, prefix, suffix, inLine );
        } );
        if ( inLine ) oln( "", "" ); // When done printing inline, go to next line
    }

    // LinkedLists
    /* Print LinkedList<String> */
    /* Overloaders */
    public static void printLLString( LinkedList<String> list ) {
        printLLString( list, "" );
    }
    public static void printLLString( LinkedList<String> list, String prefix ) {
        printLLString( list, prefix, "");
    }
    public static void printLLString( LinkedList<String> list, String prefix, String suffix ) {
        printLLString( list, prefix, suffix, false );
    }
    /* Print to console */
    public static void printLLString( LinkedList<String> list, String prefix, String suffix, boolean inLine ) {
        Iterator <String> iterator = list.iterator();
        while ( iterator.hasNext() ) {
            printString( iterator.next(), prefix, suffix, inLine );
        }
        if ( inLine ) oln( "", "" ); // When done printing inline, go to next line
    }
}
