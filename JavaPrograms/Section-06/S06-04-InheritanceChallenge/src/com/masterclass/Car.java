package com.masterclass;

public class Car extends Vehicle {
    private int maxGears, minGears, speedPerGear, maxSpeed, minSpeed;
    public Car() {
        this(5, -1, 30);
    }
    public Car(int maxGears, int minGears, int speedPerGear) {
        this(maxGears, minGears, speedPerGear, (minGears > 0 ? minGears : 0));
    }
    public Car(int maxGears, int minGears, int speedPerGear, int gear) {
        super();
        this.maxGears     = maxGears;
        this.minGears     = minGears;
        this.speedPerGear = speedPerGear;
        this.maxSpeed     = maxGears * speedPerGear;
        this.minSpeed     = minGears * speedPerGear;
        setGear(gear);
    }

    public void setGear(int gear) {
        if (gear >= minGears && gear <= maxGears) {
            super.setGear(gear, speedPerGear);
        }
    }

    public void gearUp() {
        if (getGear() < this.maxGears ) {
            super.gearUp(speedPerGear);
        }
    }
    public void gearDown() {
        if (getGear() > this.minGears) {
            super.gearDown(speedPerGear);
        }
    }
    public String getData() {
        return super.getData() + ", maxGears " + maxGears + ", minGears " + minGears
                + ", speedPerGear " + speedPerGear
                + ", maxSpeed " + maxSpeed + ", minSpeed " + minSpeed;
    }
    public void printData() {
        System.out.println("Car : " + getData());
    }
}
