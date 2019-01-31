package com.masterclass;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//        test01();
//        test02();
        test03();
    }

    private static void test03() {
        // Just run the Demo.java, right click on Demo.java, choose Run 'Demo.main()'
        oln("Just run the Demo.java, right click on Demo.java, choose Run 'Demo.main()'", "");
    }
    private static void test02() {
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(1); integerList.add(3); integerList.add(4);
        printALInteger(integerList);
        integerList.add(1, 2);
        oln("---");
        printALInteger(integerList);
        oln("---");
    }
    private static void test01() {
        // Demonstrating references
        Customer frank = new Customer("Frank", 54.69), simon = frank;
        oln(frank.getName() + "'s balance = " + frank.getBalance());
        simon.setName("Simon");
        simon.setBalance(1000);
        oln(frank.getName() + "'s balance = " + frank.getBalance()); // Simon, 1000
        oln(simon.getName() + "'s balance = " + simon.getBalance()); // Simon, 1000
    }




    // Helpers

    // Print ArrayList<Integer>
    private static void printALInteger(ArrayList<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            oln(i + " : " + array.get(i), ">");
        }
    }
    // Print ArrayList<String>
    private static void printALString(ArrayList<String> array) {
        for (int i = 0; i < array.size(); i++) {
            oln(i + " : " + array.get(i), ">");
        }
    }

    // System.out.print**() short hand
    private void o(String text) {
        o(text, true);
    }
    private static void o(String text, boolean prefix) {
        o(text, (prefix ? "- " : ""), "");
    }
    private static void o(String text, String prefix) {
        o(text, prefix, "");
    }
    private static void o(String text, boolean prefix, String suffix) {
        o(text, (prefix ? "- " : ""), suffix);
    }
    private static void o(String text, String prefix, String suffix) {
        System.out.print(prefix + text + suffix);
    }

    private static void oln(String text) {
        oln(text, true);
    }
    private static void oln(String text, boolean prefix) {
        oln(text, (prefix ? "= " : ""), "");
    }
    private static void oln(String text, String prefix) {
        oln(text, prefix, "");
    }
    private static void oln(String text, String prefix, String suffix) {
        System.out.println(prefix + text + suffix);
    }
}
