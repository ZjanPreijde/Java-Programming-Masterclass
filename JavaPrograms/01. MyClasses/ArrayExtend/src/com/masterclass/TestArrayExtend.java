package com.masterclass;
/*
    Another great class by Zjan Preijde
*/

import java.util.ArrayList;

import static com.masterclass.ArrayExtend.*;
// TODO: Add arrays for TicTacToe
// TODO: Build a menu, show an array, choose an array?
// TODO: Tests for new methods arrayTableBeautify(), arrayCompare()!
import static com.masterclass.InputExtend.*; // For menu
import static com.masterclass.OutputExtend.*;
import static com.masterclass.ArrayExtend.*;

public class TestArrayExtend {
    // Not enought knowledge yet :-)
    // public static Array<String, String, String[]> arrays = new Array<>() getArrays();
    public static String[] table, tableGoal, tableResult;
    public static ArrayList<String[]> tests, runTests;
    public static boolean[] results;

    public static String[] flippedArray;
    public static String[] array1 = new String[] {
            "0-0-0-0",
            "-0-0-0-",
            "0-0-0-0",
            "-0-0-0-" };
    public static String[] array2 = new String[] {
            "123456",
            "123456",
            "123456",
            "123456",
            "123456" };
    public static String[] array3 = new String[] {
            "1......2",
            ".O....X.",
            "..O..X..",
            "...OX...",
            "...XO...",
            "..X..O..",
            ".X....O.",
            "3......4" };
    public static String[] array4 = new String[] {
            "A      B",
            " O    X",
            "  O  X",
            "   OX",
            "   XO",
            "  X  O",
            " X    O",
            "C      D" };
    public static String[] array5 = new String[] {
            "123",
            "456",
            "789" };
    // After rebuild Connect to Rows, these should be switched
    public static String[] horizontalWin = new String[] {
            "    ",
            "    ",
            "    ",
            "XXX ",
            "OOOO" };
    public static String[] verticalWin = new String[] {
            "    ",
            "X   ",
            "XO  ",
            "XO  ",
            "XO  " };
    public static String[] forwardWin = new String[] {
            "   X",
            "  XO",
            " XOO",
            "XXOO" };
    public static String[] backwardWin = new String[] {
            "X   ",
            "OX  ",
            "OOX ",
            "OXOX" };


    public static void main( String[] args ) {
        printHeader("Test class ArrayExtend");

        testArrayExtend();
    }


    private static void testArrayExtend(  ) {
        // Go for it buddy!!

        String header = "ArrayExtend TDD Interface";
        ArrayList <String[]> menuOptions;
        menuOptions = new ArrayList <>();
        menuOptions.add( new String[]{"Test flipArray()", "", "F"} );
        menuOptions.add( new String[]{"Test Connect-4 wins", "", "C"} );
        menuOptions.add( new String[]{"Test arrayTableBeautify()", "", "B"} );
        menuOptions.add( new String[]{"Exit", "", "9"} );
        while ( true ) {
            oln( "\n" );
            String[] choice = getAMenu( header, menuOptions );
            if ( choice[2].equals( "9" ) ) {
                oln( "->Exit", "\t" );
                break;
            }
            switch ( choice[2] ) {
                case "F":
                    testArrayFlip();
                    break;
                case "C":
                    testC4Wins();
                    break;
                case "B":
                    testArrayTableBeautify();
                    break;
                default:
                    break;
            }
        }
    }
    private static void testArrayFlip() {
        flipIt( array1 );
        flipIt( array2 );
        flipIt( array3 );
        flipIt( array4 );
        flipIt( array5 );
        flipIt( horizontalWin );
        flipIt( verticalWin );
        flipIt( forwardWin );
        flipIt( backwardWin );
    }
    public static void flipIt( String[] array ) {
        oln("---------------", "\n");
        oln("Array to flip" );
        printAString( array );

        oln("---------------", "\n");
        oln("Flipped 180" + '\u00B0' + " :" );
        flippedArray = arrayFlip( array, "halfcircle" );
        printAString( flippedArray );

        oln("---------------", "\n");
        oln("Flipped 90" + '\u00B0' + " :" );
        flippedArray = arrayFlip( array, "forward");
        printAString( flippedArray );

        oln("---------------", "\n");
        oln("Flipped -90" + '\u00B0' + " :" );
        flippedArray = arrayFlip( array, "backward");
        printAString( flippedArray );

        oln("---------------", "\n");
        oln("Flipped 45" + '\u00B0' + " :" );
        flippedArray = arrayFlip( array, "forward45" );
        printAString( flippedArray );

        oln("---------------", "\n");
        oln("Flipped -45" + '\u00B0' + " :" );
        flippedArray = arrayFlip( array, "backward45" );
        printAString( flippedArray );

    }

    private static void testC4Wins() {
        oln("\n");
        printHeader("Test winning ConnectFour sequences");
        oln("\n");

        printHeader("Vertical win check"
                , true, "-", "-", "", "");
        oln("---------------", "\n");
        oln("Array to check" );
        oln( "->");
        printAString( verticalWin );
        oln( "<-");
        oln( "Check for win :");
        oln( "->");
        printAString( arrayFlip( verticalWin, 90 ) );
        oln( "<-");

        oln("\n");

        printHeader("Horizontal win check"
                , true, "-", "-", "", "");
        oln("---------------", "\n");
        oln("Array to check" );
        oln( "->");
        printAString( horizontalWin );
        oln( "<-");
        oln( "Check for win :");
        oln( "->");
        printAString( horizontalWin );
        oln( "<-");

        oln("\n");

        printHeader("Diagonal forward win check"
                , true, "-", "-", "", "");
        oln("---------------", "\n");
        oln("Array to check" );
        oln( "->");
        printAString( forwardWin );
        oln( "<-");
        oln( "Check for win :");
        oln( "->");
        printAString( arrayFlip( forwardWin, 45 ) );
        oln( "<-");

        oln("\n");

        printHeader("Diagonal backward win check"
                , true, "-", "-", "", "");
        oln("---------------", "\n");
        oln("Array to check" );
        oln( "->");
        printAString( backwardWin );
        oln( "<-");
        oln( "Check for win :");
        oln( "->");
        printAString( arrayFlip( backwardWin, -45 ) );
        oln( "<-");

        oln("\n");
    }

    private static void testArrayTableBeautify() {
        String[] choices;
        initTests();

        while ( true ) {
            choices = testMenu( tests );
            if (choices[1] == "quit") {
                break;
            }
            doTests( choices );
        }
    }

    private static void doTests( String[] choices ) {
        runTests = new ArrayList<>();
        if ( choices[1] == "all" ) {
            tests.forEach( test -> {
                if ( test[1] != "all" && test[1] != "quit" ) runTests.add( test );
            });
        } else {
            runTests.add( choices );
        }
        results = new boolean[ runTests.size() ];
        // I need the index for results[], no .forEach()
        for (int i = 0; i < runTests.size(); i++) {
            switch (runTests.get(i)[1]) {
                case "connect-four":
                    results[i] = testConnect();
                    break;
                case "tictactoe":
                    results[i] = testTicTacToe();
                    break;
                case "header":
                    results[i] = testHeader();
                    break;
                case "totals":
                    results[i] = testTotals();
                    break;
                case "invalid-table":
                    results[i] = testInvalid();
                    break;
                case "one-row":
                    results[i] = testOneRow();
                    break;
                case "one-column":
                    results[i] = testOneColumn();
                    break;
                case "one-cell":
                    results[i] = testOneCell();
                    break;
                case "complicated":
                    results[i] = testComplicated();
                    break;
                default:
                    break;
            }
        }
        oln("Test results :", "\n");
        for ( int i = 0; i < runTests.size(); i++) {
            olt( runTests.get( i )[0], results[i] );
        }
    }

    private static ArrayList<String[]> initTests() {
        tests = new ArrayList<>();
        tests.add( new String[]{"Connect Four     ", "connect-four" , "1"});
        tests.add( new String[]{"Tic Tac Toe      ", "tictactoe"    , "2"});
        tests.add( new String[]{"Header           ", "header"       , "3"});
        tests.add( new String[]{"Totals           ", "totals"       , "4"});
        tests.add( new String[]{"Invalid table    ", "invalid-table", "5"});
        tests.add( new String[]{"One row          ", "one-row"      , "6"});
        tests.add( new String[]{"One skinny column", "one-column"   , "7"});
        tests.add( new String[]{"One cell         ", "one-cell"     , "8"});
        tests.add( new String[]{"Complicated      ", "complicated"  , "C"});
        tests.add( new String[]{"Run all tests"    , "all"          , "A"});
        tests.add( new String[]{"Exit"             , "quit"         , "Q"});
        return tests;
    }

    private static String[] testMenu( ArrayList<String[]> tests ) {
        // All for now
        oln("\n");
        printHeader("arrayTableBeautify method TDD");
        oln("\n");
        return getAMenu( "Available tests:", tests );
    }

    private static void testPrint(
            String[] table
            , String[] tableGoal
            , String[] tableResult
    ) {
        oln("--------------", "\n");
        oln( "Translate this :", "" );
        printAString( table, "", "" );
        oln( " - into this :", "" );
        printAString( tableGoal, "", "" );
        oln( " - result :", "" );
        tableResult = translateTable( table, tableGoal );
        printAString( tableResult, "", "" );
        olt("", arrayCompare( tableGoal, tableResult ) );
        oln("==============", "");
    }


    private static boolean testConnect() {
        table = new String[]{
                "-----------------------------",
                "|   |   |   |   |   |   |   |",
                "-----------------------------",
                "|   |   |   |   |   |   |   |",
                "-----------------------------",
                "|   |   |   | ■ |   |   |   |",
                "-----------------------------",
                "|   | ◯ | ■ | ■ |   |   |   |",
                "-----------------------------",
                "|   | ■ | ◯ | ◯ |   |   |   |",
                "-----------------------------",
                "| ■ | ◯ | ■ | ◯ |   |   |   |",
                "-----------------------------",
        };
        tableGoal = new String[]{
                "┌───┬───┬───┬───┬───┬───┬───┐",
                "│   │   │   │   │   │   │   │",
                "├───┼───┼───┼───┼───┼───┼───┤",
                "│   │   │   │   │   │   │   │",
                "├───┼───┼───┼───┼───┼───┼───┤",
                "│   │   │   │ ■ │   │   │   │",
                "├───┼───┼───┼───┼───┼───┼───┤",
                "│   │ ◯ │ ■ │ ■ │   │   │   │",
                "├───┼───┼───┼───┼───┼───┼───┤",
                "│   │ ■ │ ◯ │ ◯ │   │   │   │",
                "├───┼───┼───┼───┼───┼───┼───┤",
                "│ ■ │ ◯ │ ■ │ ◯ │   │   │   │",
                "└───┴───┴───┴───┴───┴───┴───┘"
        };
        tableResult = translateTable( table, tableGoal );
        testPrint( table, tableGoal, tableResult );
        return arrayCompare(tableResult, tableGoal);
    } // <- testConnect

    private static boolean testTicTacToe() {
        table = new String[]{
                "-------------",
                "| X |   | X |",
                "-------------",
                "|   | O |   |",
                "-------------",
                "| O |   | X |",
                "-------------",
        };
        tableGoal = new String[]{
                "┌───┬───┬───┐",
                "│ X │   │ X │",
                "├───┼───┼───┤",
                "│   │ O │   │",
                "├───┼───┼───┤",
                "│ O │   │ X │",
                "└───┴───┴───┘"
        };
        tableResult = translateTable( table, tableGoal );
        testPrint( table, tableGoal, tableResult );
        return arrayCompare(tableResult, tableGoal);
    } // <- testTicTacTpe
    private static boolean testHeader() {
        table = new String[]{
                "===================",
                "| Month | Diet    |",
                "===================",
                "| April | Fish    |",
                "-------------------",
                "| May   | LoCarb  |",
                "-------------------",
                "| June  | You ... |",
                "-------------------"
        };
        tableGoal = new String[]{
                "╒═══════╤═════════╕",
                "│ Month │ Diet    │",
                "╞═══════╪═════════╡",
                "│ April │ Fish    │",
                "├───────┼─────────┤",
                "│ May   │ LoCarb  │",
                "├───────┼─────────┤",
                "│ June  │ You ... │",
                "└───────┴─────────┘"
        };
        tableResult = translateTable( table, tableGoal );
        testPrint( table, tableGoal, tableResult );
        return arrayCompare(tableResult, tableGoal);
    } // <- testHeader
    private static boolean testTotals() {
        table = new String[]{
                "-------------------",
                "| Sales |  10000  |",
                "-------------------",
                "| Costs |   2000  |",
                "-------------------",
                "| Bribes|   7999  |",
                "===================",
                "| Result|      1  |",
                "==================="
        };
        tableGoal = new String[]{
                "┌───────┬─────────┐",
                "│ Sales │  10000  │",
                "├───────┼─────────┤",
                "│ Costs │   2000  │",
                "├───────┼─────────┤",
                "│ Bribes│   7999  │",
                "╞═══════╪═════════╡",
                "│ Result│      1  │",
                "╘═══════╧═════════╛"
        };
        tableResult = translateTable( table, tableGoal );
        testPrint( table, tableGoal, tableResult );
        return arrayCompare(tableResult, tableGoal);
    } // <- testTotals
    private static boolean testInvalid() {
        table = new String[]{
                "Test"
        };
        tableGoal = new String[]{
                "Test"
        };
        tableResult = translateTable( table, tableGoal );
        testPrint( table, tableGoal, tableResult );
        return arrayCompare(tableResult, tableGoal);
    } // <- testInvalid
    private static boolean testOneRow() {
        table = new String[]{
                "-------------",
                "| X |   | X |",
                "-------------",
        };
        tableGoal = new String[]{
                "┌───┬───┬───┐",
                "│ X │   │ X │",
                "└───┴───┴───┘"
        };
        tableResult = translateTable( table, tableGoal );
        testPrint( table, tableGoal, tableResult );
        return arrayCompare(tableResult, tableGoal);
    } // <- testOneRow
    private static boolean testOneColumn() {
        table = new String[]{
                "---",
                "|1|",
                "---",
                "|2|",
                "---",
                "|3|",
                "===",
                "|6|",
                "==="
        };
        tableGoal = new String[]{
                "┌─┐",
                "│1│",
                "├─┤",
                "│2│",
                "├─┤",
                "│3│",
                "╞═╡",
                "│6│",
                "╘═╛"
        };
        tableResult = translateTable( table, tableGoal );
        testPrint( table, tableGoal, tableResult );
        return arrayCompare(tableResult, tableGoal);
    } // <- testOneColumn
    private static boolean testOneCell() {
        table = new String[]{
                "-----",
                "| X |",
                "-----",
        };
        tableGoal = new String[]{
                "┌───┐",
                "│ X │",
                "└───┘"
        };
        tableResult = translateTable( table, tableGoal );
        testPrint( table, tableGoal, tableResult );
        return arrayCompare(tableResult, tableGoal);
    } // <- testOneCell

    private static boolean testComplicated() {
        table = new String[]{
                "=====================",
                "|    |       |      |",
                "---------------------",
                "|    |    |    |    |",
                "---------------------",
                "|    |       |      |",
                "---------------------",
                "|    |    |         |",
                "=====================",
                "|    |    |    |    |",
                "---------------------",
        };
        tableGoal = new String[]{
                "╒════╤═══════╤══════╕",
                "│    │       │      │",
                "├────┼────┬──┴─┬────┤",
                "│    │    │    │    │",
                "├────┼────┴──┬─┴────┤",
                "│    │       │      │",
                "├────┼────┬──┴──────┤",
                "│    │    │         │",
                "╞════╪════╪════╤════╡",
                "│    │    │    │    │",
                "└────┴────┴────┴────┘",
        };
        tableResult = translateTable( table, tableGoal );
        testPrint( table, tableGoal, tableResult );
        return arrayCompare(tableResult, tableGoal);
    } // <- testOneCell

    private static String[] translateTable(String[] table, String[] tableGoal ) {
        // translateTable successfully integrated in class ArrayExtend
        //  henceforth known as ArrayExtend.arrayTableBeautify() :-)
        String[] newTable = arrayTableBeautify( table );
        return newTable;

    }

}
