package com.masterclass;

public class Main {

    public static void main(String[] args) {
        simpleCalculator();
    }
    public static void simpleCalculator() {
        SimpleCalculator sc = new SimpleCalculator();
        sc.setFirstNumber( 5.0 );
        sc.setSecondNumber( 4 );
        System.out.println(sc.getFirstNumber() + " , " + sc.getSecondNumber());
        System.out.println("add= " + sc.getAdditionResult());
        System.out.println("subtract= " + sc.getSubtractionResult());
        System.out.println("multiply= " + sc.getMultiplicationResult());
        System.out.println("divide= " + sc.getDivisionResult());
    }
}
