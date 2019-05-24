package com.masterclass;

public class Main {

    public static void main(String[] args) {
        // Coding exercises
        SpeedConverter();
	    MegaBytesConverter();
	    BarkingDog();
	    LeapYear();
	    DecimalComparator();
	    EqualSumChecker();
	    TeenNumberChecker();
    }

    // 0. Speedconverter, added to course later. Very lengthy explanation how
    //     to commit exercise solutions and pitfalls
    public static void SpeedConverter() {
        System.out.println("0. SpeedConverter() :");
        System.out.println("25.42, 25.42 km/h = 16 mi/h");
        SpeedConverter.printConversion( 25.42 );
    }

    // 1. MegaBytesConverter
    public static void MegaBytesConverter() {
        System.out.println("1. MegaBytesConverter() :");
        System.out.println("2050, 2050 KB = 2 MB and 2 KB :");
        printMegaBytesAndKiloBytes(2050);
    }
    public static void printMegaBytesAndKiloBytes(int kiloBytes) {
        int kbsInMb, mbs, kbs;
        kbsInMb = 1024;
        if (kiloBytes < 0) {
            System.out.println("Invalid Value");
        } else {
            mbs = kiloBytes / kbsInMb;
            kbs = kiloBytes % kbsInMb;
            System.out.println(kiloBytes + " KB"
                + " = " + mbs + " MB"
                + " and " + kbs + " KB");
        }
    }

    // 2. Barking Dog
    public static void BarkingDog() {
        System.out.println("2. BarkingDog() :");
        System.out.println("true,  -1, false : " + bark(true, -1));
        System.out.println("true,   1, true  : " + bark(true, 1));
        System.out.println("true,  11, false : " + bark(true, 11));
        System.out.println("false, 11, false : " + bark(false, 11));
        System.out.println("true,  23, true  : " + bark(true, 23));
        System.out.println("false, 23, false : " + bark(false, 23));
    }
    public static boolean bark(boolean barking, int hourOfDay) {
        return barking
                && ( hourOfDay >= 0 && hourOfDay <= 23)
                && ( hourOfDay < 8 || hourOfDay > 22 );
    }

    // 3. Leap Year Calculator
    public static void LeapYear() {
        System.out.println("3. LeapYear() :");
        System.out.println("-1600, false : " + isLeapYear(-1600));
        System.out.println(" 1600, true  : " + isLeapYear(1600));
        System.out.println(" 2017, false : " + isLeapYear(2017));
        System.out.println(" 2000, true  : " + isLeapYear(2000));
    }
    public static boolean isLeapYear(int year) {
        return (year > 0 && year < 10000)
                ? (year % 4 == 0 && year % 100 > 0) || year % 400 == 0
                : false;
    }

    // 4. DecimalComparator
    public static void DecimalComparator() {
        System.out.println("4. DecimalComparator() :");
        System.out.println("-3.1756, -3.175, true : "
                + areEqualByThreeDecimalPlaces(-3.1756, -3.175));
        System.out.println("3.175, 3.176, false : "
                + areEqualByThreeDecimalPlaces(3.175, 3.176));
        System.out.println("3.0, 3.0, true : "
                + areEqualByThreeDecimalPlaces(3.0, 3.0));
    }
    public static boolean areEqualByThreeDecimalPlaces(double dOne, double dTwo) {
        int iOne = (int) (dOne * 1000), iTwo = (int) (dTwo * 1000);
        return iOne == iTwo;
    }

    // 5. EqualSumChecker
    public static void EqualSumChecker() {
        System.out.println("5. EqualSumChecker :");
        System.out.println("1,1,1  : false : " + hasEqualSum(1,1,1));
        System.out.println("1,1,2  : true  : " + hasEqualSum(1,1,2));
        System.out.println("1,-1,0 : true  : " + hasEqualSum(1,-1,0));
    }
    public static boolean hasEqualSum(int iOne, int iTwo, int iCheck) {
        return iOne + iTwo == iCheck;
    }

    // 6. TeenNumberChecker()
    public static void TeenNumberChecker() {
        System.out.println("6. TeenNumberChecker :");
        System.out.println("9, 99, 19, true : " + hasTeen(9, 99, 19));
        System.out.println("23, 15, 32, true : " + hasTeen(23, 15, 32));
        System.out.println("22, 23, 34, false : " + hasTeen(22, 23, 34));
    }
    public static boolean hasTeen(int iOne, int iTwo, int iThree) {
        return (iOne >= 13 && iOne <= 19)
                || (iTwo >= 13 && iTwo <= 19)
                || (iThree >= 13 && iThree <= 19);
    }

}
