package com.masterclass;
/*
    Another great class by Zjan Preijde
*/
// TODO: Somehow choosing by number does not work well,
//          only exit ( .equals("9") ) works, other ( switch-case "3": ) do not.
//       Run test : first game interface does not work well

// Only 2 methods that actually directly use Scanner, getInt() and getString().
//  Others make use of these.

import java.util.ArrayList;
import java.util.Scanner;

import static com.masterclass.OutputExtend.*;

public class InputExtend {
    private static Scanner scanner = new Scanner( System.in );

    // User input
    public static int getInt() {
        return getInt( "\tEnter your choice and press ↵" );
    }
    public static int getInt( String prompt ) {
        return getInt( prompt, false, 0, 0 );
    }
    public static int getInt( String prompt, boolean minMax, int min, int max ) {
        String inputPrompt = prompt;
        if ( minMax ) {
            inputPrompt += " (" + min + "-" + max + ")";
        }
        int result = 0;

        o( inputPrompt + " : " , "");
        while ( true ) {
            if ( scanner.hasNextInt() ) {
                result = scanner.nextInt();
            }
            if ( !minMax )
                break;
            if ( result >= min && result <= max )
                break;
            o( "\tInvalid " + "(" + result + ")\n" );
            o( inputPrompt + " : " );
        }
        scanner.nextLine();
        return result;
    }

    public static String getString() {
        return getString( "\tEnter your text and press ↵" );
    }
    public static String getString( String prompt ) {
        return getString( prompt, false, "", "" );
    }
    public static String getString( String prompt
            , boolean minMax, String min, String max ) {
        // Signature String, boolean, String, String -> minMax
        return getString( prompt, minMax, min, max, false );
    }
    public static String getString( String prompt
            , boolean caseInsensitive ) {
        // Signature String, boolean -> toUpperCase
        return getString( prompt, false, "", "", caseInsensitive );
    }
    public static String getString( String prompt
            , boolean minMax, String min, String max, boolean caseInsensitive ) {
        String inputPrompt = prompt;
        String result, resultUp;
        int minCompare, maxCompare;
        if ( minMax ) {
            inputPrompt += " (" + min + "-" + max + ")";
        }

        o( inputPrompt + " : ", "" );
        while ( true ) {
            result   = scanner.nextLine();
            resultUp = result.toUpperCase();
            if ( !minMax )
                break;
            minCompare = ( caseInsensitive ? resultUp : result ).compareTo( min );
            maxCompare = max.compareTo( ( caseInsensitive ? resultUp : result ) );
            if ( minCompare >= 0 && maxCompare >= 0 )
                break;
            o( "\tInvalid " + "(" + result + ")\n", "" );
            o( inputPrompt + " : ", "" );
        }
        return result;
    }

    public static String getYesNo() {
        return getYesNo( "\tMake your choice and press ↵", "Y", "N" );
    }
    public static String getYesNo( String prompt ) {
        return getYesNo( prompt, "Y", "N" );
    }
    public static String getYesNo( String prompt, String yes, String no ) {
        String yesUp = yes.toUpperCase();
        String noUp  = no.toUpperCase();

        String inputPrompt = prompt
                + " (" + yes.toUpperCase() + "/" + no.toUpperCase() + ") : " ;
        String result, resultUp;

        while ( true ) {
            result   = getString( inputPrompt, true );
            resultUp = result.toUpperCase();
            if ( resultUp.equals( yesUp ) || resultUp.equals( noUp ) )
                break;
            o( "\tInvalid " + "(" + result + ")\n" );
        }
        return result;
    }

    /*    Build menu from one or more ArrayList<String>s    */
    /* Overloaders */
    public static String getMenu( String header, ArrayList<String> menuOptions ) {
        ArrayList<String> menuChoices = new ArrayList<>();
        ArrayList<String> menuReturns = new ArrayList<>();
        menuOptions.forEach( option -> {
            menuChoices.add( option.substring( 0,1 ) );
            if ( option.substring( 1,2 ).equals( ". " ) ) {
                option = option.substring( 3 );
            }
            menuReturns.add( option.toLowerCase().replace( " ", "-" ) );
        } );
        return getMenu( header, menuOptions, menuChoices, menuReturns );
    }
    public static String getMenu( String header, ArrayList<String> menuOptions
            , ArrayList<String> menuChoices ) {
        ArrayList<String> menuReturns = new ArrayList<>();
        menuOptions.forEach( option -> {
            if ( option.substring( 1,2 ).equals( ". " ) ) {
                option = option.substring( 3 );
            }
            // "    Menu choice    " -> "menu-choice"
            menuReturns.add( option.toLowerCase()
                .strip()
                .replace( " ", "-" ) );
        } );
        return getMenu( header, menuOptions, menuChoices, menuReturns );
    }
    /* Prepare for and call getAmenu() */
    public static String getMenu( String header, ArrayList<String> menuOptions
            , ArrayList<String> menuChoices, ArrayList<String> menuReturns ) {
        ArrayList<String[]> options = new ArrayList<>();
        String option, returns;
        for ( int i = 0; i < menuOptions.size(); i++ ) {
            option = menuOptions.get( i );
            if ( option.substring( 0,3 ).equals( menuChoices.get(i) + ". " ) )
                option = option.substring( 3 );
            returns = ( menuReturns.isEmpty()
                    ? option.toLowerCase().replace( " ", "-" )
                    : menuReturns.get( i ) );
            options.add( new String[] { menuChoices.get( i ), returns, option } );
        }
        String result = getAMenu( header , options, true );
        return result;
    }

    /*    Build menu from one ArrayList<String[]>    */
    /* Overloader */
    public static String getAMenu( String header, ArrayList<String[]> menuOptions
            , boolean returnCode ) {
        String[] result = getAMenu( header, menuOptions);
        // [0] = "description", [1] = "code", [2] = "choiceChar"
        return result[2];
    }
    public static String[] getAMenu( String header
            , ArrayList<String[]> menuOptions ) {
        // Expects ArrayList<String[ "description",  "code", "choiceID"  ]>
        //   e.g. ["Exit", "quit", "Q"]
        // Older and wiser, return full String[] of chosen option.
        // Chose to make it case insensitive. Maybe later make this optional.
        ArrayList<String> choices = new ArrayList<>();
        String inputPrompt = "\tMake your choice";
        String choice;
        String[] result;

        /* Print header if any */
        if ( !header.equals( "" ) ) {
            oln( "\n"
                    + "\n\t" + "=".repeat( header.length() )
                    + "\n\t" + header
                    + "\n\t" + "-".repeat( header.length() )
            , "");
        }

        /* Print menu, build lists for return value */
        menuOptions.forEach( menuOption -> {
            choices.add( menuOption[ 2 ]);
            oln( "\t" + menuOption[ 2 ] + ". " + menuOption[ 0 ], "");
        } );

        /* Get valid choice */
        while ( true ) {
            choice = getString( inputPrompt, true );
            int chosen = choices.indexOf( choice );
            chosen = ( chosen >= 0 )
                    ? chosen
                    : choices.indexOf( choice.toUpperCase() );
            if ( chosen >= 0 ) {
                result = menuOptions.get( chosen );
                break;
            }
            o( "\tInvalid " + "(" + choice + ")\n" );
        }
        /* return */
        return result;
    }

}
