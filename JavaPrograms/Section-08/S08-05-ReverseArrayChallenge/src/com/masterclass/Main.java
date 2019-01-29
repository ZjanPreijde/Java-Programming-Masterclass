package com.masterclass;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] ints = new int[] {1,2,3,4,5,6,7,8};
        System.out.println("" + Arrays.toString(ints));
        reverse(ints);
        System.out.println("" + Arrays.toString(ints));
    }
    private static void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }
}
