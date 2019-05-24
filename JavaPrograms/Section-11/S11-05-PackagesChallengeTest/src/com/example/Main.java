package com.example;

import org.zp.ZPMath.Series;

class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("nSum()");
        for (int i = 0; i < 11; i++) {
            System.out.println(i + ": " + Series.nSum( i ));
        }
        System.out.println("factorial()");
        for (int i = 0; i < 11; i++) {
            System.out.println(i + ": " + Series.factorial( i ));
        }
        System.out.println("fibonacci()");
        for (int i = 0; i < 11; i++) {
            System.out.println(i + ": " + Series.fibonacci( i ));
        }

    }
}