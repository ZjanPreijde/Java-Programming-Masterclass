package com.example.access;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-16, 13:05
*/

import java.util.ArrayList;

public class Account {
    // Go for it buddy!!
    public String accountName;
    public int balance = 0;
    public ArrayList<Integer> transactions;

    public Account( String accountName ) {
        this.accountName = accountName;
        this.transactions = new ArrayList<>();
        System.out.println("Account created for " + accountName);
    }

    public int getBalance() {
        return balance;
    }

    public void deposit( int amount ) {
        if ( amount > 0 ) {
            transactions.add( amount );
            balance += amount;
            System.out.println( accountName + " deposited, amount " + amount + ". Balance is now " + this.balance);
        } else {
            System.out.println( "Invalid amount (" + amount + ") for transactions" );
        }
    }
    public void withdraw( int amount ) {
        if (amount > 0) {
            transactions.add(-amount);
            balance -= amount;
            System.out.println(accountName + " withdrew, amount " + amount + ". Balance is now " + this.balance);
        } else {
            System.out.println("Invalid amount (" + amount + ") for transactions");
        }
    }
    public void calculateBalance() {
        this.balance = 0;
        for (int t : this.transactions) {
            this.balance += t;
        }
        System.out.println("Calculated balance is " + this.balance);
    }
    public void listTransactions() {
        System.out.println("-----------");
        System.out.println("List of transactions:");
        for (Integer t : transactions) {
            System.out.println("> Amount " + t);
        }
        System.out.println("==========");
        System.out.println("Balance " + getBalance());
    }
}
