package com.masterclass;
/*
    Another great class by Zjan Preijde
*/
import static com.masterclass.Result.*;
import static com.masterclass.OutPutExtend.*;

public class TestResult {
    public static void main( String[] args ) {
        testResult();
    }

    public static void testResult() {
        String result;

        oln( "\n= Create result1" );
        Result result1 = new Result();
        result = result1.toString(); if ( result!="" ) oln( result );
        o( "\n= Status result1" );
        result1.printStatus();

        oln( "\n= Set fail 1 result1" );
        result1.setFail( "Error1 occurred" );
        result = result1.toString(); if ( result!="" ) oln( result );
        o( "\n= Status result1" );
        result1.printStatus();

        oln( "\n= Set success 1 result1" );
        result1.setSucceed( "Succes1. All went well" );
        result = result1.toString(); if ( result!="" ) oln( result );
        o( "\n= Status result1" );
        result1.printStatus();

        oln( "\n= Set success 2 result1, forceSuccess" );
        result1.setSucceed( "Succes2. All went well", true );
        result = result1.toString(); if ( result!="" ) oln( result );
        o( "\n= Status result1" );
        result1.printStatus();

        oln( "\n= Set fail 2 result1" );
        result1.setFail( "Error2 occurred" );
        result = result1.toString(); if ( result!="" ) oln( result );
        o( "\n= Status result1" );
        result1.printStatus();

        oln( "\n= Reset result1" );
        result1.reset();
        result = result1.toString(); if ( result!="" ) oln( result );
        o( "\n= Status result1" );
        result1.printStatus();

        oln( "\n= Create result2" );
        Result result2 = new Result();
        result = result2.toString(); if ( result!="" ) oln( result );
        o( "\n= Status result2" );
        result2.printStatus();

        oln( "\n= Set success 1 result2" );
        result2.setSucceed( "Succes1. All went well" );
        result = result2.toString(); if ( result!="" ) oln( result );
        o( "\n= Status result2" );
        result2.printStatus();

        oln( "\n= Set success 1 result2" );
        result2.setSucceed( "Succes2. All went well" );
        result = result2.toString(); if ( result!="" ) oln( result );
        o( "\n= Status result2" );
        result2.printStatus();

    }
}
