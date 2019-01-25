package com.masterclass;

public class VipCustomer {
    private String name, email;
    private double creditLimit;

    // Constructors
    public VipCustomer() {
        this("name", "name@mail.com", 0d);
    }
    public VipCustomer(String name, String email) {
        this(name, email, 0d);
    }
    public VipCustomer(String name, String email, double creditLimit) {
        this.name = name;
        this.email = email;
        this.creditLimit = creditLimit;
    }

    // Getters
    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }
    public double getCreditLimit() {
        return creditLimit;
    }
    public void printData() {
        System.out.println("Vip Customer :");
        System.out.println("Name         : " + this.name);
        System.out.println("Email        : " + this.email);
        System.out.println("Credit Limit : " + String.format("%10.2f", this.creditLimit));
        System.out.println("--------------");
    }
}
