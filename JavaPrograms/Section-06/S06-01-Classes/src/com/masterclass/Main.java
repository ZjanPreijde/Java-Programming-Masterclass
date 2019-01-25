package com.masterclass;

public class Main {

    public static void main(String[] args) {
        Car porsche = new Car();
        porsche.setModel("911");
        porsche.printData();
        Car peugeot = new Car();
        peugeot.setModel("Partner");
        peugeot.printData();
    }
}
