package com.masterclass;

public class BankAccount {
    private String accountNumber, name, email, phoneNumber;
    private double balance;
    // Overloading constructor methods
    public BankAccount() {
        this("Unknown accountNumber",
                "Unknown name",
                "unknown@email.com",
                "Unknown phoneNumber");
    }
    public BankAccount(String accountNumber) {
        this(accountNumber,
                "Unknown name", "Unknown email", "Unknown phoneNumber");

    }
    public BankAccount(String accountNumber, String name, String email, String phoneNumber) {
        this(accountNumber, name, email, phoneNumber, 0d);
    }
    public BankAccount(String accountNumber, String name, String email, String phoneNumber,
                       double balance) {
        this.accountNumber = accountNumber;
        this.name          = name;
        this.email         = email;
        this.phoneNumber   = phoneNumber;
        this.balance       = balance;
    }
    // Setters
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public void setName(String name)                   { this.name = name; }
    public void setEmail(String email)                 { this.email = email; }
    public void setPhoneNumber(String phoneNumber)     { this.phoneNumber = phoneNumber; }
    public void setBalance(double balance)             { this.balance = balance; }
    // Getters
    public String getAccountNumber() { return this.accountNumber; }
    public String getName()          { return this.name; }
    public String getEmail()         { return this.email; }
    public String getPhoneNumber()   { return this.phoneNumber; }
    public double getBalance()       { return this.balance; }
    // Other methods
    public void deposit(Double amount) {
        this.balance += amount;
        System.out.println(amount + " deposited into account");
        System.out.println("Balance is now " + this.balance);
    }
    public void withdraw(Double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            System.out.println(amount + " withdrawn from balance");
            System.out.println("Balance is now " + this.balance);
        } else {
            System.out.println("Insufficient funds to withdraw " + amount);
            System.out.println("Balance is " + this.balance);
        }
    }
    public void printData() {
        System.out.println("Account information :");
        System.out.println("AccountNr : " + this.accountNumber);
        System.out.println("Name      : " + this.name);
        System.out.println("Email     : " + this.email);
        System.out.println("PhoneNr   : " + this.phoneNumber);
        System.out.println("Balance   : " + String.format("%10.2f", this.balance));
        System.out.println("---------------------");
    }
}
