package com.masterclass;

public class Main {

    public static void main(String[] args) {
        int    myIntValue1    = 5;

        float  myFloatValue1  = 5f;
        float  myFloatValue2  = (float) (5);
        float  myFloatValue3  = 5.25f;
        float  myFloatValue4  = (10f /3f);
        float  myFloatValue5  = (float) (10.0/3);   // Decimal point -> double, cast to float
        System.out.println("myFloatValue1: " + myFloatValue1);
        System.out.println("myFloatValue2: " + myFloatValue2);
        System.out.println("myFloatValue3: " + myFloatValue3);
        System.out.println("myFloatValue4: " + myFloatValue4);
        System.out.println("myFloatValue5: " + myFloatValue5);

        double myDoubleValue1 = 5d;
        double myDoubleValue2 = (double) (5);
        double myDoubleValue3 = 5.25;       // Decimal point -> double
        double myDoubleValue4 = (10d/  3d); // No decimal point -> int, cast to double
        double myDoubleValue5 =  10.0/ 3;   // Decimal point -> double
        System.out.println("myDoubleValue1: " + myDoubleValue1);
        System.out.println("myDoubleValue2: " + myDoubleValue2);
        System.out.println("myDoubleValue3: " + myDoubleValue3);
        System.out.println("myDoubleValue4: " + myDoubleValue4);
        System.out.println("myDoubleValue5: " + myDoubleValue5);

        double poundFactor = 0.45359237;
        int    kilograms   = 70;
        int    pounds      = 150;
        double poundCalc   = kilograms / poundFactor;
        double kiloCalc    = pounds * poundFactor;
        System.out.println(kilograms + "kg = " + poundCalc + "lbs");
        System.out.println(pounds + "lbs = " + kiloCalc + "kg");
    }
}
