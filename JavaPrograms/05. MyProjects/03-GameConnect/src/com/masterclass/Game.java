package com.masterclass;
/*
    Another great class by Zjan Preijde
    Creation : 2019-02-01, 13:57
*/

import java.util.ArrayList;
import static com.masterclass.OutputExtend.*;

public class Game implements ISaveable {
    private String    title;
    private int       minNrOfPlayers, maxNrOfPlayers, maxNrOfMoves;
    private boolean   gameStarted;
    private boolean   gameOver;
    private int       winnerID, lastPlayerID;
    private ArrayList <String> moves;
    private ArrayList <String> players;

    // Constructors
    public Game( String title, int minNrOfPlayers, int maxNrOfPlayers) {
        this(title, minNrOfPlayers, maxNrOfPlayers, 0 );
    }
    public Game( String title, int minNrOfPlayers, int maxNrOfPlayers, int maxNrOfMoves ) {
        this.title          = title;
        this.minNrOfPlayers = minNrOfPlayers;
        this.maxNrOfPlayers = maxNrOfPlayers;
        this.maxNrOfMoves   = maxNrOfMoves;
        this.gameStarted    = false;
        this.gameOver       = false;
        this.lastPlayerID   = -1;
        this.winnerID       = -1;
        this.moves          = new ArrayList <>(  );
        this.players        = new ArrayList <>(  );
    }

    // Setters
    public void setOver( boolean gameOver ) {
        this.gameOver = gameOver;
    }
    public void setStarted( boolean gameStarted ) {
        this.gameStarted = gameStarted;
    }
    public void setWinner(int winnerID ) {
        setOver( true );
        this.winnerID = winnerID;
    }

    // Getters
    public  String  getTitle()          { return title;                     }
    public  int     getMinNrOfPlayers() { return minNrOfPlayers;            }
    public  int     getMaxNrOfPlayers() { return maxNrOfPlayers;            }
    public  int     getMaxNrOfMoves()   { return maxNrOfMoves;              }
    public  boolean isStarted()         { return gameStarted;               }
    public  boolean isOver()            { return gameOver || winnerID >= 0; }
    public  boolean hasWinner()         { return winnerID >= 0;             }
    public  int     getLastPlayerID()   { return lastPlayerID;              }
    public  String  getLastPlayer()
        { return getPlayerDescription( lastPlayerID ); }
    public  String  getMoves()          { return formatMoves();             }
    public  ArrayList<String>  getPlayers()
        { return players; }
    public  int     getNrOfPlayers()
        { return players == null ? 0 : players.size(); }
    public  int     getNrOfMoves()
        { return moves == null   ? 0 : moves.size(); }
    public String   getPlayerDescription( int playerID ){
        if ( playerID < 0 || playerID >= players.size() ) return "";
        return players.get( playerID );
    }
    public String   getWinnerDescription()
        { return ( winnerID >= 0 ) ? getPlayerDescription( winnerID ) : "";}

    // Helpers
    public boolean addPlayer( String name ) {
        return addPlayer( name, "" );
    }

    public boolean addPlayer( String name, String extraInfo ) {
        if ( !checkPlayerBeforeAdd( name ) ) {
            return false;
        }
        oln( name + " added to the player list" + extraInfo, "\t" );
        players.add( name );
        if ( getNrOfPlayers() >= getMinNrOfPlayers() ) {
            oln("We have enough players, ready to start the game","\t" );
        }
        return true;
    }

    public boolean checkPlayerBeforeAdd( String  name ) {
        if ( isStarted() ) {
            oln("The game has already started","\t");
            return false;
        }
        if ( isOver() ) {
            oln("The game is already over, wait till it's restarted","\t" );
            if ( hasWinner() ) {
                oln("The winner is " + getPlayerDescription( this.winnerID ),"\t" );
            }
            return false;
        }
        if ( getNrOfPlayers() >= maxNrOfPlayers) {
            oln("We have enough players, let's play the game","\n\t");
            return false;
        }
        if ( name == null || name.equals("") ) {
            oln("Name player not given","\t");
            return false;
        }
        if ( playerExists( name ) ) {
            oln("Player " + name + " already added","\t");
            return false;
        }
        return true;
    }

    public boolean playerExists( String name ) {
        return  players.indexOf( name ) >= 0;
    }

    public boolean addMove( String move, int player ) {
        if ( !checkBeforeMove() ) {
            return false;
        }
        if ( maxNrOfMoves > 0 && getNrOfMoves() == maxNrOfMoves - 1) {
            // 1 move to go
            oln("This was the last move"
                    + "\n\tMaximum number of Moves reached","\n\t");
            setOver( true ) ;

        }
        return storeValue( move, player );
    }

    public boolean checkBeforeMove() {
        if ( !isStarted() ) {
            oln("The game has not yet started","\t");
            return false;
        }
        if ( isOver() ) {
            oln("The game is already over, wait till it's restarted","\t");
            if ( hasWinner() ) {
                oln("The winner is " + getPlayerDescription( this.winnerID ),"\t");
            }
            return false;
        }
        if ( maxNrOfMoves > 0 && getNrOfMoves() >= maxNrOfMoves) {
            // should not get here
            oln("We have reached the maximum amount of moves","\t");
            return false;
        }
        return true;
    }

    public int nextPlayerID(boolean startWithFirstIfEmpty ) {
        // Currently playerID starts with 0 and increments with 1
        for ( int i = 0; i < players.size(); i++ ) {
            if (i ==  lastPlayerID ) {
                if ( (i == players.size() - 1 ) ) {
                    // Last player
                    return 0;
                } else {
                    return ( i + 1 );
                }
            }
        }
        if ( startWithFirstIfEmpty ) {
            return 0;
        }
        return -1;
    }

    public boolean start() {
        if ( isStarted() ) {
            oln("The game has already started","\t");
            return false;
        }
        if ( getNrOfPlayers() < minNrOfPlayers ) {
            oln("We need more players! Minimal " + minNrOfPlayers
                    + ", currently " + getNrOfPlayers(),"\t");
            return false;
        }
        setStarted( true );
//        setOver( false );
        oln("Game has started, have fun playing '" + this.title + "'!!","\t");
        return true;
    }

    public boolean cancel() {
        if ( !isStarted() ) {
            oln("The game has not started yet","\t");
            return false;
        }
        reset();
        setOver( false ); // Werkt dit? Nee, ook niet.
        return true;
    }
    public void reset() {
        this.moves      = new ArrayList <>(  );
        this.players    = new ArrayList <>(  );
        setStarted( false );
        setOver( false ); // Waarom werkt dit niet?
        this.gameOver   = false; // en dit niet?
        this.lastPlayerID = -1;
        this.winnerID     = -1;
    }


    @Override
    public String toString( ) {
        return toString( "" );
    }
    public String toString( String gameType ) {
        String result = "";
        result += "\n\t===================================";
        result += "\n\tGame state :";
        result += "\n\t\tTitle             : " + title;
        if ( gameType != null && gameType != "" ) {
            result += "\n\t\tType              : " + gameType;
        }
        result += "\n\t\tMin nr of players : " + getMinNrOfPlayers();
        result += "\n\t\tMax nr of players : " + getMaxNrOfPlayers();
        result += "\n\t\tNumber of players : " + getNrOfPlayers();
        result += "\n\t\tMax nr of moves   : " + getMaxNrOfMoves();
        result += "\n\t\tNumber of moves   : " + getNrOfMoves();
        result += "\n\t\tGame has started  : " + isStarted();
        result += "\n\t\tGame is over      : " + isOver();
        result += "\n\t\tLast player       : "
                + getPlayerDescription( this.lastPlayerID );
        result += formatPlayers();
        result += formatMoves();
        result += ( hasWinner()
                ? "\n\n\t\t!! The winner is " + getWinnerDescription() + " !!"
                : "" );
        result += "\n\t===================================";
        return result;

    }
    private String formatPlayers() {
        String result = "\n\tPlayers : ";
        if (players.size() == 0) {
            return result + "No players yet";
        }
        for ( int i = 0; i < players.size(); i++) {
            result += "\n\t\tPlayer : " + getPlayerDescription( i );
        }
        return result;
    }
    private String formatMoves() {
        String result = "\n\tMoves   : ";
        if (moves.size() == 0) {
            return result += "No moves yet";
        }
        ArrayList<String> moves = returnValues();
        for ( int i = 0; i < moves.size(); i++) {
            result += "\n\t\tMove : " + moves.get(i);
        }
        return result;
    }

    // From Interface
    @Override
    public boolean storeValue( String move, String extraInfo) {
        moves.add( move );
        return true;
    }
    public boolean storeValue( String move, int playerID ) {
        this.lastPlayerID = playerID;
        return storeValue(move, "");

    }
    @Override
    public ArrayList returnValues() {
        return moves;
    }

}
