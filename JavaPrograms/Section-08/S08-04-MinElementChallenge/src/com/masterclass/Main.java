package com.masterclass;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        challenge();
    }

    private static void challenge() {
        o("* Enter count : ", false);
        int count = scanner.nextInt();
        scanner.nextLine();
        o("", false, true);
        if (count <= 0 || count > 10) {
            oln("Valid count 1 - 10.");

        } else {
            int[] numbersRead = readIntegers(count);
            int minNumber = findMin(numbersRead);
            oln("The numbers entered are " + Arrays.toString(numbersRead));
            oln("The minimum number is " + minNumber);
        }
    }
    public static int[] readIntegers(int count) {
        int[] values = new int[count];
        oln("Enter " + values.length + " integer values :");
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
    public static int findMin( int[] array ) {
        int minValue = array[0];
        for (int i = 1; i < array.length; i++) {
            minValue = (minValue > array[i] ? array[i] : minValue);
        }
        return minValue;
    }

    // Helpers
    public static void printArray(int[] array) {
        oln(Arrays.toString(array));
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
