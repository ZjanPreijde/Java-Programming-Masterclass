package com.masterclass;

public class Vehicle {
    private int gear, speed, direction;
    // Constructors
    public Vehicle() {
        this(0);
    }
    public Vehicle(int direction) {
        this(0, 0, direction);
    }
    public Vehicle(int gear, int speed, int direction) {
        this.gear      = gear;
        this.speed     = speed;
        this.direction = direction;
    }

    // Public
    public void setGear(int gear, int speedPerGear) {
        this.gear  = gear;
        this.speed = gear * speedPerGear;
    }
    public int getGear() {
        return this.gear;
    }
    public int getSpeed() {
        return this.speed;
    }
    public String getData() {
        return getDirection() + ", gear " + getGear() + ", speed " + getSpeed();
    }
    public void printData() {
        System.out.println("Vehicle : " + getData());
    }

    public void gearUp(int speedPerGear) {
        changeGear(1, speedPerGear);
    }
    public void gearDown(int speedPerGear) {
        changeGear(-1, speedPerGear);
    }
    public void steerLeft() {
        direction = direction - (direction > -1 ? 1 : 0);
    }
    public void steerRight() {
        direction = direction + (direction < 1 ? 1: 0);
    }

    // Private
    private void changeGear(int gearChange, int speedPerGear) {
        gear += gearChange;
        setSpeed(gear * speedPerGear);
    }
    private void setSpeed(int speed) {
        this.speed = speed;
    }
    private String getDirection() {
        if (speed == 0) {
            return "standing still";
        } else {
            String leftRightOrForward;
            switch (direction) {
                case -1:
                    leftRightOrForward = "left";
                    break;
                case 1:
                    leftRightOrForward = "right";
                    break;
                default:
                    leftRightOrForward = "forward";
                    break;
            }
            return "moving " + leftRightOrForward;
        }
    }
}
