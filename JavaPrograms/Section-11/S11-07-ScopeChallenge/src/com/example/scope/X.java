package com.example.scope;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-16, 12:50
*/

import java.util.Scanner;

public class X {
    private int x;

    public X(Scanner x) {
        System.out.println("Gimme a number : ");
        this.x = x.nextInt();
    }

    public void x() {
        for (int x = 1; x <= 12; x++) {
            System.out.println(x + " * " + this.x + " = " + this.x * x);
        }
    }
}
