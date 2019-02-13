package com.masterclass;
/*
    Another great class by Zjan Preijde
*/

// DONE: 9-2-19, Implemented in class ArrayExtend as arrayTableBeautify()! :-)
// TODO: 9-2-19, (not an array method) boxIt(), draw box around String, String[]?
// TODO: 9-2-19, allow for double verticals
import java.util.ArrayList;

import static com.masterclass.OutputExtend.*;
import static com.masterclass.InputExtend.*;
import static com.masterclass.ArrayExtend.*;

public class TranslateTableTest {
    public static String[] table, tableGoal, tableResult;
    public static ArrayList<String[]> tests, runTests;
    public static boolean[] results;

    public static void main(String[] args) {
        // As happens more often, I had loads of code at a certain point,
        //  turned out to me much simpler in the end, that's how it goes.
        oln( "-----------", "\n" );
        oln( "// DONE: 2019-02-09, Implemented in class ArrayExtend as arrayTableBeautify()! :-)", "\n");
        oln( "// No further development here", "", "\n");
        oln( "Silly project, but learned a lot.", "\n", "" );
        oln( "Translate raw table format to extended ASCII :", "" );
        oln( "Uses '=', '-', '!' and '|' as table border characters!", "" );
        oln( "( Well, to be honest, '!' for double verticals is not implemented yet )", "" );
        oln( "If these characters are contained in cells, it will blow up! :-)", "" );
        oln( "2019-02-09 : Passed my TDD-suite :-)", "\n" );
        testClass() ;
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
        tests.add( new String[]{"Run all tests"    , "all"          , "A"});
        tests.add( new String[]{"Exit"             , "quit"         , "Q"});
        return tests;
    }
    private static String[] testMenu( ArrayList<String[]> tests ) {
        // All for now
        oln("", "\n");
        printAString( arrayTableBeautify(
                new String[]{
                    "============================",
                    "| TranslateTable Class TDD |",
                    "----------------------------"
                }
            )
            , false, true
        );
        return getAMenu( "Available tests:", tests );
    }

    private static void testClass() {
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
                default:
                    break;
            }
        }
        oln("Test results :", "\n");
        for ( int i = 0; i < runTests.size(); i++) {
            olt( runTests.get( i )[0], results[i] );
        }
    }

    private static void testPrint(
              String[] table
            , String[] tableGoal
            , String[] tableResult
        ) {
        oln("--------------", "\n");
        oln( "Translate this :", "" );
        printAString( table, false, true );
        oln( " - into this :", "" );
        printAString( tableGoal, false, true );
        oln( " - result :", "" );
        tableResult = translateTable( table, tableGoal );
        printAString( tableResult , false, true );
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


    private static String[] translateTable(String[] table, String[] tableGoal ) {
        // translateTable successfully integrated in class ArrayExtend
        //  henceforth known as ArrayExtend.arrayTableBeautify() :-)
        String[] newTable = arrayTableBeautify( table );
        return newTable;

    }

}
