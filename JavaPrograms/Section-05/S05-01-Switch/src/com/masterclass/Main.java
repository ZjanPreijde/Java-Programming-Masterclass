package com.masterclass;

public class Main {

    public static void main(String[] args) {

        doExample1();
        doChallenge1();
        doExample2();
        doChallenge2();
    }

    private static void doExample1() {
        System.out.println("-------");
        System.out.println("Example 1 :");
        mySwitch1(1);
        mySwitch1(2);
        mySwitch1(3);
        mySwitch1(4);
        mySwitch1(5);
        mySwitch1(6);
        mySwitch1(7);
    }

    private static void mySwitch1(int intArg) {
        String sResult = intArg + " : ";
        switch (intArg) {
            case 1:
                sResult += "Value was 1";
                break;
            case 2:
                sResult += "Value was 2";
                break;
            case 3:
            case 4:
                sResult += "Value was 3/4";
                break;
            case 5:
            case 6:
                sResult += "Value was 5/6";
                break;
            default:
                sResult += "Value was not 1-6";
                break;
        }
        System.out.println(sResult);

    }

    private static void doChallenge1() {
        // Nice way to find out : char has to be assigned a value with single quotes
        System.out.println("-------");
        System.out.println("Challenge 1 :");
        System.out.println(mySwitch2('A'));
        System.out.println(mySwitch2('E'));
        System.out.println(mySwitch2('a'));

    }

    private static String mySwitch2(char cArg) {
        String sResult = cArg + ": ";
        switch (cArg) {
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
                sResult += cArg + " was found";
                break;
            default:
                sResult += "Neather A, B, C, D, or E were found";
                break;
        }
        return sResult;
    }

    private static void doExample2() {
        System.out.println("-------");
        System.out.println("Example 2 :");
        System.out.println(mySwitch3("january"));
        System.out.println(mySwitch3("MAY"));
        System.out.println(mySwitch3("holiDAY"));
    }

    private static String mySwitch3(String month) {
        String sResult = month + " : ";
        switch (month.toLowerCase()) {
            case "january":
            case "february":
            case "march":
                sResult += "Quarter 1";
                break;
            case "april":
            case "may":
            case "june":
                sResult += "Quarter 2";
                break;
            case "july":
            case "august":
            case "september":
                sResult += "Quarter 3";
                break;
            case "october":
            case "november":
            case "december":
                sResult += "Quarter 4";
                break;
            default:
                sResult += "Unable to determine quarter";
                break;
        }
        return sResult;
    }

    private static void doChallenge2() {
        System.out.println("-------");
        System.out.println("Challenge 2 :");
        printDayOfTheWeek(0);
        printDayOfTheWeek(3);
        printDayOfTheWeek(6);
        printDayOfTheWeek(9);
        printDayOfTheWeek2(0);
        printDayOfTheWeek2(3);
        printDayOfTheWeek2(6);
        printDayOfTheWeek2(9);

    }

    private static void printDayOfTheWeek(int day) {
        String sResult;
        switch (day) {
            case 0:
                sResult = "Sunday";
                break;
            case 1:
                sResult = "Monday";
                break;
            case 2:
                sResult = "Tuesday";
                break;
            case 3:
                sResult = "Wednesday";
                break;
            case 4:
                sResult = "Thursday";
                break;
            case 5:
                sResult = "Friday";
                break;
            case 6:
                sResult = "Saturday";
                break;
            default:
                sResult = "Invalid day";
                break;
        }
        System.out.println(sResult);
    }

    private static void printDayOfTheWeek2(int day) {
        String sResult;
        if (day == 0) {
            sResult = "Sunday";
        } else if (day == 1) {
            sResult = "Monday";
        } else if (day == 2) {
            sResult = "Tuesday";
        } else if (day == 3) {
            sResult = "Wednesday";
        } else if (day == 4) {
            sResult = "Thursday";
        } else if (day == 5) {
            sResult = "Friday";
        } else if (day == 6) {
            sResult = "Saturday";
        } else {
            sResult = "Invalid day";
        }
        System.out.println(sResult);
    }

}
