package com.masterclass;

/*
 Challenge
 Create a program using arrays that sorts a list of integers in descending order.
 Descending order is highest value to lowest.
 In other words if the array had the values in it 106, 26, 81, 5, 15 your program should
 ultimately have an array with 106,81,26, 15, 5 in it.
 Set up the program so that the numbers to sort are read in from the keyboard.
 Implement the following methods - getIntegers, printArray, and sortIntegers
 getIntegers returns an array of entered integers from keyboard
 printArray prints out the contents of the array
 and sortIntegers should sort the array and return a new array containing the sorted numbers
 you will have to figure out how to copy the array elements from the passed array into a new
 array and sort them and return the new sorted array.
*/

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] myIntArray = getIntegers(5), sortedArray ;
        sortedArray = sortIntegers(myIntArray, false);
        printArray(myIntArray);
        printArray(sortedArray);
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
    public static int[] sortIntegers(int[] array2Sort) {
        return sortIntegers(array2Sort, true); // Default ascending
    }
    public static int[] sortIntegers(int[] array2Sort, boolean ascending) {
        boolean done = false;
        // don't touch original array, if that is no problem, just use array2Sort
        int[] array = Arrays.copyOf(array2Sort, array2Sort.length);
        /* or int[] array  = array2Sort.clone();
           or int[] array = Arrays.copyOf(array2Sort, array2Sort.length); */
        while (!done) {
            done = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] != array[i + 1] && ascending == (array[i] > array[i + 1])) {
                    // Switch
                    int temp     = array[i];
                    array[i]     = array[i + 1];
                    array[i + 1] = temp;
                    done         = false;
                }
            }
        }
        return array;
    }
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            o("" + array[i]);
        }
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
