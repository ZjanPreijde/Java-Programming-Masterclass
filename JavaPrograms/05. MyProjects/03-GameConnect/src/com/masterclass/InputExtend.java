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
import static com.masterclass.ArrayExtend.*;

public class InputExtend {
    private static Scanner scanner = new Scanner( System.in );

    // User input
    public static int getInt() {
        return getInt( "\tEnter your choice" );
    }
    public static int getInt( String prompt ) {
        return getInt( prompt, false, 0, 0 );
    }
    public static int getInt( String prompt, boolean minMax, int min, int max ) {
        String inputPrompt = prompt + " and press ↵";
        if ( minMax ) {
            inputPrompt += " (" + min + "-" + max + ")";
        }
        int result = 0;

        o( inputPrompt + " : " );
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
        return getString( "\tEnter your text" );
    }
    public static String getString( String prompt ) {
        return getString( prompt, false, "", "" );
    }
    public static String getString( String prompt
            , boolean minMax, String min, String max ) {
        // Signature String, boolean, String, String -> minMax
        // Default caseInsensitive now true
        return getString( prompt, minMax, min, max, true );
    }
    public static String getString( String prompt
            , boolean caseInsensitive ) {
        // Signature String, boolean -> toUpperCase
        return getString( prompt, false, "", "", caseInsensitive );
    }
    public static String getString( String prompt
            , boolean minMax, String min, String max, boolean caseInsensitive ) {
        String inputPrompt = prompt + " and press ↵";
        String result, resultUp;
        int minCompare, maxCompare;
        if ( minMax ) {
            inputPrompt += " (" + min + "-" + max + ")";
        }

        o( inputPrompt + " : " );
        while ( true ) {
            result   = scanner.nextLine();
            resultUp = result.toUpperCase();
            if ( !minMax )
                break;
            minCompare = ( caseInsensitive ? resultUp : result ).compareTo( min );
            maxCompare = max.compareTo( ( caseInsensitive ? resultUp : result ) );
            if ( minCompare >= 0 && maxCompare >= 0 )
                break;
            o( "\tInvalid " + "(" + result + ")\n" );
            o( inputPrompt + " : " );
        }
        return result;
    }

    public static String getYesNo() {
        return getYesNo( "\tMake your choice", "Y", "N" );
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
    public static String[] getMenu( String header
            , ArrayList<String> menuOptions ) {
        ArrayList<String> menuCodes   = new ArrayList<>();
        ArrayList<String> menuChoices = new ArrayList<>();
        for (int i = 0; i < menuOptions.size(); i++) {
            String option = menuOptions.get( i );
            menuChoices.add( option.substring( 0,1 ) );
            menuCodes.add( option
                    .strip()
                    .replace( " ", "-" )
                    .toLowerCase()
            );
        }
        return getMenu( header, menuOptions, menuCodes, menuChoices );
    }
    public static String[] getMenu( String header
            , ArrayList<String> menuOptions
            , ArrayList<String> menuChoices ) {
        ArrayList<String> menuCodes = new ArrayList<>();
        String option, code;
        for (int i = 0; i < menuOptions.size(); i++) {
            code = menuOptions.get( i );
            if ( code.substring( 0,3 ).equals( menuChoices.get( i ) + ". " ) ) {
                code = code.substring( 3 );
            }
            // "    Menu Option    " -> "menu-option"
            menuCodes.add( code
                    .strip()
                    .replace( " ", "-" )
                    .toLowerCase()
            );
        }
        return getMenu( header, menuOptions, menuCodes, menuChoices );
    }
    /* Prepare for and call getAmenu() */
    public static String[] getMenu( String header
            , ArrayList<String> menuOptions
            , ArrayList<String> menuCodes
            , ArrayList<String> menuChoices ) {
        ArrayList<String[]> options = new ArrayList<>();
        String option, choice, code;
        boolean codesIsEmpty = menuCodes.isEmpty();
        for ( int i = 0; i < menuOptions.size(); i++ ) {
            option = menuOptions.get( i );
            choice = menuChoices.get( i );
            if ( codesIsEmpty) {
                code = option;
                if ( code.substring( 0,3 ).equals( menuChoices.get(i) + ". " ) ) {
                    code = code.substring( 3 );
                }
                code = code
                        .strip()
                        .toLowerCase()
                        .replace( " ", "-");
            } else {
                code = menuCodes.get( i ) ;
            }
            options.add( new String[] { option, code, choice } );
        }
        return getAMenu( header, options);
    }

    /*    Build menu from one ArrayList<String[]>    */
    /* Overloaded */
    public static String[] getAMenu( String header
            , ArrayList<String[]> menuOptions) {
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
            printHeader( header, true
                    , "=", "-", "\t", "");
        }

        /* Print menu, build lists for return value */
        menuOptions.forEach( menuOption -> {
            choices.add( menuOption[ 2 ]);
            /* "optionID. Menu Option" */
            String option = menuOption[0], optionChar = menuOption[2];
            if ( option.substring( 0,3 ).equals( optionChar + ". " ) ) {
                option = option.substring( 3 );
            }
            oln( "\t" + optionChar + ". " + option, "" );
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
        /* returns ["Menu Option", "menu-option", "optionID"] */
        return result;
    }

}
