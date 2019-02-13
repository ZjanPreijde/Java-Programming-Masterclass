package com.masterclass;
/*
    Another great class by Zjan Preijde
*/
import java.util.*;
//import static com.masterclass.*;
import static com.masterclass.OutputExtend.*;
import static com.masterclass.InputExtend.*;
import static com.masterclass.ArrayExtend.*;


public class PlayConnect {
    public static Connect game;

    public static void main( String[] args ) {
        // Go for it buddy!!
        String header = "Game Interface";
        ArrayList<String[]> menuOptions = new ArrayList <>();
        menuOptions.add( new String[]{"Play Tic Tac Toe ", "tic-tac-toe" , "1"} );
        menuOptions.add( new String[]{"Play Connect Four", "connect-four", "2"} );
        menuOptions.add( new String[]{"Play Connect Five", "connect-five", "3"} );
        menuOptions.add( new String[]{"Play Connect Flex", "connect-flex", "4"} );
        menuOptions.add( new String[]{"Quit"             , "exit"        , "Q"} );
        while (true) {
            String[] choice = getAMenu(header, menuOptions);
            if ( choice[1].equals("exit") ) {
                oln("See yah, dude", "");
                break;
            }
            playMenu(choice[1]);
        }
    }

    /* ================= PLAY ZONE ================= */

    private static void playMenu( String gameType ) {
        game = playGetNewGame( gameType );
        if ( game == null ) return;

        while ( true ) {
            ArrayList <String> menuOptions = new ArrayList <>();
            playShowMenu( game, menuOptions );
            int choice = getInt( "Make your choice" );
            if ( choice == 9 ) {
                oln( "OK, later dude", "\t" );
                break;
            }
            if ( choice > 0 && choice <= menuOptions.size() ) {
                String menuChoice = menuOptions.get( choice - 1 );
                switch ( menuChoice ) {
                    case "Add player":
                        playAddPlayer( game );
                        break;
                    case "Start game":
                        playStartGame( game );
                        break;
                    case "Start new game":
                        game = playGetNewGame( gameType );
                        if ( game == null ) return;
                        break;
                    case "Continue game":
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
                        game = playGetNewGame( gameType );
                        if ( game == null ) return;
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private static Connect playGetNewGame( String gameType ) {
        switch ( gameType ) {
            case "tic-tac-toe":
                return new TicTacToe();
            case "connect-four":
                return new ConnectFour();
            case "connect-five":
                return new ConnectFive();
            case "connect-flex":
                return makeConnectFlex();
            default:
                return null;
        }
    }

    private static Connect makeConnectFlex() {
        game = null;
        boolean directPlacement, quit = false;
        int nrOfColumns, nrOfRows, nrToConnect, minNrOfPlayers, maxNrOfPlayers;
        nrOfColumns = getInt( "Number of columns (2-15)" );
        nrOfRows = getInt( "Number of rows    (2-15" );
        int maxNrToConnect = ( nrOfColumns > nrOfRows ) ? nrOfRows : nrOfColumns;
        nrToConnect = getInt( "Number to win     (2-" + maxNrToConnect + ")" );
//        minNrOfPlayers = getInt("Min nr of players (1-6)");
//        maxNrOfPlayers = getInt("Max nr of players (1-6)");
        int dpChoice = getInt( "Style, 1 = Tic Tac Toe, 2 = Connect Four" );
        directPlacement = dpChoice == 1;
        game = new ConnectFlex( directPlacement, nrOfColumns, nrOfRows, nrToConnect );


        return game;
    }

    private static void playShowMenu( Game game, ArrayList <String> menuOptions ) {
        oln( "======================", "\n" );
        oln( "Play Game " + game.getTitle(), "" );
        oln( "----------------------", "" );
        oln( "We are playing " + game.getTitle() + " with 2 players", "" );
//            oln( testPlayer1 + " with symbol '" + testSymbol1 + "'", "\t 1. " );
//            oln( testPlayer2 + " with symbol '" + testSymbol2 + "'", "\t 2. " );
        oln( "Options :", "" );
        if ( game.isStarted() ) {
            if ( game.isOver() ) {
                menuOptions.add( "Start new game" );
            } else {
                menuOptions.add( "Continue game" );
                menuOptions.add( "Cancel game" );
            }
        } else {
            if ( game.getNrOfPlayers() < game.getMaxNrOfPlayers() ) {
                menuOptions.add( "Add player" );
            }
            menuOptions.add( "Start game" );
        }
        menuOptions.add( "Show board" );
        if ( game.isStarted() ) {
            menuOptions.add( "Show moves" );
        }
        menuOptions.add( "Show game info" );
        for ( int i = 0; i < menuOptions.size(); i++ ) {
            oln( ( i + 1 ) + ". " + menuOptions.get( i ), "\t" );
        }
        oln( "9. Exit", "\t" );

    }

    private static void playAddPlayer( Game game ) {
        ArrayList <String> defaultSymbols = new ArrayList <>();
        defaultSymbols.add( "" + '\u25EF' ); // open circle
        defaultSymbols.add( "" + '\u25A0' ); // closed square
        defaultSymbols.add( "" + '\u25FB' ); // open square
        defaultSymbols.add( "" + '\u25CA' ); // closed circle
        defaultSymbols.add( "" + '\u263A' ); // open smiley
        defaultSymbols.add( "" + '\u263B' ); // closed smiley
        defaultSymbols.add( "" + 'X' );
        defaultSymbols.add( "" + 'O' );
//        defaultSymbols.add( "" + '\u2606' ); // open star
//        defaultSymbols.add( "" + '\u2605' ); // closed star

        String player = getString( "Enter your name" );
        if ( player != "" ) {
            oln( "Available symbols :", "\t" );
            for ( int i = 0; i < defaultSymbols.size(); i++ ) {
                oln( ( i + 1 ) + ". " + defaultSymbols.get( i ), "\t\t" );
            }
        }
        String symbol;
        int choice = getInt( "Choose your symbol" );
        if ( choice > 0 && choice <= defaultSymbols.size() ) {
            symbol = defaultSymbols.get( choice - 1 );
        } else {
            symbol = defaultSymbols.get( game.getNrOfPlayers() );
        }
        game.addPlayer( player, symbol );
    }

    private static void playStartGame( Connect game ) {
        game.start();
        playPlayGame( game );
    }

    private static void playPlayGame( Connect game ) {
        int playerID = playNextPlayer( game );
        if ( playerID < 0 ) {
            return;
        }

        String player, symbol, playerColumn, columns
                , firstColumnHeader, lastColumnHeader, columnHeaders;
        int playerRow;
        int[] rows;


        // Will not accept choice == "9" to exit :-(
        ArrayList <String> exits;
        exits = new ArrayList <>();
        exits.add( "9" );


        columns = game.getColumns();
        rows = new int[game.NR_OF_ROWS];
        for ( int i = 0; i < game.NR_OF_ROWS; i++ ) {
            rows[ i ] = i;
        }
        firstColumnHeader = "" + columns.charAt( 0 );
        lastColumnHeader  = "" + columns.charAt( columns.length() -1 );

        while ( true ) {
            playShowBoard( game );
            player = game.getPlayerDescription( playerID );
            symbol = game.getSymbol( playerID );
            oln( "It is " + player + "'s turn"
                    + " (symbol '" + symbol + "')", "" );
            playerColumn = getString( "Enter column character"
                    + " (" + firstColumnHeader
                    + "-" + lastColumnHeader
                    + ", 9 to exit)" );
            if ( playerColumn.length() == 1 ) {
                // Can't get this to work in any other way, very strange
                if ( ( exits.indexOf( playerColumn.toUpperCase() ) ) >= 0 ) {
                    // Exit
                    break;
                }

                playerRow    = 0;
                playerColumn = playerColumn.toUpperCase();
                if ( columns.contains( playerColumn ) ) {
                    if ( game.DIRECT_PLACEMENT ) {
                        playerRow = getInt( "Enter row number"
                                + " (1"
                                + "-" + ( rows.length )
                                + ", 9 to exit)" );
                    }
                } else {
                    oln("Invalid column played (" + playerColumn + ")");
                }

                if ( columns.indexOf( playerColumn ) >= 0 ) {
                    game.addMove( playerID, playerRow, playerColumn );
                    if ( game.isOver() ) {
                        playShowBoard( game );
                        playShowMoves( game );
                        break;
                    }
                    if ( game.getLastPlayerID() == playerID ) {
                        // Move validated
                        playerID = playNextPlayer( game );
                    }
                }
            }
        }
    }

    private static int playNextPlayer( Connect game ) {
        if ( game.getNrOfPlayers() < game.getMinNrOfPlayers() ) {
            oln( "\tNot enough players yet", "\t" );
            return -1;
        }

        int nextPlayerID = game.nextPlayerID( false );

        if ( nextPlayerID >= 0 ) {
            return nextPlayerID;
        }

        ArrayList <String> players = game.getPlayers();
        int choice;
        while ( true ) {
            oln( "Not played yet, who will start?", "" );
            for ( int i = 0; i < players.size(); i++ ) {
                oln( ( i + 1 ) + ". "
                        + game.getPlayerDescription( i ), "\t" );
            }
            oln( "9. Return to menu", "\t" );
            choice = getInt( "Make your choice " );
            if ( choice == 9 ) {
                return -1;
            }

            if ( choice > 0 && choice <= players.size() ) {
                nextPlayerID = choice - 1;
                break;
            }
        }
        return nextPlayerID;
    }
    private static void playGameRequest( String request, int playerId, int row, String column ) {
        switch (request) {
            case "startGame":
                break;
            case "cancelGame":
                break;
            default:
                break;
        }
    }

    private static void playCancelGame( Connect game ) {
        game.cancel();
    }

    private static void playShowBoard( Connect game ) {
        oln( game.getBoard(), "" );
    }

    private static void playShowMoves( Connect game ) {
        oln( game.getMoves(), "" );
    }

    private static void playShowInfo( Connect game ) {
        oln( game.toString( "suppressboard" ), "" );
    }

    /* ================= PLAY ZONE ================= */

}
