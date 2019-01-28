package com.masterclass;

// Create a base class called Car
// It should have a few fields that would be appropriate for a generice car class.
// engine, cylinders, wheels, etc.
// Constructor should initialize cylinders (number of) and name, and set wheels to 4
// and engine to true. Cylinders and names would be passed parameters.
//
// Create appropriate getters
//
// Create some methods like startEngine, accelerate, and brake
//
// show a message for each in the base class
class Car {
    private String name;
    private boolean engineOn;
    private int cylinders, wheels, speed;
    public Car() {
        this("Unknown", false, 4, 4, 0);
    }
    public Car(String name) {
        this(name, false, 4, 4, 0);
    }

    public Car(String name, boolean engineOn, int cylinders, int wheels, int speed) {
        this.name      = name;
        this.engineOn  = engineOn;
        this.cylinders = cylinders;
        this.wheels    = wheels;
        this.speed     = speed;
    }

    public boolean isEngineOn() { return engineOn; }
    public int getCylinders()   { return cylinders; }
    public int getWheels()      { return wheels; }
    public int getSpeed()       { return speed; }
    public String getName()     {
        return (name == "Unknown") ? getClass().getSimpleName() : name ;
    }

    public void startEngine() {
        if (isEngineOn()) {
            oln(getName() + ", engine already ON");
        } else {
            engineOn = true;
            oln(getName() + ", engine started");
        }
    }
    public void stopEngine() {
        if (!isEngineOn()) {
            oln(getName() + ", engine already OFF");
        } else {
            engineOn = false;
            speed    = 0;
            oln(getName() + ", engine stopped");
        }
    }

    public void accelerate  (int amount) { this.changeSpeed(amount); }
    public void brake       (int amount) { this.changeSpeed(-amount); }
    private void changeSpeed(int amount) {
        o("> " + getName() + ", speed was " + getSpeed());
        o(" - Changing speed by " + amount);
        this.speed = (getSpeed() + amount > 0) ? (getSpeed() + amount) : 0 ;
        o(" - speed is " + getSpeed());
        o("\n");
    }
    public String getCarData() {
        return getName() + " : engineOn " + engineOn() + ", speed " + getSpeed()
                + ", cylinders " + getCylinders() + ", wheels " + getWheels() ;
    }
    private String engineOn() { return isEngineOn() ? "ON" : "OFF"; }
    public static void o(String text) {
        System.out.print(text);
    }
    public static void oln(String text) {
        System.out.println("> " + text);
    }
}
class Lincoln extends Car {
    public Lincoln() {
        super("Lincoln");
    }

    @Override
    public void brake(int amount) {
        // Bad brakes
        oln("\n> " + super.getName() + " has bad brakes, attempting to brake by " + amount);
        super.brake((int) (amount / 2));
    }
}
class Partner extends Car {
    public Partner() {
        super("Partner", true, 2, 1, 50);
    }
    @Override
    public void startEngine() {
        // Bad motor
        oln("\n> " + super.getName() + " has a bad engine");
        for (int i=1; i<4;i++) {
            super.startEngine();
            super.stopEngine();
        }
        super.startEngine();
    }
}
class Wreck extends Car {
    public Wreck() {
        super();
    }

    @Override
    public void brake(int amount) {
        // Bad brakes
        oln("\n> " + super.getName() + " has very bad brakes, attempting to brake by " + amount);
        super.brake((int) (amount / 4));
    }
}

public class Main {

    public static void main(String[] args) {
        // We are going to go back to the car analogy.
        // Now create 3 sub classes for your favorite vehicles.
        // Override the appropriate methods to demonstrate polymorphism in use.
        // put all classes in the one java file (this one).
        Car car;
        car = new Car(); oln(car.getCarData());

        oln("--- ");
        car = new Lincoln();    oln(car.getCarData());
        o("Start engine "); car.startEngine();          oln(car.getCarData());
        o("Accelerate ");   car.accelerate(100); oln(car.getCarData());
        o("Brake ");        car.brake(100);      oln(car.getCarData());

        oln("--- ");
        car = new Partner();        oln(car.getCarData());
        o("Start engine "); car.startEngine();          oln(car.getCarData());
        o("Stop  engine "); car.stopEngine();           oln(car.getCarData());
        o("Start engine "); car.startEngine();          oln(car.getCarData());
        o("Accelerate ");   car.accelerate(100); oln(car.getCarData());

        oln("--- ");
        car = new Wreck();        oln(car.getCarData());
        o("Start engine "); car.startEngine();          oln(car.getCarData());
        o("Accelerate ");   car.accelerate(100); oln(car.getCarData());
        o("Brake ");        car.brake(100);      oln(car.getCarData());
    }
    private static void o(String text) {
        System.out.print("- " + text);
    }
    private static void oln(String text) {
        System.out.println("= " + text);
    }

}
