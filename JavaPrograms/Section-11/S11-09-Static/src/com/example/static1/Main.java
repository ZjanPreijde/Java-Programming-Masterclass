package com.example.static1;

public class Main {

    public static int multiplier = 7;

    public static void main(String[] args) {
	// write your code here
        System.out.println( StaticTest.getNumInstances() + " instances created");

        StaticTest firstInstance = new StaticTest("1st Instance");
        System.out.println(firstInstance.getName() + " is instance number " + firstInstance.getNumInstances());
        StaticTest secondInstance = new StaticTest("2nd Instance");
        System.out.println(secondInstance.getName() + " is instance number " + secondInstance.getNumInstances());
        StaticTest thirdInstance = new StaticTest("3rd Instance");
        System.out.println(thirdInstance.getName() + " is instance number " + thirdInstance.getNumInstances());

        System.out.println( StaticTest.getNumInstances() + " instances created");

        System.out.println(firstInstance.toString());
        System.out.println(secondInstance.toString2());

        System.out.println("\n---------------");
        int answer = multiply(6);
        System.out.println(" 6 times " + multiplier + " = " + answer);

    }
    public static int multiply(int number) {
        return number * multiplier;
    }
}
