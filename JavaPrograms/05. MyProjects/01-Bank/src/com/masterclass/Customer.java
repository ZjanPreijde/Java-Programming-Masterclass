package com.masterclass;

import java.util.ArrayList;

public class Customer {
    String customerName;
    Double balance;
    ArrayList<Transaction> transactions = new ArrayList<>();

    public Customer(String customerName, Double amount) {
        this.customerName = customerName;
        if (amount != 0d) {
            this.transactions.add(new Transaction(amount, true));
        }
        this.balance = amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Double getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public Transaction addTransaction(double amount) {
        Result result = new Result();
        Transaction transaction = addTransaction(amount, result);
        return transaction;
    }
    public Transaction addTransaction(double amount, Result result) {
        if (amount == 0d) {
            result.setFail("Amount transaction was empty");
            return null;
        }
        Transaction transaction = new Transaction( amount, false );
        this.transactions.add( transaction );
        this.balance += amount;
        result.setSucceed("Transaction " + String.format("%.2f", amount) + " added" +
                ", new balance " + String.format("%.2f", getBalance()));
        return transaction;
    }
    public int getTransactionCount() {
        return transactions.size();
    }

    public ArrayList<String> listTransactions() {
        ArrayList<String> list = new ArrayList<>();
        if (this.transactions.size() == 0) {
            list.add("Customer has no transactions");
        } else {
            int start = 0;
            if ( !transactions.get(0).beginBalance ) {
                list.add("Begin balance = " + String.format(" %.2f", 0d));
            } else {
                start = 1;
                list.add("Begin balance = "
                        + String.format(" %.2f", transactions.get(0).getAmount()));
            }
            for (int i = start; i < transactions.size(); i++) {
                list.add(transactions.get(i).toString());
            }
        }
        return list;
    }
    @Override
    public String toString() {
        return String.format("Customer{Name='%s', balance=%s, %d transactions}"
                , customerName, String.format("%.2f", balance), transactions.size());
    }
}
