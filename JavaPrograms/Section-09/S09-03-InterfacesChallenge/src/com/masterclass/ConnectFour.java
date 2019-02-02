package com.masterclass;
/*
    Another great class by Zjan Preijde
    Creation : 2019-02-01, 13:48
*/

/*
    Create a ConnectGame Interface? ConnectFour, ConnectThree, ConnectSix
*/
import java.util.ArrayList;

public class ConnectFour extends Game {
//    private String   lastPlayer;
    private String[] columns;
    private ArrayList <String> symbols; //, playerSymbols;
    final int NR_OF_COLUMNS = 7;
    final int NR_OF_ROWS    = 6;
    final int NR_TO_CONNECT = 4;


    public ConnectFour( ) {
        super( "Connect Four", 2, 2, 42 );
//        this.lastPlayer = "";
        this.columns    = initColumns();
        this.symbols    = new ArrayList<>();
    }
    private String[] initColumns() {
        String[] newColumns = new String[NR_OF_COLUMNS];
        for (int i = 0; i < NR_OF_COLUMNS; i++) newColumns[i] = "";
        return newColumns;
    }
    public String getSymbol( String name ) {
        int playerIndex = super.getIndexPlayer( name );
        return ( playerIndex < 0 ? "?" : symbols.get( playerIndex ) );
    }

    public String getBoard() {
        return drawBoard();
    }

    @Override
    public boolean addPlayer( String name, String symbol ) {
        if ( !super.checkPlayer( name ) ) {;
            return false;
        }
        if ( symbol == null || symbol.equals("") || symbol.length() != 1) {
            System.out.println("\tPlayer symbol not given or invalid");
            return false;
        }
        if ( symbols != null && symbols.indexOf( symbol) >= 0) {
            System.out.println("\tPlayer symbol '" + symbol + "' already in use");
            return false;
        }
        super.addPlayer( name, ", with symbol '" + symbol + "'" );
        symbols.add( symbol );
        return true;
    }

    public boolean addMove( String player, int column ) {
        if ( !super.checkBeforeMove() ) {
            return false;
        }
        if ( !this.checkBeforeMove( player, column) ) {
            return false;
        }
        String symbol = getSymbol( player );
        String move = "Player " + player + " plays column "
                + column + ", symbol " + symbol ;
        if ( !super.addMove( move, player ) ) {
            System.out.println("\tMove not accepted");
            return false;
        }
        System.out.println("\tMove : " + move );
        makeMove(column, symbol);
        if ( checkForWinner( player ) ) {
            super.setWinner( player );
            System.out.println("\tGame over, the winner is " + player + "!!");
        }
        return true;
    }

    private boolean checkForWinner( String name ) {
        return checkVertical ( name )
                || checkHorizontal( name )
                || checkDiagonal( name );
    }
    private boolean checkVertical( String name ) {
        String searchFor = repeatString ( getSymbol( name ), NR_TO_CONNECT );
        for (int i = 0; i < NR_OF_COLUMNS; i++) {
            if ( columns[i].contains( searchFor ) ) {
                System.out.println("\n--> Vertical win found!!\n");
                return true;
            }
        }
        return false;
    }
    private boolean checkHorizontal( String name ) {
        String searchFor = repeatString ( getSymbol( name ), NR_TO_CONNECT );
        String[] rows = columnsToRows();
        for (int i = 0; i < rows.length; i++) {
            if ( rows[i].contains( searchFor ) ) {
                System.out.println("\n--> Horizontal win found!!\n");
                return true;
            }
        }
        return false;
    }
    private boolean checkDiagonal( String name ) {
        String searchFor = repeatString ( getSymbol( name ), NR_TO_CONNECT );
        String[] diagonals = columnsToDiagonals();
        for (int i = 0; i < diagonals.length; i++) {
            if ( diagonals[i].contains( searchFor ) ) {
                System.out.println("\n--> Diagonal win found!!\n");
                return true;
            }
        }
        return false;
    }


    private boolean checkBeforeMove( String player, int column ) {
        // Checks about
        boolean moveOK = true;
        if ( super.getLastPlayer() != null
                && super.getLastPlayer().equals(player) ) {
            System.out.println("\tNo two consecutive moves of the same player");
            moveOK = false;
        }
        if ( column < 1 || column > NR_OF_COLUMNS ) {
            System.out.println("\tInvalid column played (" + column + ")");
            moveOK = false;
        } else if ( columns[column - 1].length() >= NR_OF_ROWS ) {
            System.out.println("\tColumn " + column + " is full");
            moveOK = false;
        }
        return moveOK;
    }

    private String makeMove(int column, String symbol) {
        columns[column - 1] += symbol;
        return "\tColumn " + column
                + ", length " + columns[column - 1].length()
                + ", content " + columns[column - 1];
    }

    private String[] columnsToRows() {
        String[] rows = new String[1];
        if (columns == null) {
            // Should not get here
            System.out.println("columnsToRows(), columns == null !!!");
            rows[ 0 ] = "\n\tNo moves yet";
            return rows;
        }
        // row 0,0 == column 0,5, row 0,1 == column 1,5, row 0,6 = column 6,5
        // row 5,0 == column 0,0, row 5,1 == column 1,0, row 5,6 = column 6,0
        rows = new String[NR_OF_ROWS];
        for (int r = 0; r < rows.length ; r++) {
            rows[r] = "";
            for ( int c = 0; c < NR_OF_COLUMNS ; c++ ) {
                rows[ r ] += getColumnField( c, NR_OF_ROWS - r  - 1);
            }
        }
        return rows;
    }
    private String[] columnsToDiagonals() {
        String[] diagonals;
        String diagonal;
        ArrayList<String> diagonalsList = new ArrayList <>(  );

        if (columns == null) {
            // Should not get here
            System.out.println("columnsToRows(), columns == null !!!");
            diagonals = new String[1];
            diagonals[ 0 ] = "\n\tNo moves yet";
            return diagonals;
        }

        // Forward possible starts at first column
        // Forward possible ends   at NR_OF_COLUMNS + 1 - NR_TO_CONNECT
        // Max check NR_OF_ROWS
        // NR_OF_COLUMNS == 7, NR_OF_ROWS == 6 :
        // diagonal1  = fields 0,0 1,1 2,2 3,3 4,4 5,5
        // diagonal2  = fields 1,0 2,1 3,2 4,3 5,4 6,5
        // diagonal3  = fields 2,0 3,1 4,2 5,3 6,4
        // diagonal4  = fields 3,0 4,1 5,2 6,3

        // Backward possible starts at NR_TO_CONNECTth column
        // Backward possible ends   at last column
        // Max check NR_OF_ROWS
        // NR_OF_COLUMNS == 7, NR_OF_ROWS == 6 :
        // diagonal5  = fields 3,0 2,1 1,2 0,3
        // diagonal6  = fields 4,0 3,1 2,2 1,3 0,4
        // diagonal7  = fields 5,0 4,1 3,2 2,3 1,4 0,5
        // diagonal8  = fields 6,0 5,1 4,2 3,3 2,4 1,5

        // Forward diagonals
        for (int column = 0; column < NR_OF_COLUMNS + 1 - NR_TO_CONNECT; column++) {
            diagonal = "";
            for ( int position = 0; position < NR_OF_ROWS; position++) {
                int shift = 0;
                while (shift + column < NR_OF_COLUMNS) {
//                    diagonal += (column + shift) + ","
//                            + (position + shift) + " ";
                    diagonal += getColumnField(column + shift
                            , position + shift);
                    shift++;
                    if (position + shift >= NR_OF_ROWS) {
                        break;
                    }
                }
                break;
            }
            diagonalsList.add(  diagonal );
        }

        // Backward diagonals
        for (int column = NR_TO_CONNECT - 1; column < NR_OF_COLUMNS; column++) {
            diagonal = "";
            for ( int position = 0; position < NR_OF_ROWS; position++) {
                int shift = 0;
                while (column - shift >= 0) {
//                    diagonal += (column - shift) + ","
//                            + (position + shift) + " ";
                    diagonal += getColumnField(column - shift
                            , position + shift);
                    shift++;
                    if (shift >= NR_OF_ROWS) {
                        break;
                    }
                }
                break;
            }

            diagonalsList.add(  diagonal );
        }

        diagonals = new String[ diagonalsList.size() ];
        for ( int i = 0; i < diagonalsList.size(); i++ ) {
            diagonals[i] = diagonalsList.get( i );
        }
        return diagonals;
    }
    private String getColumnField(int columnNumber, int position ) {
        if ( position > columns[ columnNumber ].length() - 1 ) {
            return " ";
        } else if (position < 0) {
            return "" + '\u2205'; // ∅
        } else {
            return "" + columns[ columnNumber ].charAt( position );
        }
    }

    @Override
    public boolean start( ) {
        if ( super.start() ) {
            this.columns  = initColumns();
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
        this.columns    = initColumns();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String toString( String extraParameters ) {
        String result = super.toString();
        if ( !extraParameters.toLowerCase().contains( "suppressboard" ) ) {
            result += drawBoard();
        }
        return result;
    }
    private String drawBoard() {
        String capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String header = "\n\n\t  Game board :\n\n\t ";
        for ( int i = 0; i < NR_OF_COLUMNS; i++ ) {
            header += " " + capitals.substring( i, i + 1)  + "  ";
        }
        String[] rows = columnsToRows();
        String line = "\n\t"
                + repeatString( "-", NR_OF_COLUMNS * 4 )
                + "-";
        String result = header + line;

        for ( int row = 0; row < rows.length; row++ ) {
            result += "\n\t|";
            for ( int pos = 0; pos < rows[ row ].length(); pos++ ) {
                result += " " + rows[ row ].charAt( pos ) + " |";
            }
            result += " " + (NR_OF_ROWS - row)
                + line;
        }
        return result;
    }
    private String repeatString(String string, int times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result += string;
        }
        return result;
    }
}
