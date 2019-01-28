package com.masterclass;

public class Printer {
    // It should have fields for the toner Level, number of pages printed, and
    // also whether its a duplex printer (capable of printing on both sides of the paper).
    private int tonerLevel, pagesPrinted, maxLevel = 100;
    private boolean isDuplex;

    public Printer() {
        this(50, 0, false);
    }
    public Printer(int tonerLevel, int pagesPrinted, boolean isDuplex) {
        this.tonerLevel   = (tonerLevel < 0 || tonerLevel > 100) ? maxLevel : tonerLevel;
        this.pagesPrinted = (pagesPrinted < 0) ? 0 : pagesPrinted;
        this.isDuplex     = isDuplex;
    }
    // Add methods to fill up the toner (up to a maximum of 100%), another method to
    // simulate printing a page (which should increase the number of pages printed).
    // Decide on the scope, whether to use constructors, and anything else you think is needed.
    public void fillToner(int amount) {
        if (amount <= 0) {
            System.out.println("Fill toner, " + amount + "  is invalid");
        } else if (tonerLevel + amount > maxLevel) {
            System.out.println("Fill toner, " + amount + "  is invalid");
        } else {
            System.out.println("Fill toner, " + amount + " added");
            setTonerLevel( tonerLevel + amount );
        }
        printPrinterData();
    }

    private void setTonerLevel(int tonerLevel) {
        this.tonerLevel = tonerLevel;
    }

    private int getTonerLevel() {
        return this.tonerLevel;
    }

    private void setPagesPrinted(int pagesPrinted) {
        this.pagesPrinted = pagesPrinted;
    }

    public void printPages(int pages) {
        if (pages <= 0 || pages > 100) {
            System.out.println("Printing, " + pages + " is invalid");
            return;
        }
        System.out.println("Printing " + pages + " pages ...");
        int printed = 0;
        while (printed < pages) {
            if (getTonerLevel() <= (this.isDuplex ? 1 : 0) ) {
                System.out.println("> Printer is out of toner");
                break;
            }
            printPage();
            printed++;
        }
        System.out.println("> Printed " + printed + " pages");
        printPrinterData();
    }
    private void printPage() {
        System.out.print("> Printing a page " + (isDuplex ? "(duplex) " : "") + "...");
        setTonerLevel( tonerLevel - (this.isDuplex ? 2 : 1) );
        setPagesPrinted(pagesPrinted + 1);
        System.out.println(" Printed");
    }
    public String getPrinterData() {
        return "Toner level " + tonerLevel + ", pages printed " + pagesPrinted + ", duplex " + isDuplex;
    }
    private void printPrinterData() {
        System.out.println("> Printer : " + getPrinterData());
    }
}
