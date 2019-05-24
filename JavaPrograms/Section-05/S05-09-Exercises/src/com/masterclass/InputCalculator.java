package com.masterclass;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-08, 14:22
*/

import java.util.Scanner;

public class InputCalculator {

    // Read input
    public static void inputThenPrintSumAndAverage() {
        Scanner scanner = new Scanner(System.in);
        int sum = 0, count = 0;
        long average;
        while (scanner.hasNextInt()) {
            sum += scanner.nextInt();
            count += 1;
            scanner.nextLine();
        }
        average = Math.round( (double) sum / count );
        System.out.println("SUM = " + sum + " AVG = " + average);

    }
}
