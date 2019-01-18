package com.masterclass;

public class Main {

    public static void main(String[] args) {

        System.out.println("Value wrapping around boundaries integers :");
        byte  myByteMax  =  127;
        byte  myByteMin  = -128;
        byte  myByteWrapMax = (byte) (myByteMax + 1);
        byte  myByteWrapMin = (byte) (myByteMin - 1);
        System.out.println(myByteMax + " + 1 = " + myByteWrapMax); // -128
        System.out.println(myByteMin + " - 1 = " + myByteWrapMin); //  127

        short myShortMax =  32_767;
        short myShortMin = -32_768;
        short myShortWrapMax = (short) (myShortMax + 1);
        short myShortWrapMin = (short) (myShortMin - 1);
        System.out.println(myShortMax + " + 1 = " + myShortWrapMax); // -32768
        System.out.println(myShortMin + " - 1 = " + myShortWrapMin); //  32767

        int   myIntMax   =  2_147_483_647;
        int   myIntMin   = -2_147_483_648;
        long  myLongMax  =  9_223_372_036_854_775_807L;
        long  myLongMin  = -9_223_372_036_854_775_808L;

        // Assignment
        System.out.println("");
        System.out.println("Assignment :");
        int   intValue   = 10;
        byte  byteValue  = 20;
        short shortValue = 50;
        long  longTotal  = (50000L + 10L * (byteValue + shortValue + intValue));
        short shortTotal = (short) (1000 + 10 * (byteValue + shortValue + intValue));

        System.out.println("Long  Value : " + longTotal);   // 50800
        System.out.println("Short Value : " + shortTotal);   //1800
    }
}
