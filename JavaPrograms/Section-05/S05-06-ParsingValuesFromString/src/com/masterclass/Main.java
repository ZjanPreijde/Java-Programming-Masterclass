package com.masterclass;

public class Main {

    public static void main(String[] args) {
        doExample1();
    }
    private static void doExample1() {
        String numberAsString;

        numberAsString = "2018";
        int myInt = Integer.parseInt(numberAsString);
        int myInt2 = Integer.parseInt(numberAsString) + 1;
        System.out.println("numberAsString = " + numberAsString);
        System.out.println("myInt = " + myInt);
        System.out.println("myInt2 = " + myInt2);

        numberAsString   = "2018.125";
        double myDouble  = Double.parseDouble(numberAsString);
        double myDouble2 = Double.parseDouble(numberAsString) + 0.998;
        System.out.println("numberAsString = " + numberAsString);
        System.out.println("myDouble = " + myDouble);
        System.out.println("myDouble2 = " + myDouble2);
    }
}
