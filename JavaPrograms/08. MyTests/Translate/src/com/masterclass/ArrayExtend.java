package com.masterclass;
/*
    Another great class by Zjan Preijde
*/


import java.util.ArrayList;

//TODO: Create 'left side right' flip, reverse row contents?
//TODO:
//TODO: Pad 45 flips with spaces for visual representation
//       so 12 becomes   1
//          34          3 2
//                       4
import static com.masterclass.OutputExtend.*;

public class ArrayExtend {
    public static String[] result;

//    QUICK AND DIRTY PASTE, EMBED LATER
    public static String[] arrayTableBeautify( String[] table ) {
        // Maybe 2 later, no cells.
        if ( table.length < 3 ) { return table; /* Nothing to do */ }

        // Flip table, top to left side, eases translation
        String[] result = arrayFlip( table, "backward" );
        // First row is last column of table
        String[] newTable = new String[ result.length ];

        // temp, double verticals later?
        //  maybe needs another flip?
        String doubleBorders = ""
            + "╔═══╦═══╗"
            + "╠═══╬═══╣"
            + "║   ║   ║"
            + "╚═══╩═══╝";
        // temp


        for (int i = 0; i < result.length; i++) {
            String  row         = result[ i ];
            boolean firstColumn = ( i == result.length - 1 ); // Flipped backward
            boolean lastColumn  = ( i == 0 );
            boolean middleColumn = !( firstColumn || lastColumn );
            int rowLength       = row.length();

            String firstChars, between, lastChars;
            String  newRow = ""; // Not necessary, but Java nags
            if ( rowLength == 3 ) {
                // Original table has one row
                firstChars = row;
                between    = "";
                lastChars  = "";
                if ( firstColumn ) {
                    newRow =
                        ( firstChars
                            .replace("=|=", "╒│╘")
                            .replace("-|-", "┌│└")
                            .replace("=|-", "╒│└")
                            .replace("-|=", "┌│╘")
                        );
                }
                if ( middleColumn) {
                    newRow =
                        ( firstChars
                            .replace("=|=", "╤│╧")
                            .replace("-|-", "┬│┴")
                            .replace("=|-", "╤│┴")
                            .replace("-|=", "┬│╧")
                            .replace("=", "═" )
                            .replace("-", "─" )
                        );

                }
                if ( lastColumn ) {
                    newRow =
                        ( firstChars
                            .replace("=|=", "╕│╛")
                            .replace("-|-", "┐│┘")
                            .replace("=|-", "╕│┘")
                            .replace("-|=", "┐│╛")
                        );
                }
            } else {
                int startAt = ( firstColumn || lastColumn ) ? 1: 2;
                firstChars = row.substring( 0,startAt );
                between    = row.substring( startAt, rowLength - 2 );
                lastChars  = row.substring( rowLength - 2 );

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
                } // firstColumn
                if ( middleColumn ) {

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
                } // middleColumn
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
                } // lastColumn
            } // <- rowLength == 3
            newTable[ i ] = newRow;
        }


        // Flip back forward
        newTable = arrayFlip( newTable, "forward" );
        return newTable;
    }

    public static boolean arrayCompare( String[] array1, String[] array2) {
        return arrayCompare( array1, array2, false);
    }
    public static boolean arrayCompare( String[] array1, String[] array2
            , boolean debug ) {
        boolean result = true;
        if ( !( array1.length == array2.length) ) {
            result = false;
            if ( debug ) {
                olt( "length " + array1.length
                    + " != " + array2.length, false );
            }
        }
        if ( result ) {
            for (int i = 0; i < array1.length; i++) {
                if ( !( array1[i].equals( array2[i] ) ) ){
                    result = false;
                    if ( debug ) {
                        olt( "[" + i + "]. "
                                + "string " + array1[i] + " != " + array2[i]
                            , false );
                    }
                }
            }
        }
        return result;
    }
// <-    QUICK AND DIRTY PASTE, EMBED LATER

    // boolean hasValue String[]
    public static boolean hasValue( String[] checkArray
            , String checkValue) {
        return hasValue( checkArray, checkValue, false );
    }
    public static boolean hasValue( String[] checkArray
            , String checkValue, boolean ignoreCase ) {
        for ( String value : checkArray ) {
            if ( value == checkValue ) { return true; }
            if ( ignoreCase && ( value.toLowerCase() == checkValue.toLowerCase() ) ) {
                return true;
            }
        }
        return false;
    }
    // boolean hasValue int[]
    public static boolean hasValue( int[] checkArray, int checkValue ) {
        for ( int value : checkArray ) {
            if ( value == checkValue ) { return true; }
        }
        return false;
    }

    // String getValue()
    public static String getValue( String[] array, int row, int at ) {
        return getValue( array, row, at, " ");
    }
    public static String getValue( String[] array, int row, int at
            , String defaultValue ) {
        return getValue( array, row, at, defaultValue, "" + null ); /* '\uFFFD' = � */
    }
    public static String getValue( String[] array, int row, int at
            , String defaultValue
            , String invalidValue ) {
        if ( row < 0 )                     return invalidValue;
        if ( row >= array.length )         return invalidValue;
        if ( at < 0 )                      return invalidValue;
        if ( at >= array[ row ].length() ) return defaultValue;  // ??
        return "" + array[ row ].charAt( at );
    }
    // int getValue()
    public static int getValue( int[] array, int row) {
        return getValue( array, row, 0);
    }
    public static int getValue( int[] array, int row
            , int defaultValue ) {
        return getValue( array, row, defaultValue, -1 );
    }
    public static int getValue( int[] array, int row
            , int defaultValue
            , int invalidValue ) {
        if ( row < 0 )             return invalidValue;
        if ( row >= array.length ) return defaultValue; // ??
        return array[ row ];
    }
    // int maxRowLength( String[] array, int currentMax )
    public static int maxRowLength( String[] array ) {
        return maxRowLength( array, 0 );
    }
    public static int maxRowLength( String[] array, int max ) {
        for ( String row : array) {
            max = row.length() > max ? row.length() : max;
        }
        return max;
    }

    public static String[] padArray ( String[] array, int rowLength ) {
        String[] padArray ;
        padArray = new String[ array.length ];
        for ( int x = 0; x < array.length; x++ ) {
            padArray[ x ] = array[ x ] + " ".repeat( rowLength );
            padArray[ x ] = padArray[ x ].substring( 0, rowLength  );
        }
        return padArray;
    }

    // public arrayFlip String[], no direction
    public static String[] arrayFlip( String[] array ) {
        return arrayFlip( array, "halfcircle" );
    }
    // public arrayFlip String[], direction int
    public static String[] arrayFlip( String[] array, int direction ) {
        int[] valids = new int[] { 180, 90, -90, 45, -45 };
        if ( !hasValue( valids , direction ) ) {
            return array;
        }
        switch ( direction ) {
            case 90:
                return arrayFlip( array, "forward" );
            case 45:
                return arrayFlip( array, "forward45" );
            case -90:
                return arrayFlip( array, "backward" );
            case -45:
                return arrayFlip( array, "backward45" );
            default:
                return flip180( array );
        }
    }
    // public arrayFlip String[], direction String
    public static String[] arrayFlip( String[] array, String direction ) {
        String[] valids = new String[] { "halfcircle"
                , "forward" , "forward45"
                , "backward", "backward45" };
        if ( !hasValue( valids , direction, true ) ) {
            return flip180( array );
        }
        switch (direction) {
            case "forward":
                return flip90( array, false );
            case "backward":
                return flip90( array, true );
            case "forward45":
                return flip45( array );
            case "backward45":
                // First -90 deg, than +45 deg
                return  flip45( flip90( array ) ) ;
            default:
                return flip180( array );
        }
    }

    // private flip180(), flip 180 degrees
    private static String[] flip180( String[] array ) {
        // Flip 90 twice
        return flip90( flip90( array ) );
    }

    // private flip90(), flip 90 degrees
    private static String[] flip90( String[] array ) {
        return flip90( array, false );
    }
    private static String[] flip90( String[] array
            , boolean reverse ) {
        // Flip content or ArrayList 90/-90 degrees
        if ( array == null ) {
            // Should not get here
            return array;
        }

        int oldArrayLength = array.length;
        int maxRowLength   = maxRowLength( array );

        String[] padArray = padArray( array, maxRowLength );
        ArrayList<String> resultList = new ArrayList<>();
        String resultItem;

        if ( reverse ) {
            // Flip Backward
            for ( int oldCol = maxRowLength - 1; oldCol >=0; oldCol-- ) {
                resultItem = "";
                for ( int oldRow = 0; oldRow < oldArrayLength; oldRow++ ) {
                    resultItem += getValue( padArray, oldRow, oldCol );
                }
                resultList.add( resultItem );
            }
        } else {
            // Flip Forward
            for ( int oldCol = 0; oldCol < maxRowLength; oldCol++ ) {
                resultItem = "";
                for ( int oldRow = oldArrayLength - 1; oldRow >= 0; oldRow-- ) {
                    resultItem += getValue( padArray, oldRow, oldCol );
                }
                resultList.add( resultItem );
            }
        }
        return listToArray( resultList );
    }


    // Flip content of String[] 45, only forward, backward by -90deg +45deg
    private static String[] flip45( String[] array ) {
        if ( array == null ) {
            // Should not get here
            return array;
        }
        int arrayLength  = array.length;
        int maxRowLength = maxRowLength( array );

        String diagonal;
        ArrayList <String> diagonalsList = new ArrayList <>(  );

        for ( int realX = 0; realX < arrayLength + maxRowLength - 1; realX++ ) {
            diagonal = "";
            // Forward
            for ( int checkY = 0; checkY < maxRowLength ; checkY++ ) {
                int checkX = realX - checkY ;
                if ( checkX >= 0
                        && checkX < arrayLength ) {
                    diagonal += getValue( array, checkX, checkY, "" );
                } else {
                    diagonal += "";
                }
            }
            diagonalsList.add( diagonal );
        }

        // .forEach() not possible thinks me
        result = new String[ diagonalsList.size() ];
        for ( int i = 0; i < diagonalsList.size(); i++ ) {
            result[i] = diagonalsList.get( i );
        }
        return result;
    }

    //TODO : In future ArrayListExtend ?
    private static String[] listToArray( ArrayList<String> list ) {
        String[] array = new String[ list.size() ];
        // .forEach() not possible thinks me
        for ( int row = 0; row < list.size(); row++ ) {
            array[ row ] = list.get( row );
        }
        return array;
    }
}
