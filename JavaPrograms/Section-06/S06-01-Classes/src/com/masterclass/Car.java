package com.masterclass;

public class Car {
    // State, encapsulated
    private int doors, wheels;
    private String brand, model, engine, colour;
    // State, accessible
    public String description;

    public void setBrand(String brand) { this.brand = brand; }
    public String getBrand()           { return this.brand; }

    public void setModel(String model) {
        this.model = model;
        String lowerModel = model.toLowerCase();
        switch (lowerModel) {
            case "911":
                this.brand = "Porsche";
                this.doors  = 3;
                this.wheels = 4;
                this.engine = "3.6 litre air-cooled boxer flat-six";
                break;
            case "partner":
                this.brand = "Peugeot";
                this.wheels = 4;
        }
    }
    public String getModel() { return this.model; }

    public void printData() {
        System.out.println("--------");
        System.out.println("Brand  : " + (this.brand  == null ? "Unknown" : this.brand));
        System.out.println("Model  : " + (this.model  == null ? "Unknown" : this.model));
        System.out.println("Doors  : " + (this.doors  == 0    ? "Unknown" : this.doors));
        System.out.println("Wheels : " + (this.wheels == 0    ? "Unknown" : this.wheels));
        System.out.println("Engine : " + (this.engine == null ? "Unknown" : this.engine));
    }
}

