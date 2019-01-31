package com.masterclass;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        destinations1();
        destinations2();
        destinations3();
    }

    private static void destinations3() {
        // Demonstrate .isEmpty(), .hasNext(), .next(), .hasPrevious(), .previous()
        oln("Demonstrate\n\t.isEmpty(),\n\t.hasNext(), .next(),\n\t.hasPrevious(), .previous()", "");
        LinkedList<String> destinations = new LinkedList<>();
        destinations.add("Sydney");
        destinations.add("Melbourne");
        destinations.add("Brisbane");
        destinations.add("Perth");
        destinations.add("Canberra");
        destinations.add("Adelaide");
        destinations.add("Darwin");
        destinations.add("Alice Springs");
        Scanner scanner = new Scanner(System.in);
        boolean quit = false, goingForward = true;
        ListIterator<String> listIterator = destinations.listIterator();
        if (destinations.isEmpty()) {
            oln("No cities in the itenerary", ">");
            return;
        } else {
            oln("Now visiting " + listIterator.next(), "");
            printMenu();
        }
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action) {
                case 0:
                    oln("Holiday over");
                    quit = true;
                    break;
                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        oln("Now visiting " + listIterator.next());
                    } else {
                        oln("Reached the end of the list");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        oln("Now visiting " + listIterator.previous());
                    } else {
                        oln("Reached the beginning of the list");
                        goingForward = true;
                    }
                    break;
                default:
                    printMenu();
                    break;

            }
        }

    }
    private static void printMenu() {
        oln("Available actions:\n"
                + "press :\n"
                + "0 - to quit\n"
                + "1 - go to next destinations\n"
                + "2 - go to previous destination\n"
                + "3 - print menu options"
        );
    }
    private static void destinations2() {
        // Demonstrate adding randomly, but being inserted in alphabetical order
        oln("Demonstrate adding randomly,\n\tbut being inserted in alphabetical order"
                + "\n\t.next().compareTo()", "");
        LinkedList<String> destinations = new LinkedList<>();
        addInOrderLLString(destinations, "Sydney", false);
        addInOrderLLString(destinations, "Melbourne", false);
        addInOrderLLString(destinations, "Brisbane", false);
        addInOrderLLString(destinations, "Perth", false);
        addInOrderLLString(destinations, "Canberra", false);
        addInOrderLLString(destinations, "Adelaide", false);
        addInOrderLLString(destinations, "Darwin", false);
        addInOrderLLString(destinations, "Alice Springs", false);
        oln("Added randomly ", "Destinations : ");
        oln("Inserted alphabetically ", "Destinations : ");
        printLLString(destinations, "Destination : ");
    }
    private static void destinations1() {
        // Demonstrate insertion in LinkedList<>, .add(<index>, <value>)
        oln("Demonstrate insertion in LinkedList<>,\n\t.add(<index>, <value>)", "");
        LinkedList<String> destinations = new LinkedList<>();
        destinations.add("Sydney");
        destinations.add("Melbourne");
        destinations.add("Brisbane");
        destinations.add("Perth");
        destinations.add("Canberra");
        destinations.add("Adelaide");
        destinations.add("Darwin");
        oln("Initialized", "Destinations : ");
        printLLString(destinations, "Destination : ");
        // insert Alice Springs at Melbournes position
        destinations.add(1, "Alice Springs");
        oln("Alice Springs added at 1", "Destinations : ");
        printLLString(destinations, "Destination : ");
        // remove Perth
        destinations.remove(4);
        oln("Perth removed", "Destinations : ");
        printLLString(destinations, "Destination : ");
    }


    // Insert String in LinkedList<String> in alphabetical order.
    private static boolean addInOrderLLString(
                LinkedList<String> linkedList, String newString, boolean allowDoubles ) {
        // Add string in alphabetical order in LinkedList<String>
        ListIterator<String> listIterator = linkedList.listIterator();
        while ( listIterator.hasNext() ) {
            int comparison = listIterator.next().compareTo(newString);
            if ( comparison == 0) {
                // Already exists
                if ( !allowDoubles ) {
                    // Not doubles allowed
                    oln(newString + " is already in our list", ">>");
                    return false;
                }
                // Double, add here
                listIterator.add(newString);
                return true;
            } else if ( comparison > 0 ){
                // Should be inserted before this one,
                //  hasNext already has us on this element,
                //  so we have to go back one before adding it.
                listIterator.previous();
                listIterator.add(newString);
                return true;
            }
        }
        // Not inserted yet, insert at end
        listIterator.add(newString);
        return true;
    }

    // - Helpers -

    // Print LinkedList<String>
    private static void printLLString(
                LinkedList<String> linkedList, String prefix ) {
        Iterator<String> iterator = linkedList.iterator();
        oln("------------", "");
        while (iterator.hasNext()) {
            oln(prefix + iterator.next(), ">");
        }
        oln("============", "");
    }
    // Print ArrayList<String>
    private static void printALString( ArrayList<String> array ) {
        oln("------------", "");
        for (int i = 0; i < array.size(); i++) {
            oln(i + " : " + array.get(i), ">");
        }
        oln("============", "");
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
