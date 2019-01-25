package com.masterclass;

public class F1Car extends Car {
    private String driver;
    public F1Car() {
        this("Unknown driver");
    }
    public F1Car(String driver) {
        super(10, 0, 40);
        this.driver = driver;
    }
    public String getData() {
        return "Driver " + driver + " : " + super.getData();
    }
    public void printData() {
        System.out.println(getData());
    }
}

