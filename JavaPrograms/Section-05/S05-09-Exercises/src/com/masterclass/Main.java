package com.masterclass;

import java.util.Scanner;

public class Main {

    Scanner scanner = new Scanner(System.in);

    private static void printHeader(String header) {
        System.out.println("----------");
        System.out.println(header);
    }

    public static void main(String[] args) {
        printHeader("== Exercises ==");
        doExercises();
    }

    private static void doExercises() {
        System.out.println("- InputCalculator -");
        InputCalculator.inputThenPrintSumAndAverage();

        System.out.println("- PaintJob -");
        int count;
        count = PaintJob.getBucketCount(2.75, 3.25, 2.5, 1);
        System.out.println("2.75, 3.25, 2.5, 1 : 3 -> " + count);
        count = PaintJob.getBucketCount(7.25, 4.3, 2.35);
        System.out.println("7.25, 4.3, 2.35 : 14 -> " + count);
        count = PaintJob.getBucketCount(3.26, 0.75);
        System.out.println("3.26, 0.75 : 5 -> " + count);
    }

}
