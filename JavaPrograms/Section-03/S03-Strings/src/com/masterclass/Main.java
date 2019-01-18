package com.masterclass;

public class Main {

    public static void main(String[] args) {
        String myString1 = "This is a string";
        System.out.println("myString1 : " + myString1);
        myString1 += ", ain't that great? \u20AC";
        System.out.println("myString1 : " + myString1);

        // You can concatenate a string with a number
        int myInt = 50;
        String myString2 = "myString2 : The price is \u20AC " + myInt;
        System.out.println("myString2 : " + myString2);

        boolean myBoolean = false;
        String myString3 = "My dog is " + myBoolean;
        System.out.println("myString3 : " + myString3);

        String numberString = "1234";
        numberString += "5678";
        System.out.println("numberString : " + numberString);
    }
}
