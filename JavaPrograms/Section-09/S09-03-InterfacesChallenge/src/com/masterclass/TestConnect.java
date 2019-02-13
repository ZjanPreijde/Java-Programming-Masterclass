package com.masterclass;
/*
    Another great class by Zjan Preijde
*/
import java.util.*;
//import static com.masterclass.*;
import static com.masterclass.OutputExtend.*;
import static com.masterclass.InputExtend.*;

public class TestConnect {
    private static String testPlayer1 = "Frank";
    private static String testSymbol1 = "■"; // \u25A0;
    private static String testPlayer2 = "Simon";
    private static String testSymbol2 = "◯"; // \u25EF;

    public static void main( String[] args ) {
        // Go for it buddy!!
        int choice;
        while ( true ) {
            choice = getMainMenu();
            if ( choice == 9 ) {
                oln( "OK, later dude", "" );
                break;
            }
            switch ( choice ) {
                case 1:
                    // TDD OK
                    test01();
                    break;
                case 2:
                    // TDD OK
                    test02();
                    break;
                case 3:
                    // TDD OK
                    test03();
                    break;
                case 4:
                    // TDD OK
                    test04();
                    break;
                case 5:
                    // TDD OK
                    test05();
                    break;
                case 6:
                    // TDD OK
                    test06();
                    break;
                case 7:
                    // TDD OK
                    test07();
                    break;
                default:
                    break;
            }
        }
    }
    private static int getMainMenu() {
        oln( "========================", "\n" );
        oln( "Test menu Game Interface", "" );
        oln( "------------------------", "" );
        oln( "We are playing Connect Four with players :", "" );
        oln( testPlayer1 + " with symbol '" + testSymbol1 + "'", "\t 1. " );
        oln( testPlayer2 + " with symbol '" + testSymbol2 + "'", "\t 2. " );
        oln( "Tests :", "" );
        oln( "1. Invalid start, invalid player", "\t" );
        oln( "2. After cancel : start - add move", "\t" );
        oln( "3. Invalid columns, consecutive plays, play full column", "\t" );
        oln( "4. Vertical win", "\t" );
        oln( "5. Horizontal win", "\t" );

        oln( "6. Forward diagonal win", "\t" );
        oln( "7. Backward diagonal win", "\t" );

        oln( "9. Exit", "\t" );
        return getInt( "Make your choice" );
    }

    /* ================= TEST ZONE ================= */


    // Tests
    private static void test01() {
        ConnectFour game;
        game = new ConnectFour();

        oln( "----------------------------------------", "\n" );
        oln( " - Test 01, invalid start - invalid player", "" );

        oln( game.toString(), "" );

        // TDD OK
        oln( "Start", "> " );
        oln( "TDD Error 01-1 ? :", "" );
        game.start(); // Error

        oln( "Add player, invalid name", "> " );
        oln( "TDD Error 01-2 ?", "" );
        game.addPlayer( null, null );

        oln( "Add player, invalid symbol", "> " );
        oln( "TDD Error 01-3 ?", "" );
        game.addPlayer( testPlayer1, null );

        oln( "Add player 1, symbol " + testSymbol1, "> " );
        game.addPlayer( testPlayer1, testSymbol1 );

        oln( "Add player 1 again", "> " );
        oln( "TDD Error 01-4 ?", "" );
        game.addPlayer( testPlayer1, testSymbol1 );

        oln( "Start", "> " );
        oln( "TDD Error 01-5 ?", "" );
        game.start();

        oln( "Add player 2, same symbol as 1", "> " );
        oln( "TDD Error 01-6 ?", "" );
        game.addPlayer( testPlayer2, testSymbol1 );

        oln( "Add player 2, symbol " + testSymbol2, "> " );
        game.addPlayer( testPlayer2, testSymbol2 );

        game.addMove( 0, "A" );
        oln( "Add move before start", "> " );
        oln( "TDD Error 01-7 ?", "" );
        game.addMove( 0, "A" );

        oln( "Start", "> " );
        game.start(); // OK

        oln( "Start again", "> " );
        oln( "TDD Error 01-8 ?", "" );
        game.start(); // Error, already started

        oln( game.toString(), "" );

    }

    private static void test02() {
        ConnectFour game;
        game = new ConnectFour();

        oln( "\n----------------------------------------", "" );
        oln( " Test 02 - after cancel : start - add move", "" );

        oln( "Set up and start", "> " );
        game.addPlayer( testPlayer1, testSymbol1 );
        game.addPlayer( testPlayer2, testSymbol2 );
        game.start();

        oln( "Play", "> " );
        game.addMove( 0, "A" );
        oln( "Cancel game", "> " );
        game.cancel(); // OK

        // TDD OK
        oln( "Start game", "> " );
        oln( "TDD Error 02-1 ?", "" );
        game.start(); // Error

        // TDD OK
        oln( "Play", "> " );
        oln( "TDD Error 02-2 ?", "" );
        game.addMove( 1, "B" );

        oln( game.toString(), "" );
    }

    private static void test03() {
        ConnectFour game;
        game = new ConnectFour();

        oln( "----------------------------------------", "\n" );
        oln( "Test 03 - valid columns, consecutive plays, full column", "" );

        oln( "Set up and start", "> " );
        game.addPlayer( testPlayer1, testSymbol1 );
        game.addPlayer( testPlayer2, testSymbol2 );
        game.start();


        oln( "Player 1, play column 0", "> " );
        oln( "TDD Error 03-1 ?", "" );
        game.addMove( 0, " " ); // Error, invalid column
        oln( "Player 1, play column 7", "> " );
        oln( "TDD Error 03-2 ?", "" );
        game.addMove( 0, "X" ); // Error, invalid column

        oln( "Player 1, play column 1", "> " );
        game.addMove( 0, "A" );
        oln( "Player 1 again", "> " );
        oln( "TDD Error 03-3 ?", "" );
        game.addMove( 0, "B" ); // Error, same player
        oln( "Player 2, play column 2", "> " );
        game.addMove( 1, "B" );


        oln( "Add six moves, column 3", "> " );
        game.addMove( 0, "C" );
        game.addMove( 1, "C" );
        game.addMove( 0, "C" );
        game.addMove( 1, "C" );
        game.addMove( 0, "C" );
        game.addMove( 1, "C" );

        oln( "Another move, column 3", "> " );
        oln( "TDD Error 03-4 ?", "" );
        game.addMove( 0, "C" );

        oln( game.toString(), "" );
    }

    private static void test04() {
        ConnectFour game;
        game = new ConnectFour();

        oln( "----------------------------------------", "\n" );
        oln( " - Test 04 - Check for vertical win" );

        oln( "Set up and start", "> " );
        game.addPlayer( testPlayer1, testSymbol1 );
        game.addPlayer( testPlayer2, testSymbol2 );
        game.start();

        oln( "Play with horizontal win", "> " );
        game.addMove( 0, "C" );
        game.addMove( 1, "C" );
        game.addMove( 0, "D" );
        game.addMove( 1, "D" );
        game.addMove( 0, "E" );
        game.addMove( 1, "E" );
        game.addMove( 0, "F" );
        oln( game.toString(), "" );
    }

    private static void test05() {
        ConnectFour game;
        game = new ConnectFour();

        oln( "----------------------------------------", "\n" );
        oln( "Test 05 - Check for horizontal win" );

        oln( "Set up and start", "> " );
        game.addPlayer( testPlayer1, testSymbol1 );
        game.addPlayer( testPlayer2, testSymbol2 );
        game.start();

        oln( "Play with vertical win", "> " );
        game.addMove( 1, "C" );
        game.addMove( 0, "D" );
        game.addMove( 1, "C" );
        game.addMove( 0, "D" );
        game.addMove( 1, "C" );
        game.addMove( 0, "D" );
        game.addMove( 1, "C");
        oln( game.toString(), "" );
    }

    private static void test06() {
        ConnectFour game;

        oln( "----------------------------------------", "\n" );
        oln( "Test 06 - Check for forward diagonal win", "\n" );
        oln( "Set up and start", "> " );
        game = new ConnectFour();
        game.addPlayer( testPlayer1, testSymbol1 );
        game.addPlayer( testPlayer2, testSymbol2 );
        game.start();

        oln( "Play with forward diagonal win", "> " );
        game.addMove( 0, "C" ); // -     1
        game.addMove( 1, "D" ); // .
        game.addMove( 0, "D" ); // .-    2
        game.addMove( 1, "E" ); // .
        game.addMove( 0, "E" ); // .-
        game.addMove( 1, "F" ); // .
        game.addMove( 0, "E" ); // .--   3
        game.addMove( 1, "F" ); // ..
        game.addMove( 0, "F" ); // ..-
        game.addMove( 1, "B" ); // .
        game.addMove( 0, "F"); // ..--  4 - win
        oln( game.toString(), "" );

    }
    private static void test07() {
        ConnectFour game;

        oln( "----------------------------------------", "\n" );
        oln( "Test 07 - Check for forward diagonal win", "\n" );
        oln( "Set up and start", "> " );
        game = new ConnectFour();
        game.addPlayer( testPlayer1, testSymbol1 );
        game.addPlayer( testPlayer2, testSymbol2 );
        game.start();

        oln( "Play with backward diagonal win", "> " );
        game.addMove( 1, "G" ); // -     1
        game.addMove( 0, "F" ); // .
        game.addMove( 1, "F" ); // .-    2
        game.addMove( 0, "E" ); // .
        game.addMove( 1, "E" ); // .-
        game.addMove( 0, "D" ); // .
        game.addMove( 1, "E" ); // .--   3
        game.addMove( 0, "D" ); // ..
        game.addMove( 1, "D" ); // ..-
        game.addMove( 0, "B" ); // .
        game.addMove( 1, "D" ); // ..--  4 - win
        oln( game.toString(), "" );

    }

    /* ================= TEST ZONE ================= */
}
