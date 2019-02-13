package com.masterclass;
/*
    Another great class by Zjan Preijde
*/

// TODO: 9-2-19, Include in ArrayExtend? arrayFormat() or something
// TODO: 9-2-19, (not an array method) boxIt(), draw box around String, String[]?
// TODO: 9-2-19, allow for double verticals
import static com.masterclass.OutputExtend.*;
import static com.masterclass.ArrayExtend.*;

public class TranslateTableTest {
    public static String string;
    public static String[] table, tableGoal, flipped, result, tests;
    public static boolean[] results;

    public static void main(String[] args) {
        oln( "-----------", "" );
        // As happens more often, I had loads of code at a certain point,
        //  turned out to me much simpler in the end, that's how it goes.
        oln( "Silly project, but learned a lot.", "\n", "" );
        oln( "Translate raw table format to extended ASCII :", "" );
        oln( "Uses '=', '-', '!' and '|' as table border characters!", "" );
        oln( "If these characters are contained in cells, it will blow up! :-)", "" );
        oln("// TODO: 9-2-19, Include in ArrayExtend? arrayFormat() or something\n" +
                 "// TODO: 9-2-19, (not an array method) boxIt(), draw box around String, String[]?\n" +
                 "// TODO: 9-2-19, allow for double verticals", "");
        testTranslate() ;
    }

    private static void testTranslate() {
        oln( "============================", "\n\n" );
        oln( "| TranslateTable Class TDD |", "" );
        oln( "----------------------------", "", "\n\n" );
        tests = new String[]  {
              "Test Connect Four"
            , "Test Tic Tac Toe"
            , "Test Header"
            , "Test Totals"
            , "Test Invalid table"
        };
        results = new boolean[] {
              testConnect()
            , testTicTacToe()
            , testHeader()
            , testTotals()
            , testInvalid()
        };
        oln("Test results :", "\n");
        for (int i = 0; i < tests.length; i++) {
            olt( tests[i], results[i] );
        }
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
        oln( "Translate this :", "" );
        printAString( table, false, true );
        oln( " - into this :", "" );
        printAString( tableGoal, false, true );
        oln( "", "\n" );
        result = translateTable( table, tableGoal );
        return arrayCompare(result, tableGoal);
    } // <- test1

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
        oln( "Translate this :", "" );
        printAString( table, false, true );
        oln( " - into this :", "" );
        printAString( tableGoal, false, true );
        oln( "", "\n" );
        result = translateTable( table, tableGoal );
        return arrayCompare(result, tableGoal);
    } // <- test2
    private static boolean testHeader() {
        table = new String[]{
                "===================",
                "|       |         |",
                "===================",
                "|       |         |",
                "-------------------",
                "|       |         |",
                "-------------------",
                "|       |         |",
                "-------------------"
        };
        tableGoal = new String[]{
                "╒═══════╤═════════╕",
                "│       │         │",
                "╞═══════╪═════════╡",
                "│       │         │",
                "├───────┼─────────┤",
                "│       │         │",
                "├───────┼─────────┤",
                "│       │         │",
                "└───────┴─────────┘"
        };
        oln( "Translate this :", "" );
        printAString( table, false, true );
        oln( " - into this :", "" );
        printAString( tableGoal, false, true );
        oln( "", "\n" );
        result = translateTable( table, tableGoal );
        return arrayCompare(result, tableGoal);
    } // <- test3
    private static boolean testTotals() {
        table = new String[]{
                "-------------------",
                "|       |         |",
                "-------------------",
                "|       |         |",
                "-------------------",
                "|       |         |",
                "===================",
                "|       |         |",
                "==================="
        };
        tableGoal = new String[]{
                "┌───────┬─────────┐",
                "│       │         │",
                "├───────┼─────────┤",
                "│       │         │",
                "├───────┼─────────┤",
                "│       │         │",
                "╞═══════╪═════════╡",
                "│       │         │",
                "╘═══════╧═════════╛"
        };
        oln( "Translate this :", "" );
        printAString( table, false, true );
        oln( " - into this :", "" );
        printAString( tableGoal, false, true );
        oln( "", "\n" );
        result = translateTable( table, tableGoal );
        return arrayCompare(result, tableGoal);
    } // <- test4
    private static boolean testInvalid() {
        table = new String[]{
                "Test"
        };
        tableGoal = new String[]{
                "Test"
        };
        result = translateTable( table, tableGoal );
        return arrayCompare(result, tableGoal);
    } // <- test5

    private static String[] translateTable(String[] table, String[] tableGoal ) {
        // Flip table, top to left side, eases translation
        if ( table.length < 3 ) { return table; /* Nothing to do */ }

        flipped = arrayFlip( table, "backward" );
        // First row is last column of table
        String[] newTable = new String[ flipped.length ];

        // temp, double verticals later?
        //
        String doubleBorders = ""
            + "╔═══╦═══╗"
            + "╠═══╬═══╣"
            + "║   ║   ║"
            + "╚═══╩═══╝";
        // temp


        for (int i = 0; i < flipped.length; i++) {
            String  row    = flipped[ i ];
            boolean firstColumn = ( i == flipped.length - 1 );
            boolean lastColumn  = ( i == 0 );
            int rowLength = row.length();

            int startAt = ( firstColumn || lastColumn ) ? 1: 2;
            String firstChars, between, lastChars;
            firstChars = row.substring( 0,startAt );
            between    = row.substring( startAt, rowLength - 2 );
            lastChars  = row.substring( rowLength - 2 );

            String  newRow = ""; // Not necessary, but Java nags
            if ( firstColumn ) {
                newRow = ""
                    + ( firstChars
                        .replace("=", "╒" )
                        .replace("-", "┌" )
                      )
                    + ( between
                        .replace("=", "╞" )
                        .replace("-", "├" )
                      )
                    + ( lastChars
                        .replace("=", "╘" )
                        .replace("-", "└" )
                      )
                ;
                newRow = newRow
                        .replace("|", "│" )
                ;
            }
            if ( lastColumn ) {
                newRow = ""
                    + ( firstChars
                        .replace("=", "╕" )
                        .replace("-", "┐" )
                      )
                    + ( between
                        .replace("=", "╡" )
                        .replace("-", "┤" )
                      )
                    + ( lastChars
                        .replace("=", "╛" )
                        .replace("-", "┘" )
                      )
                ;
                newRow = newRow
                        .replace("|", "│" )
                ;
            }
            if ( !(  firstColumn || lastColumn ) ) {
                newRow = ""
                    + ( firstChars
                        .replace("=|", "╤" + "|" )
                        .replace("-|", "┬" + "|" )
                      )
                    + ( between
                        .replace("=|", "╪" + "|" )
                        .replace("-|", "┼" + "|" )
                        .replace("|=", "|" + "╪" )
                        .replace("|-", "|" + "┼" )
                      )
                    + ( lastChars
                        .replace("|=", "|" + "╧" )
                        .replace("|-", "|" + "┴" )
                      )
                ;
                newRow = newRow
                        .replace("=", "═" )
                        .replace("-", "─" )
                        .replace("|", "│" )
                ;
            }
            newTable[ i ] = newRow;
        }

        // Flip back forward
        newTable = arrayFlip( newTable, "forward" );

        old("->\nResult :");
        printAString( newTable , false, true );
        old("\nShould be goal:");
        printAString( tableGoal, false, true );
        old("<-");
        return newTable;
    }
}
