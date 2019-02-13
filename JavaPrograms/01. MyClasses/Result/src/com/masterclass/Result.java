package com.masterclass;
/*
    Another great class by Zjan Preijde
*/

import java.util.ArrayList;
import java.util.LinkedList;

class Result {
    private boolean success, suppressResult, suppressSuccessString, suppressResultIfSuccess;
    private ArrayList<String> messages;
    private ArrayList<String> errors;

    // primitives, have defaults
    private char    resultChar;
    private boolean resultBoolean;
    private byte    resultByte;
    private short   resultShort;
    private int     resultInt;
    private long    resultLong;
    private float   resultFloat;
    private double  resultDouble;
    /* primitive arrays, have defaults,
         of little use, leave them out for now */
//    char[]    resultChars    = new char[];
//    boolean[] resultBooleans = new boolean[];
//    byte[]    resultBytes    = new byte[];
//    short[]   resultShorts   = new short[];
//    int[]     resultInts     = new int[];
//    long[]    resultShorts   = new long[];
//    float[]   resultShorts   = new float[];
//    double[]  resultFloats   = new double[];

    // native classes, default to null
    private String             resultString    = "";
    private String[]           resultStrings   = new String[ 0 ];
    private ArrayList<String>  resultALStrings = new ArrayList<>();
    private LinkedList<String> resultLLStrings = new LinkedList<>();

    /* Failed attempt to clone Result
       Well, it did sort of, just set all my fields to default values/null */
//    public Result(Result result) {
//    }
    public Result() {
        this( true );
    }
    public Result( boolean success ) {
        this( success, "" );
    }
    public Result( boolean success, String message ) {
        this( success, message, false );
    }
    public Result( boolean success, String message, boolean suppressResult ) {
        this( success, message, suppressResult, true );
    }
    public Result( boolean success, String message, boolean suppressResult
            , boolean suppressSuccessString ) {
        this( success, message, suppressResult, suppressSuccessString, false );
    }
    public Result( boolean success, String message, boolean suppressResult
            , boolean suppressSuccessString, boolean suppressResultIfSuccess ) {
        this.success                 = success;
        this.suppressResult          = suppressResult;
        this.suppressSuccessString   = suppressSuccessString;
        this.suppressResultIfSuccess = suppressResultIfSuccess;
        this.messages = new ArrayList<>();
        this.errors   = new ArrayList<>();
        if ( message != "" ) {
            if ( success ) {
                this.setFail( message );
            } else {
                this.setSucceed( message );
            }
        }
    }
    private void addMessage( String message ) {
        this.messages.add( message );
    }
    private void addError( String message ) {
        this.errors.add( message );
    }
    private String getStatus() {
        String result = ""
                + "\n\t----------------------------"
                + "\n\tStatus result object"
                + "\n\t\t.success                 " + success
                + "\n\t\t.suppressResult          " + suppressResult
                + "\n\t\t.suppressSuccessString   " + suppressSuccessString
                + "\n\t\t.suppressResultIfSuccess " + suppressResultIfSuccess
                + "\n\t\t.messages " + ( messages == null ? "null" : messages.size() )
                + "\n\t\t.errors   " + ( errors   == null ? "null" : errors.size() );
        if ( messages != null && messages.size() > 0 ) {
            result += "\n\tMessages";
            for ( int i =0; i < messages.size(); i++ ) {
                result += "\n\t\t" + messages.get( i );
            }
        }
        if ( errors != null && errors.size() > 0 ) {
            result += "\n\tErrors";
            for ( int i = 0; i < errors.size(); i++ ) {
                result += "\n\t\t" + errors.get( i );
            }
        }
        result += ""
                + "\n\t----------------------------";
        return result;
    }
    public void printMessages() {
        ArrayList<String> result = toStrings();
        for ( int i = 0; i < result.size(); i++ ) {
            oln( result.get( i ));
        }
    }
    public void printStatus() {
        System.out.println( getStatus() );
    }


    // Primitives and native classes result setters and getters at bottom
    /*     Setters and getters     */
    public void setSuppressResult( boolean suppress ){
        this.suppressResult = suppress;
    }
    public void setSuppressSuccessString( boolean suppress ){
        this.suppressSuccessString = suppress;
    }
    public void setSuppressSuccess( boolean suppress ){
        this.suppressResultIfSuccess = suppress;
    }

    public void setFail( String message ){
        this.success = false;
        this.addError( message );
    }
    // Overloading
    public void setSucceed( String message ){
        setSucceed( message, false );
    }
    public void setSucceed( String message, boolean forceSuccess ){
        // If failed, stay failed unless success forced
        this.success = forceSuccess || this.success;
        this.addMessage( message );
    }

    public void reset() {
        reset( false );
    }
    public void reset( boolean suppressResult ) {
        reset( suppressResult, true, false );
    }
    public void reset(boolean suppressResult, boolean suppressSuccessString ) {
        reset( suppressResult, suppressSuccessString, false );
    }
    public void reset( boolean suppressResult, boolean suppressSuccessString, boolean suppressResultIfSuccess ) {
        this.success                 = true;
        this.suppressResult          = suppressResult;
        this.suppressSuccessString   = suppressSuccessString;
        this.suppressResultIfSuccess = suppressResultIfSuccess;
        this.messages = new ArrayList<>();
        this.errors   = new ArrayList<>();
    }

    public boolean isSuccess() {
        return success;
    }
    public boolean isSuppressResult() {
        return suppressResult;
    }
    public boolean isSuppressSuccessString() {
        return suppressSuccessString;
    }
    public boolean isSuppressResultIfSuccess() {
        return suppressResultIfSuccess;
    }
    public ArrayList<String> getMessages() {
        return messages;
    }
    public ArrayList<String> getErrors() {
        return errors;
    }

    public String toString() {
        String result = "";
        if ( success && suppressResultIfSuccess ) {
            return result;
        }
        if ( success ) {
            if ( !suppressSuccessString ) {
                result += "Success. ";
            }
            if ( messages.size() > 0 ) {
                result += ( messages.get( 0 ) );
            }
        } else {
            result += ( errors.size() > 1 ? "MULTIPLE ERRORS! " : "ERROR! " );
            if ( errors.size() > 0 ) {
                result += ( errors.get( 0 ) );
            }
        }
        return result;
    }
    public ArrayList<String> toStrings() {
        ArrayList <String> results = new ArrayList <>();
        String result = "";
        if ( success ) {
            if ( !suppressResultIfSuccess && !suppressSuccessString ) {
                result += "Success. ";
            }
        } else {
            result += ( errors.size() > 1 ? "MULTIPLE ERRORS! " : "ERROR! " );
        }
        if ( ( messages.size() ) + errors.size() == 1 ) {
            result += messages.size() == 1 ? this.messages.get( 0 ) : errors.get( 0 );
        }

        if ( result != "" ) {
            results.add( result );
        }

        if ( messages.size() + errors.size() > 1 ) {
            if ( messages.size() > 1 ) {
                results.add( "Messages :" );
                // TODO: .forEach()
                for ( int i = 0; i < messages.size(); i++ )  results.add( messages.get( i ) );
            }
            if ( errors.size() > 1 ) {
                results.add( "Errors :" );
                // TODO: .forEach()
                for ( int i = 2; i < errors.size(); i++ )    results.add( errors.get( i ) );
            }
        }
        return results;
    }

    /*     Setters of primitives and native classes, rely on signature     */
    // TODO: private
    public void setResult( char value    ) { this.resultChar = value; }
    public void setResult( boolean value ) { this.resultBoolean = value; }
    public void setResult( byte value    ) { this.resultByte = value; }
    public void setResult( short value   ) { this.resultShort = value; }
    public void setResult( int value     ) { this.resultInt = value; }
    public void setResult( long value    ) { this.resultLong = value; }
    public void setResult( float value   ) { this.resultFloat = value; }
    public void setResult( double value  ) { this.resultDouble = value; }
    public void setResult( String value  ) { this.resultString = value; }
    // TODO: .clone()?
    public void setResult( String[] value) { this.resultStrings = value.clone(); }
    public void setResult( ArrayList<String> value ) {
        // I'm sure I will learn a better way later
        this.resultALStrings = new ArrayList<>();
        for ( int i = 0; i < value.size(); i++ ) {
            this.resultALStrings.add( value.get( i ) );
        }
    }
    public void setResult( LinkedList<String> value ) {
        // I'm sure I will learn a better way later
        this.resultLLStrings = new LinkedList<>();
        for ( int i = 0; i < value.size(); i++ ) {
            this.resultLLStrings.add( value.get( i ) );
        }
    }

    /*     Setters of primitives and native classes, hoped to rely on signature, but did not work     */
    public char    getResult()  { return this.resultChar; }
    public boolean getBoolean() { return this.resultBoolean; }
    public byte    getByte()    { return this.resultByte; }
    public short   getShort()   { return this.resultShort; }
    public int     getInt()     { return this.resultInt; }
    public long    getLong()    { return this.resultLong; }
    public float   getFloat()   { return this.resultFloat; }
    public double  getDouble()  { return this.resultDouble; }
    public String  getString()  { return this.resultString; }
    public String[]           getStrings()   { return this.resultStrings; }
    public ArrayList<String>  getALStrings() { return this.resultALStrings; }
    public LinkedList<String> getLLStrings() { return this.resultLLStrings; }

}
