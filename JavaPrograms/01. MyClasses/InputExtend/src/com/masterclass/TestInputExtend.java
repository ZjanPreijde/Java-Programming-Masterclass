package com.masterclass;
/*
    Another great class by Zjan Preijde
    Creation : 2019-02-04, 14:07
*/

import java.util.ArrayList;

import static com.masterclass.OutputExtend.*;
import static com.masterclass.InputExtend.*;

public class TestInputExtend {
    public static void main( String[] args ) {
        // Go for it buddy!!
        printHeader("Test class InputExtend");

        testInputExtend();

    }

    private static void testInputExtend() {
        String header = "InputExtend TDD Interface";
        ArrayList <String[]> menuOptions;
        menuOptions = new ArrayList <>();
        menuOptions.add( new String[]{"Get integer"        , "", "I"} );
        menuOptions.add( new String[]{"Get String"         , "", "S"} );
        menuOptions.add( new String[]{"Get Yes/No"         , "", "Y"} );
        menuOptions.add( new String[]{"Quick simple menu"  , "", "M"} );
        menuOptions.add( new String[]{"More elaborate menu", "", "N"} );
        menuOptions.add( new String[]{"Exit"               , "", "9"} );
        while ( true ) {
            oln("\n");
            String[] choice = getAMenu( header, menuOptions);
            if ( choice[2].equals( "9" ) ) {
                oln( "->Exit", "\t" );
                break;
            }
            switch ( choice[2] ) {
                case "I":
                    testGetInt();
                    break;
                case "S":
                    testGetString();
                    break;
                case "Y":
                    testGetYesNo();
                    break;
                case "M":
                    testGetMenu();
                    break;
                case "N":
                    testGetAMenu();
                    break;
                default:
                    break;
            }
        }
    }

    private static void testGetInt() {
        oln("\n");
        printHeader( "getInt() test" );
        oln("Test getInt()-1");
        oln( "->" + getInt(), "\t" );
        oln("Test getInt()-2");
        oln( "->" + getInt("\tEnter any integer"), "\t" );
        oln("Test getInt()-3");
        oln( "->" + getInt("\tEnter an integer", true, 3, 6), "\t" );
    }
    private static void testGetString() {
        oln("\n");
        printHeader( "getString() test" );
        oln("Test getString()-1");
        oln("->" + getString(), "\t" );
        oln("Test getString()-2");
        oln( "->" + getString("\tYour text here"), "\t" );
        oln("Test getString()-3");
        oln( "->" + getString("\tYour text here, Case Sensitive"
                , true, "A", "F", false), "\t");
        oln("Test getString()-4");
        oln("->" + getString("\tYour text here, Case Insensitive"
                , true, "A", "F", true), "\t");
    }
    private static void testGetYesNo() {
        oln("\n");
        printHeader("getYesNo() test");
        oln( "Test getYesNo()-1");
        oln( "->" + getYesNo(), "\t");
        oln( "Test getYesNo()-2");
        oln( "->" + getYesNo("\tDo you like to code?"), "\t");
        oln( "Test getYesNo()-3");
        oln( "->" + getYesNo( "\tIs it True or False?", "T", "F"), "\t");
    }

    private static void testGetMenu() {
        oln("\n");
        printHeader("Test getMenu()");
        printHeader("Test getMenu()", true, "-", "-", "\t", "\n");

        ArrayList<String> myMenu1 = new ArrayList <>();
        myMenu1.add( "1. Option 1" );
        myMenu1.add( "2. Option 2" );
        myMenu1.add( "3. Option 3" );
        myMenu1.add( "4. Option 4" );
        myMenu1.add( "5. Option 5" );
        myMenu1.add( "9. Exit" );
        String[] choice = getMenu( "My Menu", myMenu1 );
        oln("Chosen : " + choice[0], "\t");
        printAString( choice, "\t", " ", true ) ;
    }

    private static void testGetAMenu() {
        oln("\n");
        printHeader("Test getAMenu()");

        printHeader("Test getAMenu(), evaluate menu choice"
                , true, "-", "-", "\t", "");
        String header = "Game Interface";
        ArrayList <String[]> menuOptions;
        menuOptions = new ArrayList <>();
        menuOptions.add( new String[]{"Play Tic Tac Toe"   , "tictactoe"  , "3"} );
        menuOptions.add( new String[]{"Play Connect Four"  , "connectfour", "4"} );
        menuOptions.add( new String[]{"Play Connect Five"  , "connectfive", "5"} );
        menuOptions.add( new String[]{"Play Connect Flex"  , "connectflex", "6"} );
        menuOptions.add( new String[]{"Test Game Interface", "game-tdd"   , "8"} );
        menuOptions.add( new String[]{"Exit"               , "exit"       , "9"} );
        while ( true ) {
            String[] choice = getAMenu( header, menuOptions);
            oln("Chosen : " + choice[2], "\t");
            printAString( choice, "\t", " ", true ) ;
            if ( choice[2].equals( "9" ) ) {
                oln( "->Exit", "\t" );
                break;
            }
            switch ( choice[2] ) {
                case "3":
                    oln( "->Tic Tac Toe", "\t"  );
                    break;
                case "4":
                    oln( "->Connect Four", "\t"  );
                    break;
                case "5":
                    oln( "->Connect Five", "\t"  );
                    break;
                case "6":
                    oln( "->Connect Flex", "\t"  );
                    break;
                case "8":
                    oln( "->Test Game Interface", "\t"  );
                    break;
                default:
                    break;
            }
        }
        oln("\n");

        printHeader("Test getAMenu(), evaluate menu code"
                , true, "-", "-", "\t", "");

        menuOptions = new ArrayList<>();
        menuOptions.add( new String[] { "Play Tic Tac Toe"   , "tictactoe"  , "3" } );
        menuOptions.add( new String[] { "Play Connect Four"  , "connectfour", "4" } );
        menuOptions.add( new String[] { "Play Connect Five"  , "connectfive", "5" } );
        menuOptions.add( new String[] { "Play Connect Flex"  , "connectflex", "6" } );
        menuOptions.add( new String[] { "Test Game Interface", "game-tdd"   , "8" } );
        menuOptions.add( new String[] { "Exit"               , "exit"       , "9" } );
        while (true) {
            String[] choice = getAMenu(header, menuOptions );
            oln("Chosen : " + choice[1], "\t");
            printAString( choice, "\t", " ", true ) ;
            if ( choice[1].equals("exit") ) {
                oln( "->Exit", "\t"  );
                break;
            }
            switch (choice[1]) {
                case "tictactoe":
                    oln("->Tic Tac Toe", "\t" );
                    break;
                case "connectfour":
                    oln("->Connect Four", "\t" );
                    break;
                case "connectfive":
                    oln("->Connect Five", "\t" );
                    break;
                case "connectflex":
                    oln("->Connect Flex", "\t" );
                    break;
                case "game-tdd":
                    oln("->Test Game Interface", "\t" );
                    break;
                default:
                    break;
            }
        }

    }
}
