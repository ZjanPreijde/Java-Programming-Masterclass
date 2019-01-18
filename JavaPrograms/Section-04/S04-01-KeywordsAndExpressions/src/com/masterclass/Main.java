package com.masterclass;

public class Main {

    public static void main(String[] args) {
        // a mile = 1.609344 km
        // a lb = 0.45359237kg
        double mileKmFactor = 1.609344;
        double lbsKgFactor  = 0.45359237;
        int miles = 200, kms = 200;
        int lbs = 200, kgs = 200;
        System.out.println(
                miles + " miles is " + (miles * mileKmFactor) + " kms");
        System.out.println(
                kms + " kms is " + (kms / mileKmFactor) + " miles");
        System.out.println(
                miles + " lbs is " + (miles * lbsKgFactor) + " kgs");
        System.out.println(
                kgs + " kgs is " + (kgs / lbsKgFactor) + " lbs"
        );

        // Challenge, in the following code, identify the expressions
        int score = 100;
        if (score > 99) {
            System.out.println("You got the high score");
            score = 0;
        }
        System.out.println(
                "Expressions are 'score = 100', 'score > 99'"
                        + ", 'You got the high score', score = 0'");
    }
}
