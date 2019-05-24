package com.masterclass;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> items = new ArrayList<>();
        items.add(1);
        items.add(2);
        items.add(3);
        items.add(4);
        items.add(5);

        printDoubled(items);

    }
    private static void printDoubled(ArrayList<Integer> printList) {
        for (Integer i : printList) {
            System.out.println("Number * 2 : " + ( i * 2));
        }
    }
}
