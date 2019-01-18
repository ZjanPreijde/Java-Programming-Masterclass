package com.masterclass;

public class Main {

    public static void main(String[] args) {
        String myString = "res";
        myString = myString + "ult";
        myString += ".";
        System.out.println(myString); // result.

        int result = 10;
        result %= 4;
        System.out.println(result);
        System.out.println(result == result);
        System.out.println("greater than 1: " + (result >= 1));
        System.out.println("not greater than 3: " + !(result >= 3));
        // Java apparently does not know  '<>'  as  'not equal to'
        int one = 1, two = 2;
        result = one + two;
        System.out.println(result);
        int three = 3;
        float pi = 3.1415f;
        double result2 = (three * pi);
        System.out.println(result2);

        double myDouble = 0D;
        System.out.println(myDouble);
        myDouble = (double) (20d/3d);
        System.out.println(myDouble);

        boolean isAlien = true;
        if (isAlien == true)
            System.out.println("Is an Alien");
        if (isAlien != false)
            System.out.println("Is an Alien");
        if (isAlien)
            System.out.println("Is an Alien");
        isAlien = !isAlien;
        if (!isAlien)
            System.out.println("Is not an Alien");

        int newValue1 = 50, newValue2 = 100;
        if (newValue1 == 50)
            System.out.println("newValue1 = 50");
        if (newValue2 != 50)
            System.out.println("newValue2 != 50");

        // Challenge
        // 1. Create a double variable with value 20
        // 2. Create a double variable with value 80
        // 3. Add both numbers and multiply result with 25
        // 4. Use the remainder operator to figure out the remainder from the sum (he means result) of #3 divided by 40
        // 5. Write an "if" statement that displays a message "Total over the limit"
        //      if the remainder is equal to 20 or less.
        double myDouble1 = 20d, myDouble2 = 80d;
        double mySum = (myDouble1 + myDouble2);
        System.out.println("Sum of #3 is " + mySum);
        double myResult = mySum * 25;
        System.out.println("Result of #3 is " + myResult);
        double myRemainder = myResult % 40;
        System.out.println("Remainder of (Result of #3)%40 is " + myRemainder);
        if (myRemainder <= 20)
            System.out.println("Total was over the limit");

    }
}
