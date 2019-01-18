package com.masterclass;

public class Main {

    public static void main(String[] args) {
	    // Exercises
        AreaCalculator();
        MinutesToYearsDaysCalculator();
        IntEqualityPrinter();
        PlayingCat();
    }

    public static void AreaCalculator() {
        System.out.println("1. AreaCalculator() :");
        System.out.println(" 5.0.      78.53975 : " + area(5.0));
        System.out.println("  -1.      -1       : " + area(-1));
        System.out.println(" 5.0, 4.0. 20.0     : " + area(5.0, 4.0));
        System.out.println("-1.0, 5.0. -1       : " + area(-1.0, 5.0));
    }
    public static double area(double radius) {
        return area(radius, radius * 3.14159d);
    }
    public static double area(double x, double y) {
        return (x >= 0 && y >= 0) ? x * y : -1;
    }

    public static void MinutesToYearsDaysCalculator() {
        System.out.println("2. MinutesToYearsDaysCalculator()");
        System.out.print("525600.  1 y and 0 d  : ");
        printYearsAndDays(525600);
        System.out.print("1051200. 2 y and 0 d  : ");
        printYearsAndDays(1051200);
        System.out.print("561600.  1 y and 25 d : ");
        printYearsAndDays(561600);
    }
    public static void printYearsAndDays(long minutes) {
        long years = (long) (minutes / (365*24*60));
        long remMin = minutes - (years * (365*24*60));
        long days  = (long) ( remMin / (24*60) );
        System.out.println( minutes >= 0
            ? minutes + " min = " + years + " y and " + days + " d"
            : "Invalid Value"
        );
    }

    public static void IntEqualityPrinter() {
        System.out.println("3. IntEqualityPrinter() :");
        System.out.print("1,1,1. All numbers are equal : ");
        printEqual(1,1,1);
        System.out.print("1,1,2. Neither all are equal or different : ");
        printEqual(1,1,2);
        System.out.print("-1,-1,-1. Invalid Value : ");
        printEqual(-1,-1,-1);
        System.out.print("1,2,3. All numbers are different : ");
        printEqual(1,2,3);
    }
    public static void printEqual(int iOne, int iTwo, int iThree) {
        if (iOne < 0 || iTwo < 0 || iThree < 0) {
            System.out.println("Invalid Value");
        } else if (iOne == iTwo && iTwo == iThree) {
            System.out.println("All numbers are equal");
        } else if (iOne == iTwo || iTwo == iThree || iOne == iThree) {
            System.out.println("Neither all are equal or different");
        } else {
            System.out.println("All numbers are different");
        }
    }

    public static void PlayingCat() {
        System.out.println("4. PlayingCat() :");
        System.out.println("true,  10. false : " + isCatPlaying(true, 10));
        System.out.println("false, 36. false : " + isCatPlaying(true, 36));
        System.out.println("false, 35. true  : " + isCatPlaying(true, 35));

    }
    public static boolean isCatPlaying(boolean summer, int temperature) {
        return temperature >= 25 && temperature <= (summer ? 45 : 35);
    }
}
