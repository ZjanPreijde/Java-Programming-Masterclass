package com.masterclass;
/*
    Another great class by Zjan Preijde
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

// TODO:
// - prefix : should by default be false, more like System.out.print()
// - menu   : bullitize choices, autonumber choices
// - int[]              : printArray false by default
// - String[]           : printArray false by default
// - ArrayList<Integer> : switch newLine and prefix
// - ArrayList<String>  : switch newLine and prefix
public class OutputExtend {

  // QUICK AND DIRTY PASTE, EMBED LATER :
  public static void olt(String text, boolean success) {
      String result = ( success
          ? stringFormat(
              text + " Passed :-)",
              "green")
          : stringFormat(
              "!!! " + text + " !!! FAILED :-(",
              "redbold")
          );
      old(result);
  }
  public static String stringFormat(
                String string
              , String format
          ) {
      String result = string;
      String    red   = "\033[31"
              , green = "\033[32"
              , bold  = ";1"
              , reset = "\033[0"
              , end   = "m";
      switch (format) {
          case "red":
              result = red + end + result;
              break;
          case "green":
              result = green + end + result;
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
  // <- QUICK AND DIRTY PASTE

    /*     System.out.println() short hand     */
    /*        with extra functionality         */
    /* Overloaders */
    public static void oln( String text ) {
        oln( text, true );  // default should be false
    }
    public static void oln( String text, boolean prefix ) {
        oln( text, ( prefix ? "= " : "" ) );
    }
    public static void oln( String text, char prefix ) {
        oln( text, "" + prefix );
    }
    public static void oln( String text, String prefix ) {
        oln( text, prefix, "" );
    }
    public static void oln( String text, char prefix, String suffix ) {
        oln( "" + prefix, text, suffix );
    }
    // Quicky for debugging
    public static void old( String text ) {
      oln( text, "Debug : ", "" );
    }
    /* Print to console */
    public static void oln( String text, String prefix, String suffix ) {
        System.out.println( prefix + text + suffix );
    }

    /*     System.out.println short hand     */
    /*        with extra functionality       */
    /* Overloaders */
    public static void o( String text ) {
        o( text, true ); // default should be false
    }
    public static void o( String text, boolean prefix ) {
        o( text, ( prefix ? "- " : "" ), "" );
    }
    public static void o( String text, char prefix ) {
        o( text, "" + prefix, "" );
    }
    public static void o( String text, String prefix ) {
        o( text, prefix, "" );
    }
    public static void o( String text, boolean prefix, String suffix ) {
        o( text, ( prefix ? "- " : "" ), suffix );
    }
    public static void o( String text, char prefix, String suffix ) {
        o( text, "" + prefix, suffix );
    }
    /* Print to console */
    public static void o( String text, String prefix, String suffix ) {
        System.out.print( prefix + text + suffix );
    }

    // Print int[] array
    /* Overloaders */
    public static void printAInt( int[] array ) {
        printAInt( array, true );  // default should be false
    }
    public static void printAInt( int[] array, boolean printArray ) {
        printAInt( array, printArray, false );
    }
    /* Print to console */
    public static void printAInt( int[] array, boolean printArray, boolean newLine ) {
        if ( printArray ) {
            // -> [0, 1, 2, 3, ...]
            oln( Arrays.toString( array ), "");
        } else {
            for ( int i : array ) {
                if ( newLine ) {
                    oln( "" + i, "" );
                } else {
                    o( "" + i, "" );
                }
            }
            if ( !newLine ) oln( "", "" );
        }
    }

    // Print int[] array  -> ["a", "b", "c", ...]
    /* Overloaders */
    public static void printAString( String[] array ) {
        printAString( array, true ); // default should be false
    }
    public static void printAString( String[] array, boolean printArray ) {
        printAString( array, printArray, false );
    }
    /* Print to console */
    public static void printAString( String[] array, boolean printArray, boolean newLine ) {
        if ( printArray ) {
            // -> ["a", "b", "c", ...]
            oln( Arrays.toString( array ), "");
        } else {
            for ( String s : array ) {
                if ( newLine ) {
                    oln( s, "" );
                } else {
                    o( s, "" );
                }
            }
            if ( !newLine ) oln( "", "" );
        }
    }

    // ArrayList
    // Print ArrayList<Integer>
    /* Overloaders */
    public static void printALInteger( ArrayList<Integer> array ) {
        printALInteger( array, true );
    }
    public static void printALInteger( ArrayList<Integer> array,  boolean newLine ) {
        printALInteger( array, newLine, "" );
    }
    /* Print to console */
    public static void printALInteger( ArrayList<Integer> array, boolean newLine, String prefix ) {
        array.forEach( element -> {
            if ( newLine ) {
                oln( "" + element, prefix );
            } else {
                o( "" + element, prefix );
            }
        } );
        if ( !newLine ) oln( "", "" );
    }

    // Print ArrayList<String>
    /* Overloaders */
    public static void printALString( ArrayList<String> array ) {
        printALString( array, "- " );
    }
    public static void printALString( ArrayList<String> array, String prefix ) {
        printALString( array, prefix, true );
    }
    public static void printALString( ArrayList<String> array, String prefix
            , boolean newLine ) {
        printALString( array, prefix, newLine, "" );
    }
    /* Print to console */
    public static void printALString( ArrayList<String> array, String prefix
            , boolean newLine, String suffix ) {
        array.forEach( element -> {
            if ( newLine ) {
                oln( element, prefix );
            } else {
                o( element, prefix );
            }
        } );
        if ( !newLine ) oln( "", "" );
    }

    // LinkedList
    // Print LinkedList<String>
    /* Overloaders */
    public static void printLLString( LinkedList<String> list ) {
        printLLString( list, "- " );
    }
    public static void printLLString( LinkedList<String> list
            , String prefix ) {
        printLLString( list, prefix, true );
    }
    public static void printLLString( LinkedList<String> list
            , String prefix, boolean newLine ) {
        printLLString( list, prefix, newLine, "" );
    }
    /* Print to console */
    public static void printLLString( LinkedList<String> list, String prefix
            , boolean newLine, String suffix ) {
        Iterator <String> iterator = list.iterator();
        while ( iterator.hasNext() ) {
            if ( newLine ) {
                oln( iterator.next(), prefix );
            } else {
                o( iterator.next(), prefix );
            }
        }
    }
}
