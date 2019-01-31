package com.masterclass;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        test01();
//        test02();
//        test03();
        test04();
    }
    private static void test04() {
        char a = 'a'; char b = 'b';
//        String ab = a + b; //-> Error
        String test = "" + a + b;
    }
    private static void test03() {
        // With autoboxing and unboxing
        System.out.println("--------------");
        System.out.println("Test 03 - Autoboxing/Unboxing");
        System.out.println("--------------");
        Integer myInteger = 54;
        int myPrimitiveInt = myInteger;
        Double  myDouble = 3.14;
        double myPrimitiveDouble = myDouble;
        System.out.println("myInteger : " + myInteger);
        System.out.println("myPrimitiveInt : " + myPrimitiveInt);
        System.out.println("myDouble  : " + myDouble);
        System.out.println("myPrimitiveDouble  : " + myPrimitiveDouble);
        ArrayList<Integer> intAList = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            // convert int to Integer before adding it, auto boxing
            intAList.add( i );
        }
        for (int i = 0; i < intAList.size(); i++) {
            // convert Integer to int when retrieving, unboxing
            System.out.println(i + " => " + intAList.get(i));
        }
    }

    private static void test02() {
        System.out.println("--------------");
        System.out.println("Test 02 - no Autoboxing/Unboxing");
        System.out.println("--------------");
        // No autoboxing or unboxing
        Integer myInteger        = Integer.valueOf(54);
        int myPrimitiveInt       = myInteger.intValue();
        Double  myDouble         = Double.valueOf(3.14);
        double myPrimitiveDouble = myDouble.doubleValue();
        System.out.println("myInteger : " + myInteger);
        System.out.println("myPrimitiveInt : " + myPrimitiveInt);
        System.out.println("myDouble  : " + myDouble);
        System.out.println("myPrimitiveDouble  : " + myPrimitiveDouble);
        ArrayList<Integer> intAList = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            // convert int to Integer before adding it, auto boxing
            intAList.add( Integer.valueOf(i) );
        }
        for (int i = 0; i < intAList.size(); i++) {
            // convert Integer to int when retrieving, unboxing
            System.out.println(i + " => " + intAList.get(i).intValue());
        }
    }



    private static void test01() {
        System.out.println("--------------");
        System.out.println("Test 01");
        System.out.println("--------------");
        ArrayList<Integer> intArrayList = new ArrayList<Integer>();
        for (int i = 0; i <= 10; i++) {
            intArrayList.add(Integer.valueOf(i));
        }
        for (int i = 0; i <= 10; i++) {
            System.out.println(i + " --> " + intArrayList.get(i).intValue());
        }
    }
}
