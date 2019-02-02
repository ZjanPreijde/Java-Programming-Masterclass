package com.masterclass;
/*
    Another great class by Zjan Preijde
    Creation : 2019-02-01, 13:57
*/

import java.util.ArrayList;

public class Game implements ISaveable {
    private boolean gameStarted;
    private boolean gameOver;
    private String title, winner, lastPlayer;
    public int minNrOfPlayers, maxNrOfPlayers, maxNrOfMoves;
    public ArrayList <String> moves;
    public ArrayList <String> players;

    // Constructors
    public Game( String title, int minNrOfPlayers, int maxNrOfPlayers) {
        this(title, minNrOfPlayers, maxNrOfPlayers, 0 );
    }
    public Game( String title, int minNrOfPlayers, int maxNrOfPlayers, int maxNrOfMoves ) {
        this.title          = title;
        this.minNrOfPlayers = minNrOfPlayers;
        this.maxNrOfPlayers = maxNrOfPlayers;
        this.maxNrOfMoves   = maxNrOfMoves;
        this.winner         = "";
        this.lastPlayer     = "";
        this.moves          = new ArrayList <>(  );
        this.players        = new ArrayList <>(  );
        this.gameStarted    = false;
        this.gameOver       = false;
    }

    // Setters
    public void setOver( boolean gameOver ) {
        this.gameOver = gameOver;
    }
    public void setStarted( boolean gameStarted ) {
        this.gameStarted = gameStarted;
    }
    public void setWinner(String winner ) {
        setOver( true );
        this.winner = winner;
    }

    // Getters
    public  int     getMinNrOfPlayers() { return minNrOfPlayers;    }
    public  int     getMaxNrOfPlayers() { return maxNrOfPlayers;    }
    public  int     getMaxNrOfMoves()   { return maxNrOfMoves;      }
    public  boolean isStarted()         { return gameStarted;       }
    public  boolean isOver()            { return gameOver;          }
    public  boolean hasWinner()         { return !winner.isEmpty(); }
    public  String  getLastPlayer()     { return lastPlayer;        }
    public  String  getMoves()          { return formatMoves();     }
    public  ArrayList<String>  getPlayers()
        { return players; }
    public  int     getNrOfPlayers()
        { return players == null ? 0 : players.size(); }
    public  int     getNrOfMoves()
        { return moves == null   ? 0 : moves.size(); }

    // Helpers
    public boolean addPlayer( String name ) {
        return addPlayer( name
                , Integer.toString(getNrOfPlayers() + 1) );
    }
    public boolean addPlayer( String name, String extraInfo ) {
        if ( !checkPlayer( name ) ) {
            return false;
        }
        System.out.println( "\t" + name + " added to the player list" + extraInfo);
        players.add( name );
        if ( getNrOfPlayers() >= getMinNrOfPlayers() ) {
            System.out.println("\tWe have enough players, ready to start the game");
        }
        return true;
    }
    public boolean checkPlayer( String  name ) {
        if ( isStarted() ) {
            System.out.println("\tThe game has already started");
            return false;
        }
        if ( isOver() ) {
            System.out.println("\tThe game is already over, wait till it's restarted");
            if ( hasWinner() ) {
                System.out.println("\tThe winner is " + this.winner);
            }
            return false;
        }
        if ( getNrOfPlayers() >= maxNrOfPlayers) {
            System.out.println("\tWe have enough players, let's play the game");
            return false;
        }
        if ( name == null || name.equals("") ) {
            System.out.println("\tName player not given");
            return false;
        }
        if ( getIndexPlayer( name ) >= 0 ) {
            System.out.println("\tPlayer " + name + " already added");
            return false;
        }
        return true;
    }
    public int getIndexPlayer( String name ) {
        return  players.indexOf( name );
    }

    public boolean addMove( String move, String name ) {
        if ( !checkBeforeMove() ) {
            return false;
        }
        if ( maxNrOfMoves > 0 && getNrOfMoves() == maxNrOfMoves - 1) {
            // 1 move to go
            System.out.println("\tThis was the last move"
                    + "\tMaximum number of Moves reached");
            setOver( true ) ;

        }
        return storeValue( move, name );
    }
    public boolean checkBeforeMove() {
        if ( !isStarted() ) {
            System.out.println("\tThe game has not yet started");
            return false;
        }
        if ( isOver() ) {
            System.out.println("\tThe game is already over, wait till it's restarted");
            if ( hasWinner() ) {
                System.out.println("\tThe winner is " + this.winner);
            }
            return false;
        }
        if ( maxNrOfMoves > 0 && getNrOfMoves() >= maxNrOfMoves) {
            // should not get here
            System.out.println("\tWe have reached the maximum amount of moves");
            return false;
        }
        return true;
    }

    public boolean start() {
        if ( isStarted() ) {
            System.out.println("\tThe game has already started");
            return false;
        }
        if ( getNrOfPlayers() < minNrOfPlayers ) {
            System.out.println("\tWe need more players! Minimal " + minNrOfPlayers + ", currently " + getNrOfPlayers());
            return false;
        }
        setStarted( true );
//        setOver( false );
        System.out.println("\tGame has started, have fun playing '" + this.title + "'!!");
        return true;
    }

    public boolean cancel() {
        if ( !isStarted() ) {
            System.out.println("\tThe game has not started yet");
            return false;
        }
        reset();
        setOver( false ); // Werkt dit? Nee, ook niet.
        return true;
    }
    public void reset() {
        this.moves      = new ArrayList <>(  );
        this.players    = new ArrayList <>(  );
        this.lastPlayer = "";
        setWinner( "" );
        setStarted( false );
        setOver( false ); // Waarom werkt dit niet?
        this.gameOver   = false; // en dit niet?
    }


    @Override
    public String toString( ) {
        return "\n\t===================================" +
                "\n\tGame state :" +
                "\n\t\tTitle             : " + title +
                "\n\t\tMin nr of players : " + getMinNrOfPlayers() +
                "\n\t\tMax nr of players : " + getMaxNrOfPlayers() +
                "\n\t\tNumber of players : " + getNrOfPlayers() +
                "\n\t\tMax nr of moves   : " + getMaxNrOfMoves() +
                "\n\t\tNumber of moves   : " + getNrOfMoves() +
                "\n\t\tGame has started  : " + isStarted() +
                "\n\t\tGame is over      : " + isOver() +
                "\n\t\tLast player       : " + this.lastPlayer +
                formatPlayers() +
                formatMoves() +
                ( hasWinner() ? "\n\n\t\t!! The winner is " + winner + " !!" : "" ) +
                "\n\t===================================";
    }
    private String formatPlayers() {
        String result = "\n\tPlayers : ";
        if (players.size() == 0) {
            return result + "No players yet";
        }
        for ( int i = 0; i < players.size(); i++) {
            result += "\n\t\tPlayer : " + players.get(i);
        }
        return result;
    }
    private String formatMoves() {
        String result = "\n\tMoves : ";
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
    public boolean storeValue( String move, String lastPlayer ) {
        this.lastPlayer = lastPlayer;
        moves.add( move );
        return true;
    }
    @Override
    public ArrayList returnValues() {
        return moves;
    }

}
