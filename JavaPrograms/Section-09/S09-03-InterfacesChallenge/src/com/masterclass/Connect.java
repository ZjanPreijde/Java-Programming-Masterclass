package com.masterclass;
/*
    Another great class by Zjan Preijde
*/


// TODO: makeMove(), can probably be done much smarter with .replace() or something
/*
    Create a Connect Game Interface? ConnectFour, ConnectThree, ConnectSix, TicTacToe
*/
import java.util.ArrayList;
import static com.masterclass.OutputExtend.*;
import static com.masterclass.ArrayExtend.*;

public class Connect extends Game {
//    private String   lastPlayer;
    String[] rows;
    String columns;
    ArrayList <String> symbols; //, playerSymbols;
    int NR_OF_COLUMNS;
    int NR_OF_ROWS;
    int NR_TO_CONNECT;
    boolean DIRECT_PLACEMENT;


    public Connect( String title, int nrOfColumns, int nrOfRows, int nrToConnect) {
        this(title, false, nrOfColumns, nrOfRows, nrToConnect
                , 2, 2);
    }

    public Connect( String title, boolean directPlacement
            , int nrOfColumns, int nrOfRows, int nrToConnect) {
        this(title, directPlacement, nrOfColumns, nrOfRows, nrToConnect
                , 2, 2);
    }

    public Connect( String title, boolean directPlacement
            , int nrOfColumns, int nrOfRows, int nrToConnect
            , int minNrOfPlayers, int maxNrOfPlayers) {
        super( title, minNrOfPlayers, maxNrOfPlayers, nrOfColumns * nrOfRows );
        this.DIRECT_PLACEMENT = directPlacement;
        this.NR_OF_COLUMNS    = nrOfColumns;
        this.NR_OF_ROWS       = nrOfRows;
        this.NR_TO_CONNECT    = nrToConnect;
        this.rows             = initRows();
        this.columns          = initColumns();
        this.symbols          = new ArrayList<>();
    }
    protected String[] initRows() {
        String[] result = new String[NR_OF_ROWS];
        for (int i = 0; i < NR_OF_ROWS; i++) {
            result[i] = " ".repeat( NR_OF_COLUMNS );
        };
        return result;
    }
    protected String initColumns() {
        return "ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring( 0, NR_OF_COLUMNS );
    }
    public String getColumns() {
        // later as response value "columnHeaders"
        return this.columns;
    }
    public String getColumnHeader( int index ) {
        if ( index >= 0 && index < columns.length() ) {
            return "" + columns.charAt( index );
        }
        return "" + '\uFFFD'; // �
    }

    public String getSymbol( int playerID ) {
        return ( playerID < 0 ? "" + '\uFFFD' : symbols.get( playerID ) );
    }

    public String getBoard() {
        return drawBoard();
    }

    @Override
    public boolean addPlayer( String name, String symbol ) {
        if ( !super.checkPlayerBeforeAdd( name ) ) {
            return false;
        }
        if ( symbol == null || symbol.equals( "" ) || symbol.length() != 1 ) {
            oln( "Player symbol not given or invalid", "\t" );
            return false;
        }
        if ( symbols != null && symbols.indexOf( symbol ) >= 0 ) {
            oln( "Player symbol '" + symbol + "' already in use", "\t" );
            return false;
        }
        super.addPlayer( name, ", with symbol '" + symbol + "'" );
        symbols.add( symbol );
        return true;
    }

    public boolean addMove( int playerID, String playerCol ) {
        return addMove( playerID, 0, playerCol);
    }
    public boolean addMove( int playerID, int playerRow, String playerCol ) {
        int realRow = DIRECT_PLACEMENT
                ? playerRow - 1
                : 0;
        int realCol = columns.indexOf( playerCol );
        if ( !super.checkBeforeMove() ) {
            // Game : Game ready, player OK
            return false;
        }
        if ( !this.checkBeforeMove( playerID, realRow, realCol) ) {
            // Connect : valid row, valid column
            return false;
        }

        String player = getPlayerDescription( playerID );
        String move = "Player " + player + " ("  + symbols.get( playerID ) + ") plays "
                + getColumnHeader( realCol )
                + ( DIRECT_PLACEMENT ? "-" + playerRow : "" );
        if ( !super.addMove( move, playerID ) ) {
            oln("Move not accepted", "\t" );
            return false;
        }
        oln("Move : " + move , "\t");
        int updateRow = DIRECT_PLACEMENT
                ? realRow
                : findNextRow( realCol );
        makeMove(updateRow, realCol, symbols.get( playerID ));
        if ( checkForWinner( playerID ) ) {
            super.setWinner( playerID );
            oln("Game over, the winner is " + player, "\t!! ", " !!");
        }
        return true;
    }

    private boolean checkBeforeMove( int playerID, int realRow, int realCol ) {
        boolean moveOK = true;

        if ( super.getLastPlayerID() == playerID ) {
            oln( "No two consecutive moves of the same player", "\t" );
            moveOK = false;
        }
        if ( realCol < 0 || realCol > ( NR_OF_COLUMNS - 1 ) ) {
            // Currently column 1 == columns[0]
            oln( "Invalid column played", "\t" );
            moveOK = false;
        }
        if ( DIRECT_PLACEMENT
                && ( realRow < 0 || realRow > ( NR_OF_ROWS - 1 ) ) ) {
            oln( "Invalid row played", "\t" );
            moveOK = false;
        }
        if ( moveOK ) {
            if ( DIRECT_PLACEMENT ) {
                // Direct placement
                String curValue = getValue( rows, realRow, realCol );
                if ( !curValue.equals(" ") ) {
                    oln( "\tPosition "
                            + getColumnHeader( realCol ) + "-" + (realRow + 1)
                            + " is taken, symbol " + curValue, "\t" );
                    moveOK = false;
                }
            } else {
                // Drop symbols from the top
                int     updateRow  = findNextRow( realCol );
                boolean columnFull = updateRow < 0;
                if ( columnFull ) {
                    oln( "\tColumn " + getColumnHeader( realCol ) + " is full", "\t" );
                    moveOK = false;
                }
            }
        }
        return moveOK;
    }
    private int findNextRow( int realCol ) {
        int updateRow = -1;
        for (int row = NR_OF_ROWS - 1; row >= 0; row--) {
            if (getValue( rows, row, realCol ).equals(" ")) {
                updateRow = row;
                break;
            }
        }
        return updateRow;
    }

    private boolean checkForWinner( int playerID ) {
        return checkVertical ( playerID )
                || checkHorizontal( playerID )
                || checkDiagonal( playerID );
    }
    private boolean checkHorizontal( int playerID ) {
        return checkForWin( rows, playerID, "Horizontal win" );
    }
    private boolean checkVertical( int playerID ) {
        String[] columns = arrayFlip( rows, "backward" );
        return checkForWin( columns, playerID, "Horizontal win" );
    }
    private boolean checkDiagonal( int playerID ) {
        String[] diagonals;
        diagonals = arrayFlip( rows, "forward45" );
        if ( checkForWin( diagonals, playerID, "Forward diagonal") ) {
            return true;
        }
        diagonals = arrayFlip( rows, "backward45" );
        return checkForWin( diagonals, playerID, "Backward diagonal");
    }
    private boolean checkForWin( String[] array, int playerID, String checkType) {
        String searchFor = repeatString ( symbols.get( playerID ), NR_TO_CONNECT );
        for ( String row : array ) {
            if ( row.contains( searchFor ) ) {
                oln(checkType + " win found!!", "\n\t!! ", " !!");
                return true;
            }
        }
        return false;
    }

    private String[] initColumnHeaders() {
        String[] result = new String[NR_OF_COLUMNS];
        String capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        result          = new String[NR_OF_COLUMNS];
        for (int i = 0; i < NR_OF_COLUMNS; i++) {
            result[i] = "" + capitals.charAt( i ); /* returns type char */
        }
        return result;
    }
    private String buildColumn( int realCol ) {
        String columnString = "";
        for (int row = NR_OF_ROWS - 1; row >= 0; row-- ) {
            columnString += "" + rows[ row ].charAt( realCol );
        }
        return columnString;
    }
    private void makeMove(int realRow, int realCol, String symbol) {
        // Can probably done much smarter with .replace() or something
        rows[ realRow ] = rows[ realRow ].substring( 0, realCol )
                + symbol
                + ( ( realCol > NR_OF_COLUMNS )
                    ? ""
                    : rows[ realRow ].substring( realCol + 1  ) );
//                    : rows[ realRow ].substring( realCol + 1 ) );
        oln("Column " + getColumnHeader( realCol )
                + ", content " + buildColumn( realCol ), "\t");
    }

    @Override
    public boolean start( ) {
        if ( super.start() ) {
            this.rows  = initRows();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean cancel() {
        // Extra work here?
        return super.cancel();
    }

    @Override
    public void reset() {
        super.reset();
        this.rows = initRows();
    }

    @Override
    public String toString() {
        return this.toString( "" );
    }

    public String toString( String extraParameters ) {
        String result = super.toString( DIRECT_PLACEMENT ? "Direct Placement" : "Drop From Top") ;
        if ( !extraParameters.toLowerCase().contains( "suppressboard" ) ) {
            result += drawBoard();
        }
        return result;
    }
    private String drawBoard() {
        String header = "\n\n\tGame board :\n\n\t ";
        for ( int i = 0; i < NR_OF_COLUMNS; i++ ) {
            header += " " + columns.charAt( i )  + "  ";
        }
        String line2 = repeatString( "-", NR_OF_COLUMNS * 4 )
                + "-";
        String result = header;
        String[] board = getNiceBoard( line2 );
        for (int i = 0; i < board.length; i++) {
            result += "\n\t" + board[i];
        }

        if ( hasWinner() ) {
            result += "\n\n\t!! The winner is " + getWinnerDescription() + " !!";
        }

        return result;
    }
    private String[] getNiceBoard( String line ) {
        String[] board = new String[ ( NR_OF_ROWS * 2 ) + 1 ];
        for ( int row = 0; row < NR_OF_ROWS; row++ ) {
            String result = "|";
            for ( int pos = 0; pos < NR_OF_COLUMNS; pos++ ) {
                result += " "
                        + getValue( rows, row, pos, " ", " " )
                        + " |";
            }
            board[ (row*2) ]     = line ;
            board[ (row*2) + 1 ] = result;
        }
        board[ NR_OF_ROWS * 2 ] = line;
        board = arrayTableBeautify( board );
        if ( DIRECT_PLACEMENT ) {
            // Add row numbers
            for (int row = 0; row < board.length; row++) {
                if ( row % 2 == 1 ) {
                    board[ row ] += " " + ( row + 1 ) / 2 ;
                }
            }

        }
        return board;
    }
    private String repeatString(String string, int times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result += string;
        }
        return result;
    }
}
