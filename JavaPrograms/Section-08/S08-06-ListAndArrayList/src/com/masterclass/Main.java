package com.masterclass;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList myList = new GroceryList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice;
        printInstructions();
        while (!quit) {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    System.out.println("Later dude!");
                    quit = true;
                    break;
                case 0:
                default:
                    printInstructions();
                    break;
            }

        }
    }
    private static void printInstructions() {
        System.out.println("\tPress :");
        System.out.println("\t0. Print instructions");
        System.out.println("\t1. Print grocery list");
        System.out.println("\t2. Add item to grocery list");
        System.out.println("\t3. Modify item on grocery list");
        System.out.println("\t4. Remove item from grocery list");
        System.out.println("\t5. Search item on grocery list");
        System.out.println("\t6. Quit");
    }
    private static void printGroceryList() {
        Result result = myList.getStringGroceryList();
        System.out.println(result.getMessage());
    }
    private static void addItem() {
        System.out.print("Enter item to add: ");
        String newItem = scanner.nextLine();
        if (!newItem.equals("")) {
            Result result = myList.addGroceryItem(newItem);
            System.out.println((result.isSuccess() ? "Success. " : "Error! ")
                + result.getMessage());
        }
    }
    private static void modifyItem() {
        System.out.print("Enter item to change (text): ");
        String currentItem = scanner.nextLine(), newItem = "";
        if (!currentItem.equals("")) {
            System.out.print("Enter new item : ");
            newItem = scanner.nextLine();
        }
        if (!newItem.equals("")) {
            Result result = myList.modifyGroceryItem(currentItem, newItem );
            System.out.println((result.isSuccess() ? "Success. " : "Error! ")
                + result.getMessage());
        }
    }
    private static void removeItem() {
        System.out.print("Enter item to remove (text): ");
        String item = scanner.nextLine();
        if (!item.equals(" ")) {
            Result result = myList.removeGroceryItem(item);
            System.out.println((result.isSuccess() ? "Success. " : "Error! ")
                + result.getMessage());
        }
    }
    private static void searchForItem() {
        System.out.print("Enter item to search : ");
        String searchItem = scanner.nextLine();
        if (!searchItem.equals("")) {
            Result result = myList.onList(searchItem);
            System.out.println((result.isSuccess() ? "Success. " : "Error! ")
                + result.getMessage());
        }
    }
}
