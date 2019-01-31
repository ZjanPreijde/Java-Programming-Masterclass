package com.masterclass;

import java.util.ArrayList;
//import java.util.Scanner;

public class Main {
//    private static Scanner scanner = new Scanner(System.in);
    // Suppress  Success == true  result messages?
    private static boolean suppressSuccess = true;

    public static void main(String[] args) {
//        test01();
        test02();
    }

    public static void test02() {
        Bank bank;
        Branch branch;
        Customer customer;
        Transaction transaction;

        // TDD, Test Driven Development

        // -> Error, no bankName :
        bank   = bankAction("addBank", "");
        bank   = bankAction("addBank", "ABN-AMRO");
        // -> Error, no branchName :
        branch = bankAction("addBranch", bank, "");
        branch = bankAction("addBranch", bank, "100th Street");
        branch = bankAction("addBranch", bank, "101st Street");
        branch = bankAction("addBranch", bank, "102nd Street");
        branch = bankAction("addBranch", bank, "103rd Street");
        // -> Error, branch already exists for bank
        branch = bankAction("addBranch", bank, "103rd Street");
        // List branches, no customers
        bankAction("listBranches", bank);

        // String branchName -> bank must be passed
        customer = branchAction("addCustomer"
                , bank, "101st Street", "Shallow Sjaman", 50d);
        // -> Error, customer already exists :
        customer = branchAction("addCustomer"
                , bank, "101st Street", "Shallow Sjaman", 0d);
        branch = bankAction("findBranch"
                , bank, "101st Street");

        // Branch branch -> no bank needed
        customer = branchAction("findCustomer"
                , branch, "Shallow Sjaman");
        customer = branchAction("addCustomer"
                , branch, "Wild Wendy");
        // -> Error, customer already exists
        customer = branchAction("addCustomer"
                , branch, "Wild Wendy", 100d);
        branchAction("listCustomers", branch, "", 0d);

        // List branches, with customers
        bankAction("listBranches", bank);

        customer = branchAction("findCustomer"
                , branch, "Wild Wendy");
        // -> Error, customer not found :
        transaction = customerAction("addTransaction"
                , branch, "Wild Susan", 10d);
        // -> Error, amount 0 :
        transaction = customerAction("addTransaction"
                , branch, "Wild Wendy" , 0d);
        transaction = customerAction("addTransaction"
                , branch, "Wild Wendy" , 50d);
        transaction = customerAction("addTransaction"
                , branch, "Wild Wendy" , 33d);
        transaction = customerAction("addTransaction"
                , branch, "Wild Wendy", 41d);
        transaction = customerAction("addTransaction"
                , branch, "Wild Wendy", -77d);
        customerAction("listTransactions"
                , branch, "Wild Wendy", 0d);

        transaction = customerAction("addTransaction"
                , branch, "Shallow Sjaman", 50d);
        transaction = customerAction("addTransaction"
                , branch, "Shallow Sjaman", 33d);
        transaction = customerAction("addTransaction"
                , branch, "Shallow Sjaman", 41d);
        transaction = customerAction("addTransaction"
                , branch, "Shallow Sjaman", -77d);
        customerAction("listTransactions"
                , branch, "Shallow Sjaman", 0d);
        //
    }


    // Bank bankAction
    private static Bank bankAction(String action, String bankName) {
        Result result = new Result();
        return bankAction(action, bankName, result);
    }

    private static Bank bankAction(String action, String bankName, Result result) {
        result.setSuppress(suppressSuccess);
        Bank bank = null;
        switch (action) {
            case "addBank":
                if (bankName == "") {
                    result.setFail(action + ". No bank name given");
                } else {
                    bank = new Bank(bankName);
                    result.setSucceed("Bank '" + bankName + "' created");
                }
                break;
            default:
                result.setFail("No valid action (" + action + ")");
                break;
        }
        printResult(result);
        return bank;
    }

    // Branche bankAction
    private static Branch bankAction(String action, Bank bank) {
        return bankAction(action, bank, "");
    }
    private static Branch bankAction(String action, Bank bank, Result result) {
        return bankAction(action, bank, "", result);
    }
    private static Branch bankAction(String action, Bank bank, String branchName) {
        Result result = new Result();
        return bankAction(action, bank, branchName, result);
    }
    private static Branch bankAction(String action, Bank bank, String branchName, Result result) {
        result.setSuppress(suppressSuccess);
        Branch branch = null;
        if ( bank == null) {
            result.setFail(action + ". No bank given");
        }
        if ( result.isSuccess() && (branchName == "") && (action != "listBranches") ) {
            result.setFail(action + ". No branch name given");
        }
        if (result.isSuccess()) {
            if (action == "findBranch") {
                branch = bank.getBranch(branchName, result);
                return branch; // return
            }
            switch (action) {
                case "addBranch":
                    branch = bank.addBranch(branchName, result);
                    break;
                case "listBranches":
                    String branches = "Branches of " + bank.getBankName();
                    ArrayList<String> list = bank.listBranches();
                    for (int i = 0; i < list.size(); i++) {
                        branches += "\n\t" + list.get(i);
                    }
                    result.setSucceed(branches);
                    result.setSuppress(false);
                    break;
                default:
                    result.setFail("No valid action (" + action + ")");
                    break;
            }
        }
        printResult(result);
        return branch;
    }

    // Customer branchAction
    // branchName String, with bank
    // Overloading
    private static Customer branchAction(String action, Bank bank, String branchName
            , String customerName, double amount) {
        Result result = new Result();
        return branchAction(action, bank, branchName, customerName, amount, result);
    }
    // Overloaded
    private static Customer branchAction(String action, Bank bank, String branchName
            , String customerName, double amount, Result result) {
        result.setSuppress(suppressSuccess);
        Customer customer = null;
        Branch branch = bankAction("findBranch", bank, branchName, result);
        if (branch == null) {
            return customer;
        }
        return branchAction(action, branch, customerName, amount, result);
    }
    // branch Branch, no bank
    // Overloading
    private static Customer branchAction(String action, Branch branch) {
        Result result = new Result();
        return branchAction(action, branch, "", 0d);
    }
    private static Customer branchAction(String action, Branch branch
            , String customerName) {
        Result result = new Result();
        return branchAction(action, branch, customerName, 0d);
    }
    private static Customer branchAction(String action, Branch branch
            , String customerName, double amount) {
        Result result = new Result();
        return branchAction(action, branch, customerName, amount, result);
    }
    // Overloaded
    private static Customer branchAction(String action, Branch branch
            , String customerName, double amount, Result result) {
        result.setSuppress(suppressSuccess);
        Customer customer = null;
        if ( branch == null) {
            result.setFail(action + ". No branch given");
        }
        if ( result.isSuccess() && (customerName == "") && (action != "listCustomers") ) {
            result.setFail(action + ". No customer name given");
        }
        if (result.isSuccess()) {
            if (action == "findCustomer") {
                customer = branch.getCustomer(customerName, result);
                return customer;
            }
            switch (action) {
                case "addCustomer":
                    customer = branch.addCustomer(customerName, amount, result);
                    break;
                case "listCustomers":
                    String customers = "Customers of " + branch.getFullName();
                    ArrayList<String> list = branch.listCustomers();
                    for (int i = 0; i < list.size(); i++) {
                        customers += "\n\t" + list.get(i);
                    }
                    result.setSucceed(customers);
                    result.setSuppress(false);
                    break;
                default:
                    result.setFail("No valid action (" + action + ")");
                    break;
            }
        }

        printResult(result);
        return customer;
    }

    // Transaction customerAction
    // Overloading
    private static Transaction customerAction(String action, Branch branch
            , String customerName, double amount) {
        Result result = new Result();
        return customerAction(action, branch, customerName, amount, result);
    }
    // Overloaded
    private static Transaction customerAction(String action, Branch branch
            , String customerName, double amount, Result result) {
        result.setSuppress(suppressSuccess);
        Transaction transaction = null;
        Customer customer = null;
        if (action != "listTransactions") {
            if (amount == 0d) {
                result.setFail(action + ". No amount given");
            }
        }
        if ( result.isSuccess() ) {
            customer = branchAction("findCustomer", branch, customerName, 0d, result);
            if (customer == null) {
                result.setFail(action + ". Customer " + customerName + " not found"
                        + "\n\tfor " + branch.getFullName()
                );
            }
        }
        if (result.isSuccess()) {
            switch (action) {
                case "addTransaction":
                    customer.addTransaction(amount, result);
                    break;
                case "listTransactions":
                    String transactions = "Transactions of " + customer.getCustomerName();
                    ArrayList<String> list = customer.listTransactions();
                    for (int i = 0; i < list.size(); i++) {
                        transactions += "\n\t" + (i == 0 ? "" : "\t") + list.get(i);
                    }
                    transactions += "\n\tEnd balance = " + String.format("%.2f", customer.getBalance() ) ;
                    result.setSucceed(transactions);
                    result.setSuppress(false);
                    break;
                default:
                    result.setFail("No valid action (" + action + ")");
                    break;
            }
        }
        printResult(result);
        return transaction;
    }

    private static void printResult(Result result) {
        if ( ( !result.isSuccess() || !result.isSuppress() ) ) oln(result.toString());
        result.reset();
    }







    private static void test01() {
        Result result; Transaction transaction; Customer customer; Branch branch; Bank bank;
        result = new Result();

        bank   = new Bank("ABN-AMRO"); oln(bank.toString());

        branch = bank.addBranch("2019th Street", result);
            oln(result.toString(), "\t");
            oln(bank.toString());

        customer = branch.addCustomer("", 200d, result);
            oln(result.toString(), "\t");
        customer = branch.addCustomer("Frank Fremont", 1.25d, result);
            oln(result.toString(), "\t");
            oln(customer.toString());

        transaction = customer.addTransaction(100d, result);
            oln(result.toString(), "\t");
            oln(customer.toString());
            oln(transaction.toString());
        transaction = customer.addTransaction(0d, result);
            oln(result.toString(), "\t");
            oln(customer.toString());
        transaction = customer.addTransaction(-200d, result);
            oln(result.toString(), "\t");
            oln(customer.toString());
        transaction = customer.addTransaction(100d, result); oln(customer.toString());
        transaction = customer.addTransaction(200d, result); oln(customer.toString());
        transaction = customer.addTransaction(300d, result); oln(customer.toString());
        transaction = customer.addTransaction(-100d, result); oln(customer.toString());
        transaction = customer.addTransaction(-200d, result); oln(customer.toString());
        transaction = customer.addTransaction(-300d, result); oln(customer.toString());
        oln("Branches " + bank.getBankName() + " :", "");
        printArrayList(bank.listBranches());
        oln("Customers " + branch.getBranchName() + " :", "");
        printArrayList(branch.listCustomers());
        oln("Transactions " + customer.getCustomerName() + " :", "");
        printArrayList(customer.listTransactions());
        oln("End balance = " + String.format("%.2f", customer.getBalance()));

        Bank bank2 = new Bank("Rabobank");
        Branch branch2 = bank2.addBranch("Main Street");
        Customer customer2 = branch2.addCustomer("Wild Wendy", 10000);
        customer2.addTransaction(-2000);
        customer2.addTransaction(-2000);
        customer2.addTransaction(-2000);
        customer2.addTransaction(-2000);
        oln("Transactions " + customer2.getCustomerName() + " :", "");
        printArrayList(customer2.listTransactions());
        oln("End balance = " + String.format("%.2f", customer2.getBalance()));
        oln("Find Shallow Sjaman for branch " + branch2.getBranchName());
        branch2.findCustomer("Shallow Shaman", result);
            oln(result.toString(), "\t");
        oln("Find Wild Wendy for branch " + branch2.getBranchName());
        branch2.findCustomer("Wild Wendy", result);
        oln(result.toString(), "\t");
    }





    // Print ArrayList<String>
    private static void printArrayList(ArrayList<String> array) {
        for (int i = 0; i < array.size(); i++) {
            oln(array.get(i).toString());

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
