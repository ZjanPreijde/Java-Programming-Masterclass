package com.masterclass;

/*
 Create a program that implements a simple mobile phone with the following
 capabilities :  Able to store, modify, remove and query contact names.
 You will want to create a separate class for Contacts (name and phone number).
 Create a master class (MobilePhone) that holds the ArrayList of Contacts
 The MobilePhone class has the functionality listed above.
 Add a menu of options that are available.
 Options:  Quit, print list of contacts, add new contact, update existing contact,
 remove contact
 and search/find contact.
 When adding or updating be sure to check if the contact already exists (use name)
 Be sure not to expose the inner workings of the Arraylist to MobilePhone
 e.g. no ints, no .get(i) etc
 MobilePhone should do everything with Contact objects only.
*/

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone myPhone = new MobilePhone();

    public static void main(String[] args) {

        int choice;
        boolean exit = false;
        printMenu();
        while (!exit) {
            System.out.print("Enter choice : ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    modifyContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    findContact();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Have a Nice Day!");
                    break;
                default:
                    printMenu();
                    break;

            }
        }
    }
    private static void printMenu() {
        System.out.println("\t1. Show contacts");
        System.out.println("\t2. Add contact");
        System.out.println("\t3. Modify contact");
        System.out.println("\t4. Remove contact");
        System.out.println("\t4. Find contact");
        System.out.println("\t6. Exit contact list ");
    }
    private static void printContacts() {
        printResult(myPhone.getStringContactList(), false);
    }
    private static void addContact() {
        Result result;
        Contact newContact = new Contact();
        System.out.print("Enter name of new contact : ");
        newContact.name = scanner.nextLine();
        if (newContact.name.equals("")) {
            result = new Result(false, "No name entered");
        } else {
            System.out.print("Enter number : ");
            newContact.number = scanner.nextLine();
            result = myPhone.addContact(newContact);
//            result = new Result(true, "Contact added");
        }
        printResult(result, true);
    }
    private static void modifyContact() {
        Result result = new Result();
        Contact currentContact = new Contact(), newContact = new Contact();
        System.out.print("Enter name of contact to modify : ");
        currentContact.name = scanner.nextLine();
        if (currentContact.name.equals("")) {
            result.setResult(false, "No name to modify entered");
        }
        if (result.isSuccess()) {
            currentContact = myPhone.findContact(currentContact.name);
            if (currentContact.name.equals("")) {
                result.setResult(false, "Name not found");
            }
        }
        if (result.isSuccess()) {
            System.out.print("Enter modified name : ");
            newContact.name = scanner.nextLine();
            if (newContact.name.equals("")) {
                result.setResult(false, "No new name entered");
            }
        }
        if (result.isSuccess()) {
            System.out.print("Enter modified number : ");
            newContact.number = scanner.nextLine();
        }
        if (result.isSuccess()) {
            result = myPhone.modifyContact(currentContact, newContact);
        }
        printResult(result, true);
    }
    private static void removeContact() {
        Result result = new Result();
        Contact currentContact = new Contact();
        System.out.print("Enter name of contact to remove : ");
        currentContact.name = scanner.nextLine();
        if (currentContact.name.equals("")) {
            result.setResult(false, "No name to remove entered");
        }
        if (result.isSuccess()) {
            currentContact = myPhone.findContact(currentContact.name);
            if (currentContact.name.equals("")) {
                result.setResult(false, "Name not found");
            }
        }
        if (result.isSuccess()) {
            result = myPhone.removeContact(currentContact);
        }
        printResult(result, true);
    }
    private static void findContact() {
        Result result = new Result();
        Contact currentContact = new Contact();
        System.out.print("Enter name of contact to find : ");
        currentContact.name = scanner.nextLine();
        if (currentContact.name.equals("")) {
            result.setResult(false, "No name to find entered");
        }
        if (result.isSuccess()) {
            currentContact = myPhone.findContact(currentContact.name);
            if (currentContact.name.equals("")) {
                result.setResult(false, "Name not found");
            } else {
                result.setResult(true, currentContact.name + " found : # " + currentContact.number);
            }
        }
        printResult(result, true);
    }
    private static void printResult(Result result, boolean printSuccess ) {
        System.out.print(
            (printSuccess ? (result.isSuccess() ? "Success. " : "Error! ") : "")
        );
        System.out.println(result.getMessage());
    }
}
