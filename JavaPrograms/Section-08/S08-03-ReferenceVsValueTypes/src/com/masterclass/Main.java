package com.masterclass;

import java.util.Arrays;

public class Main {
    private static int[] myInts = new int[10];

    public static void main(String[] args) {
        tries();
        tries2();
    }

    private static void tries2() {
        System.out.println("Resizing an int[] array");
        System.out.println(Arrays.toString(myInts));
        myInts = resizeArray(myInts, 20);
        System.out.println(Arrays.toString(myInts));
        System.out.println("All to demonstrate the ease of the List/ArrayList");
    }
    public static int[] resizeArray(int[] array, int newLength) {
        int[] orgInts = array;
        array = new int[newLength];
        for (int i = 0; i < orgInts.length; i++) { array[i] = orgInts[i]; }
        return array;
    }


    private static void tries() {
        int myIntValue = 10;
        int myOtherInt = myIntValue;
        oln("" + myIntValue + ", " + myOtherInt ); // = 10, 10
        myIntValue = 12;
        oln("" + myIntValue + ", " + myOtherInt ); // = 12, 10
        oln("---------", false);

        // Though strings are objects, the behave like primitive data types
        String myStrValue = "aaaaa";
        String myOtherStr = myStrValue;
        oln("" + myStrValue + ", " + myOtherStr ); // = aaaaa, aaaaa
        myStrValue = "bbbbb";
        oln("" + myStrValue + ", " + myOtherStr ); // = bbbbb, aaaaa
        oln("---------", false);

        // myIntArray reference to place in memory
        int[] myIntArray1 = new int[5];
        // Reference is copied
        int[] myIntArray2 = myIntArray1;
        myIntArray1[3] = 5; // both array are altered
        printArray(myIntArray1); // [0, 0, 0, 5, 0]
        printArray(myIntArray2); // [0, 0, 0, 5, 0]
        oln("---------", false);

        // create new reference using
        //  array.clone, Array.copyOf(array), System.arrayCopy(array)
        int[] myIntArray3 = myIntArray1.clone();
        myIntArray2[2] = 3;
        myIntArray3[3] = 8;
        printArray(myIntArray1); // [0, 0, 3, 5, 0]
        printArray(myIntArray2); // [0, 0, 3, 5, 0]
        printArray(myIntArray3); // [0, 0, 0, 8, 0]
        oln("---------", false);

        int[] myInts = new int[10];
    }
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
