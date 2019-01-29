package com.masterclass;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // tries1();
        int[] myIntArray = getIntegers(5);
        printArray(myIntArray);
        oln("\nSum is " + sumArray(myIntArray), false);
        oln("Average is " + averageArray(myIntArray), false);

    }
    public static int[] getIntegers(int number) {
        oln("Enter " + number + " integer values.\r");
        int[] values = new int[number];
        int i = 0;
        while (i < values.length) {
            o("Enter number " + (i + 1) + " : ");
            if (scanner.hasNextInt()) {
                values[i] = scanner.nextInt();
                i++;
            }
            scanner.nextLine();
            o("", false, false);
        }
        return values;
    }
    public static double averageArray(int[] array) {
        return sumArray(array) / (double) array.length ;
    }
    public static int sumArray(int[] array){
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
    public static void printArray(int[] array)
        { for (int i = 0; i < array.length; i++) { o("" + array[i]); } }
    public static void printArray(String[] array)
        { for (int i = 0; i < array.length; i++) { o("" + array[i]); } }


    private static void tries1() {
        int[] myIntArray = new int[10];
        oln("myIntArray[0] : " + myIntArray[0]);
        double[] myDoubleArray = new double[10];
        oln("myDoubleArray[0] : " + myDoubleArray[0]);
        oln("myDoubleArray.length : " + myDoubleArray.length);
        String[] myStringArray = { "A", "B", "C", "D", "E" };
        oln("myStringArray[2] : " + myStringArray[2]);
        for ( int i = 0; i < myIntArray.length ; i++ )
        { myIntArray[i] = (i + 1) * 50; }
        o("myIntArray    : "); printArray(myIntArray);
        o("", false, true);
        o("myStringArray : "); printArray(myStringArray);
        o("", false, true);
    }

    private static void o(String text) {
        System.out.print("- " + text);
    }
    private static void o(String text, boolean prefix) {
        System.out.print((prefix ? "- " : "") + text);
    }
    private static void o(String text, boolean prefix, boolean newLine) {
        System.out.print((prefix ? "- " : "") + text + (newLine ? "\n" : "" ));
    }
    private static void oln(String text) {
        System.out.println("= " + text);
    }
    private static void oln(String text, boolean prefix) {
        System.out.println((prefix ? "= " : "") + text);
    }

}
