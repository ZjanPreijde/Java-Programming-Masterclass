package com.masterclass;

public class Main {

    public static void main(String[] args) {
        // Create a class and demonstate proper encapsulation techniques
        // the class will be called Printer
        // It will simulate a real Computer Printer
        // It should have fields for the toner Level, number of pages printed, and
        // also whether its a duplex printer (capable of printing on both sides of the paper).
        // Add methods to fill up the toner (up to a maximum of 100%), another method to
        // simulate printing a page (which should increase the number of pages printed).
        // Decide on the scope, whether to use constructors, and anything else you think is needed.
        Printer printer;

        printer = new Printer(10, 89, false);
        System.out.println(" ---- ");
        System.out.println("Printer 1: " + printer.getPrinterData());
        System.out.print(  "- Fill    0 -> "); printer.fillToner(0);
        System.out.print(  "- Fill  100 -> "); printer.fillToner(100);
        System.out.print(  "- Print   1 -> "); printer.printPages(1);
        System.out.print(  "- Fill   90 -> "); printer.fillToner(90);

        printer = new Printer(10, 0, true);
        System.out.println(" ---- ");
        System.out.println("Printer 2: " + printer.getPrinterData());
        System.out.print  ("- Fill   1   -> "); printer.fillToner(1);
        System.out.print  ("- Print  5   -> "); printer.printPages(5);
        System.out.print  ("- Fill   6   -> "); printer.fillToner(6);
        System.out.print  ("- Print -5   -> "); printer.printPages(-5);
        System.out.print  ("- Print  5   -> "); printer.printPages(5);

        System.out.println(" ---- ");

    }
}
