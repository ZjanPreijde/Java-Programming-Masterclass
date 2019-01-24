package com.masterclass;

public class Main {

    private static void printHeader(String header) {
        System.out.println("-----------");
        System.out.println(header);
    }

    public static void main(String[] args) {
        printHeader("Exercises :");
        NumberInWord();
        NumberOfDaysInMonth();
    }
    private static void NumberInWord() {
        printHeader("1. NumberInWord");
        System.out.print("0: ");printNumberInWord(0);
        System.out.print("1: ");printNumberInWord(1);
        System.out.print("2: ");printNumberInWord(2);
        System.out.print("3: ");printNumberInWord(3);
        System.out.print("4: ");printNumberInWord(4);
        System.out.print("5: ");printNumberInWord(5);
        System.out.print("6: ");printNumberInWord(6);
        System.out.print("7: ");printNumberInWord(7);
        System.out.print("8: ");printNumberInWord(8);
        System.out.print("9: ");printNumberInWord(9);
        System.out.print("-1: ");printNumberInWord(-1);
        System.out.print("10: ");printNumberInWord(10);
    }
    public static void printNumberInWord(int number) {
        String sResult;
        switch (number) {
            case 0:
                sResult = "ZERO";
                break;
            case 1:
                sResult = "ONE";
                break;
            case 2:
                sResult = "TWO";
                break;
            case 3:
                sResult = "THREE";
                break;
            case 4:
                sResult = "FOUR";
                break;
            case 5:
                sResult = "FIVE";
                break;
            case 6:
                sResult = "SIX";
                break;
            case 7:
                sResult = "SEVEN";
                break;
            case 8:
                sResult = "EIGHT";
                break;
            case 9:
                sResult = "NINE";
                break;
            default:
                sResult = "OTHER";
                break;
        }
        System.out.println(sResult);

    }

    private static void NumberOfDaysInMonth() {
        printHeader("2. NumberOfDaysInMonth");
        System.out.println("1,2020.  31 :" + getDaysInMonth(1,2020));
        System.out.println("2,2020.  29 :" + getDaysInMonth(2,2020));
        System.out.println("2,2018.  28 :" + getDaysInMonth(2,2018));
        System.out.println("-1,2020. -1 :" + getDaysInMonth(-1,2020));
        System.out.println("1,-2020. -1 :" + getDaysInMonth(1,-2020));
    }
    public static int getDaysInMonth(int month, int year) {
        if (month < 1 || month > 12 || year < 1 || year > 9999) {
            return -1;
        } else {
            switch (month) {
                case 2:
                    return 28 + (isLeapYear(year) ? 1 : 0);
                case 4:
                case 6:
                case 9:
                case 11:
                    return 30;
                default:
                    return 31;
            }
        }
    }
    public static boolean isLeapYear(int year) {
        return (year >= 1 && year <= 9999)
                && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
    }
}
