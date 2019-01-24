package com.masterclass;

import java.util.Scanner;

public class Main {

    private static void printHeader(String header) {
        System.out.println(" =========");
        System.out.println(" " + header);
    }

    public static void main(String[] args) {
        // First input
//        readFirstInput();
        // Reading Input Challenge, read 10 numbers from console and sum them
        sum10Numbers();
        // Min and Max Challenge, receive numbers until no valid input, show max and min value
        calcMinMaxValues();

    }


    private static void readFirstInput() {
        printHeader("First Input Reading :");
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Enter your name : ");
        String name = scanner.nextLine();

        System.out.println(" Enter your year of birth : ");
        boolean hasNextInt = scanner.hasNextInt();
        if (hasNextInt) {
            int yearOfBirth = scanner.nextInt();
            scanner.nextLine(); // handle next line character <Enter>

            int age = 2019 - yearOfBirth;
            if (age >= 0 && age <= 100) {
                System.out.println("Your name is " + name + ", and you are " + age + " years old");
            } else {
                System.out.println("Invalid year of birth.");
            }
        } else {
            String yearOfBirth = scanner.nextLine();
            System.out.println("Unable to parse year of birth. (" + yearOfBirth + " )");
        }

        scanner.close();

    }

    private static void sum10Numbers() {
        printHeader("Sum 10 Numbers :");
        Scanner scanner = new Scanner(System.in);
        // .hasNext(), .hasNextInt(), .nextLine(), nextInt()

        int numbersEntered = 0, sum = 0;
        System.out.println("Enter 5 numbers and I will sum them for you");
        while (numbersEntered < 5) {
            System.out.println((numbersEntered + 1) + ". ");
            boolean hasNextInt = scanner.hasNextInt();
            if ( hasNextInt ) {
                int number = scanner.nextInt();
                numbersEntered++;
                sum += number;
            } else {
                System.out.println("Invalid number");
            }
            if ( scanner.hasNext() ) {
                System.out.println("( Clear buffer )");
                scanner.nextLine();
            }
        }

        scanner.close();

        System.out.println("The sum of the number you entered is " + sum);
    }

    private static void calcMinMaxValues() {
        printHeader("Calculate Min and Max Values :");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            System.out.println("Buffer not empty on new Scanner object!");
            scanner.nextLine();
        }
        // .hasNext(), .hasNextInt(), .nextLine(), nextInt()

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, numbersEntered = 0, number;
        boolean receivedNumber = true, hasNextInt;

        System.out.println("Enter numbers and I will calculate the min and max values");
        while (receivedNumber) {
            System.out.println("Enter number :");
            hasNextInt = scanner.hasNextInt();
            if (hasNextInt) {
                number = scanner.nextInt();
                max    = (number > max) ? number : max;
                min    = (number < min) ? number : min;
                numbersEntered++;
            } else {
                receivedNumber = false;
            }
            if (scanner.hasNext()) {
                System.out.println("( Clear buffer )");
                scanner.nextLine();
            }
        }

        scanner.close();

        if (numbersEntered > 0) {
            System.out.println("The min and max values are " + min + " and " + max);
        } else {
            System.out.println("You have not entered any numbers");
        }
    }

}