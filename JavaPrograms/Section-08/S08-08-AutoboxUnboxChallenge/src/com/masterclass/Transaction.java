package com.masterclass;

public class Transaction {
    Double amount;
    boolean beginBalance;

    public Transaction(Double amount, boolean beginBalance) {
        this.amount = amount;
        this.beginBalance = beginBalance;
    }

    @Override
    public String toString() {
//        String format = Double.toString(amount);
        return "Transaction amount = " + String.format("%.2f", amount);
    }

    public Double getAmount() {
        return amount;
    }
}
