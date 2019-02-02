package com.masterclass;

import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    private static boolean suppressSuccessResult = false;

    private static String testPlayer1 = "Frank";
    private static String testSymbol1 = "" + '\u25A0';
    private static String testPlayer2 = "Simon";
    private static String testSymbol2 = "" + '\u25EF';


    public static void main(String[] args) {
	// write your code here
        while (true) {
            oln( "==============", "\n" );
            oln( "Game Interface", "" );
            oln( "--------------", "" );
            oln( "Choices :", "" );
            oln( "1. Play Connect Four", "\t" );
            oln( "2. Test Game Interface", "\t" );
            oln( "9. Exit", "\t" );
            int choice = getInt( "Make your choice" );
            if ( choice == 9 ) {
                oln( "OK, later dude" );
                break;
            }
            switch (choice) {
                case 1:
                    playMenu();
                    break;
                case 2:
                    testMenu();
                    break;
                default:
                    break;
            }
        }
    }


/* ================= PLAY ZONE ================= */

    private static void playMenu() {
        ConnectFour game = new ConnectFour();

        while (true) {
            ArrayList<String> menuOptions = new ArrayList <>(  );
            oln( "======================", "\n" );
            oln( "Play Game Connect Four", "" );
            oln( "----------------------", "" );
            oln( "We are playing Connect Four with 2 players", "" );
//            oln( testPlayer1 + " with symbol '" + testSymbol1 + "'", "\t 1. " );
//            oln( testPlayer2 + " with symbol '" + testSymbol2 + "'", "\t 2. " );
            oln( "Options :", "" );
            if ( game.isStarted() ) {
                if ( game.isOver() ) {
                    menuOptions.add("Start new game");
                } else {
                    menuOptions.add( "Make moves" );
                    menuOptions.add( "Cancel game" );
                }
            } else {
                menuOptions.add( "Add player" );
                menuOptions.add( "Start game" );
            }
            menuOptions.add( "Show board" );
            if ( game.isStarted() ) {
                menuOptions.add( "Show moves" );
            }
            menuOptions.add( "Show game info" );
            for (int i = 0; i < menuOptions.size(); i++) {
                oln((i + 1) +". " + menuOptions.get(i), "\t");
            }
            oln( "9. Exit", "\t" );
            int choice = getInt( "Make your choice" );
            if ( choice == 9 ) {
                oln( "OK, later dude", "\t" );
                break;
            }
            if (choice > 0 && choice <= menuOptions.size()) {
                String menuChoice = menuOptions.get( choice - 1 );
                switch (menuChoice) {
                    case "Add player":
                        playAddPlayer( game );
                        break;
                    case "Start game":
                        playStartGame( game );
                        break;
                    case "Start new game":
                        game = new ConnectFour();
                        break;
                    case "Make moves":
                        playPlayGame( game );
                        break;
                    case "Show board":
                        playShowBoard( game );
                        break;
                    case "Show moves":
                        playShowMoves( game );
                        break;
                    case "Show game info":
                        playShowInfo( game );
                        break;
                    case "Cancel game":
                        playCancelGame( game );
                        game = new ConnectFour();
                        break;
                    default:
                        break;
                }
            }
        }
    }
    private static void playAddPlayer( Game game ) {
        ArrayList<String> defaultSymbols = new ArrayList <>(  );
        defaultSymbols.add( "" + '\u25A0' ); // closed square
        defaultSymbols.add( "" + '\u25EF' ); // open circle
        defaultSymbols.add( "" + '\u263A' ); // open smiley
        defaultSymbols.add( "" + '\u263B' ); // closed smiley
        defaultSymbols.add( "" + '\u25A0' ); // closed square
        defaultSymbols.add( "" + '\u2605' ); // closed star
        defaultSymbols.add( "" + '\u25FB' ); // open square
        defaultSymbols.add( "" + '\u25CA' ); // closed circle
        defaultSymbols.add( "" + '\u2606' ); // open star

        String player = getString("Enter your name");
        String symbol = defaultSymbols.get( game.getNrOfPlayers() );
        game.addPlayer( player, symbol );
    }
    private static void playStartGame( Game game ) {
        game.start();
        playPlayGame( (ConnectFour) game );
    }
    private static void playPlayGame( ConnectFour game) {
        String nextPlayer = playNextPlayer( game );
        if (nextPlayer == "") {
            return;
        }
        // Will not accept choice == "x" or "9" to exit :-(
        ArrayList<String> exits = new ArrayList <>(  );
        exits.add( "9" );

        ArrayList<String> choices = new ArrayList <>(  );
        String capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for ( int i = 0; i < game.NR_OF_COLUMNS; i++ ) {
            choices.add( capitals.substring( i, i + 1 ) );
        }
        String symbol, choice;
        int chosen;
        while (true) {
            playShowBoard( game );
            symbol = game.getSymbol( nextPlayer );
            choice = getString("Player " + nextPlayer + " (symbol '" + symbol + "')"
                    + ", enter column character (9 to exit)");
            if (choice.length() == 1) {
                // Can't get this to work in any other way, very strange
                chosen = exits.indexOf( choice.toUpperCase() ) + 1;
                if ( chosen > 0) {
                    break;
                }
                chosen = choices.indexOf( choice.toUpperCase() ) + 1;
                if (chosen > 0) {
                    game.addMove( nextPlayer, chosen );
                    if ( game.getLastPlayer().equals( nextPlayer ) ) {
                        nextPlayer = playNextPlayer( game );
                    }
                    if ( game.isOver() ) {
                        playShowBoard( game );
                        playShowMoves( game );
                        break;
                    }
                }

            }
        }
    }

    private static String playNextPlayer( Game game ) {
        ArrayList<String> players = game.getPlayers();
        String lastPlayer = game.getLastPlayer();
        String nextPlayer = "";
        if ( game.getNrOfPlayers() < game.getMinNrOfPlayers() ) {
            oln("\tNot enough players yet", "\t");
            return "";
        }
        int choice = 0;
        if ( lastPlayer.equals( "" )) {
            while ( true ) {
                oln("Not played yet, who will start?", "");
                for (int i = 0; i < players.size(); i++ ) {
                    oln(( i + 1 ) + ". " + players.get( i ), "\t");
                }
                oln("9. Return to menu", "\t");
                choice = getInt("Make your choice ");
                if (choice == 9) {
                    return "";
                }

                if ( choice > 0 && choice <= players.size() ) {
                    nextPlayer = players.get( choice - 1 );
                    break;
                }
            }
        } else {
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).equals( lastPlayer )) {
                    if ( (i == players.size() - 1 ) ) {
                        // Last player
                        nextPlayer = players.get(0);
                    } else {
                        nextPlayer = players.get(i + 1);
                    }
                    break;
                }
            }
        }
        return nextPlayer;
    }

    private static void playCancelGame( Game game ) {
        game.cancel();
    }
    private static void playShowBoard( ConnectFour game ) {
        oln(game.getBoard(), "");
    }
    private static void playShowMoves( Game game ) {
        oln(game.getMoves(), "");
    }
    private static void playShowInfo( ConnectFour game ) {
        oln(game.toString("suppressboard"), "");
    }

/* ================= PLAY ZONE ================= */


/* ================= TEST ZONE ================= */

    private static void testMenu() {
        while (true) {
            oln( "========================", "\n" );
            oln( "Test menu Game Interface", "");
            oln( "------------------------", "");
            oln( "We are playing Connect Four with players", "");
            oln( testPlayer1 + " with symbol '" + testSymbol1 + "'", "\t 1. " );
            oln( testPlayer2 + " with symbol '" + testSymbol2 + "'", "\t 2. " );
            oln( "Tests :", "");
            oln( "1. Invalid start, invalid player", "\t" );
            oln( "2. After cancel : start - add move", "\t" );
            oln( "3. Invalid columns, consecutive plays, play full column", "\t" );
            oln( "4. Vertical win", "\t" );
            oln( "5. Horizontal win", "\t" );
            oln( "6. Diagonal wins", "\t" );
            oln( "9. Exit", "\t" );
            int choice = getInt("Make your choice");
            if (choice == 9) {
                oln("OK, later dude");
                break;
            }
            switch (choice) {
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
                default:
                    break;
            }
        }
    }

    // Tests
    private static void test01() {
        ConnectFour game;
        game = new ConnectFour();

        oln("----------------------------------------", "\n");
        oln(" - Test 01, invalid start - invalid player", "");

        oln(game.toString(), "");

        // TDD OK
        oln("Start", "> ");
        oln("TDD Error 01-1 ? :","");
        game.start(); // Error

        oln("Add player, invalid name", "> ");
        oln("TDD Error 01-2 ?","");
        game.addPlayer( null, null );

        oln("Add player, invalid symbol", "> ");
        oln("TDD Error 01-3 ?","");
        game.addPlayer( testPlayer1, null );

        oln("Add player 1, symbol " + testSymbol1, "> ");
        game.addPlayer( testPlayer1, testSymbol1 );

        oln("Add player 1 again", "> ");
        oln("TDD Error 01-4 ?","");
        game.addPlayer( testPlayer1, testSymbol1 );

        oln("Start", "> ");
        oln("TDD Error 01-5 ?","");
        game.start();

        oln("Add player 2, same symbol as 1", "> ");
        oln("TDD Error 01-6 ?","");
        game.addPlayer( testPlayer2, testSymbol1 );

        oln("Add player 2, symbol " + testSymbol2, "> ");
        game.addPlayer( testPlayer2, testSymbol2 );

        game.addMove( testPlayer1 , 1);
        oln("Add move before start", "> ");
        oln("TDD Error 01-7 ?","");
        game.addMove( testPlayer1 , 1);

        oln("Start", "> ");
        game.start(); // OK

        oln("Start again", "> ");
        oln("TDD Error 01-8 ?", "");
        game.start(); // Error, already started

        oln(game.toString(), "");

    }

    private static void test02() {
        ConnectFour game;
        game = new ConnectFour();

        oln("\n----------------------------------------", "");
        oln(" Test 02 - after cancel : start - add move", "");

        oln("Set up and start", "> ");
        game.addPlayer( testPlayer1, testSymbol1 );
        game.addPlayer( testPlayer2, testSymbol2 );
        game.start();

        oln("Play", "> ");
        game.addMove( testPlayer1 , 1);
        oln("Cancel game", "> ");
        game.cancel(); // OK

        // TDD OK
        oln("Start game", "> ");
        oln("TDD Error 02-1 ?", "");
        game.start(); // Error

        // TDD OK
        oln("Play", "> ");
        oln("TDD Error 02-2 ?", "");
        game.addMove( testPlayer1 , 1 );

        oln(game.toString(), "");
    }

    private static void test03() {
        ConnectFour game;
        game = new ConnectFour();

        oln("----------------------------------------", "\n");
        oln("Test 03 - valid columns, consecutive plays, full column", "");

        oln("Set up and start", "> ");
        game.addPlayer( testPlayer1, testSymbol1 );
        game.addPlayer( testPlayer2, testSymbol2 );
        game.start();


        oln("Player 1, play column 0", "> ");
        oln("TDD Error 03-1 ?", "");
        game.addMove( testPlayer1 , 0 ); // Error, invalid column
        oln("Player 1, play column 7", "> ");
        oln("TDD Error 03-2 ?", "");
        game.addMove( testPlayer1 , 8 ); // Error, invalid column

        oln("Player 1, play column 1", "> ");
        game.addMove( testPlayer1 , 1 );
        oln("Player 1 again", "> ");
        oln("TDD Error 03-3 ?", "");
        game.addMove( testPlayer1 , 2 ); // Error, same player
        oln("Player 2, play column 2", "> ");
        game.addMove( testPlayer2, 2 );


        oln("Add six moves, column 3", "> ");
        game.addMove( testPlayer1, 3 );
        game.addMove( testPlayer2, 3 );
        game.addMove( testPlayer1, 3 );
        game.addMove( testPlayer2, 3 );
        game.addMove( testPlayer1, 3 );
        game.addMove( testPlayer2, 3 );

        oln("Another move, column 3", "> ");
        oln("TDD Error 03-4 ?", "");
        game.addMove( testPlayer1, 3 );

        oln(game.toString(), "");
    }

    private static void test04() {
        ConnectFour game;
        game = new ConnectFour();

        oln("----------------------------------------", "\n");
        oln(" - Test 04 - Check for vertical win");

        oln("Set up and start", "> ");
        game.addPlayer( testPlayer1, testSymbol1 );
        game.addPlayer( testPlayer2, testSymbol2 );
        game.start();

        oln("Play with horizontal win", "> ");
        game.addMove( testPlayer1, 3 );
        game.addMove( testPlayer2, 4 );
        game.addMove( testPlayer1, 3 );
        game.addMove( testPlayer2, 4 );
        game.addMove( testPlayer1, 3 );
        game.addMove( testPlayer2, 4 );
        game.addMove( testPlayer1, 3 );
        oln(game.toString(), "");
    }

    private static void test05() {
        ConnectFour game;
        game = new ConnectFour();

        oln("----------------------------------------", "\n");
        oln("Test 05 - Check for horizontal win");

        oln("Set up and start", "> ");
        game.addPlayer( testPlayer1, testSymbol1 );
        game.addPlayer( testPlayer2, testSymbol2 );
        game.start();

        oln("Play with vertical win", "> ");
        game.addMove( testPlayer2, 3 );
        game.addMove( testPlayer1, 3 );
        game.addMove( testPlayer2, 4 );
        game.addMove( testPlayer1, 4 );
        game.addMove( testPlayer2, 5 );
        game.addMove( testPlayer1, 5 );
        game.addMove( testPlayer2, 6 );
        oln(game.toString(), "");
    }

    private static void test06() {
        ConnectFour game;

        oln("----------------------------------------", "\n");
        oln("Test 06 - Check for forward/backward diagonal wins", "");

        oln("Test 06-1 - Check for forward diagonal win", "\n");
        oln("Set up and start", "> ");
        game = new ConnectFour();
        game.addPlayer( testPlayer1, testSymbol1 );
        game.addPlayer( testPlayer2, testSymbol2 );
        game.start();

        oln("Play with forward diagonal win", "> ");
        game.addMove( testPlayer1, 3 ); // -     1
        game.addMove( testPlayer2, 4 ); // .
        game.addMove( testPlayer1, 4 ); // .-    2
        game.addMove( testPlayer2, 5 ); // .
        game.addMove( testPlayer1, 5 ); // .-
        game.addMove( testPlayer2, 6 ); // .
        game.addMove( testPlayer1, 5 ); // .--   3
        game.addMove( testPlayer2, 6 ); // ..
        game.addMove( testPlayer1, 6 ); // ..-
        game.addMove( testPlayer2, 2 ); // .
        game.addMove( testPlayer1, 6 ); // ..--  4 - win
        oln(game.toString(), "");


        oln("Test 06-2 - Check for backward diagonal win", "\n");
        oln("Set up and start", "> ");
        game = new ConnectFour();
        game.addPlayer( testPlayer1, testSymbol1 );
        game.addPlayer( testPlayer2, testSymbol2 );
        game.start();

        oln("Play with backward diagonal win", "> ");
        game.addMove( testPlayer2, 7 ); // -     1
        game.addMove( testPlayer1, 6 ); // .
        game.addMove( testPlayer2, 6 ); // .-    2
        game.addMove( testPlayer1, 5 ); // .
        game.addMove( testPlayer2, 5 ); // .-
        game.addMove( testPlayer1, 4 ); // .
        game.addMove( testPlayer2, 5 ); // .--   3
        game.addMove( testPlayer1, 4 ); // ..
        game.addMove( testPlayer2, 4 ); // ..-
        game.addMove( testPlayer1, 2 ); // .
        game.addMove( testPlayer2, 4 ); // ..--  4 - win
        oln(game.toString(), "");

    }

/* ================= TEST ZONE ================= */



/* ================= HELPERS ZONE ================= */
    // - Helpers -
    private static void oln(String text) {
        oln(text, true);
    }
    private static void oln(String text, boolean prefix) {
        oln(text, (prefix ? "= " : ""), "");
    }
    private static void oln(String text, String prefix) {
        oln(text, prefix, "");
    }
    private static void oln(String text, String prefix, String suffix) {
        System.out.println(prefix + text + suffix);
    }

    // System.out.print() short hand
    private static void o(String text) {
        o(text, true);
    }
    private static void o(String text, boolean prefix) {
        o(text, (prefix ? "- " : ""), "");
    }
    private static void o(String text, String prefix) {
        o(text, prefix, "");
    }
    private static void o(String text, boolean prefix, String suffix) {
        o(text, (prefix ? "- " : ""), suffix);
    }
    private static void o(String text, String prefix, String suffix) {
        System.out.print(prefix + text + suffix);
    }

    // User input
    private static int getInt() {
        return getInt("Enter your choice ");
    }
    private static int getInt(String prompt) {
        int i = 0;
        o(prompt + " : ", "");
        if (scanner.hasNextInt()) {
            i = scanner.nextInt();;
        }
        scanner.nextLine();
        return i;
    }
    private static String getString() {
        return getString("Enter your text ");
    }
    private static String getString(String prompt) {
        o(prompt + " : ");
        return scanner.nextLine();
    }

/* ================= HELPERS ZONE ================= */


}
